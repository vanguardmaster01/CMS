/**
@Developed By Anil Kumar
*/

package com.cms.security.jwt;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.cms.util.Constants;

@Component
public class JwtTokenProvider {

	@Value("${security.jwt.token.secret-key}")
	private String secretKey = "AnilJavaDeveloper";

	@Value("${security.jwt.token.expire-length:1}")
	private int validityInHours = 	72; // 3 days

	@Autowired
	private UserDetailsService userDetailsService;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public String createToken(final String username,final long userid,final List<String> roles,final HttpServletRequest httpReq) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date()); // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, validityInHours); // adds one hour
		Date validity = cal.getTime(); // returns new date object, one hour in the future
		Date now = new Date();
		//log.info("**********************  validity date "+validity+"     ******** Current Date    "+now);
		String token = Jwts.builder()//
				.setClaims(claims)//
				.setSubject(username)
				.setIssuedAt(now)//
				.setExpiration(validity)//
				.signWith(SignatureAlgorithm.HS256, secretKey)//
				.claim("userid", userid).compact();
		HttpSession session = httpReq.getSession();
		session.setAttribute(Constants.HEADER_AUTHORIZATION, Constants.HEADER_PREFIX + token);
		session.setMaxInactiveInterval(259200);
		return token;
	}

	public Authentication getAuthenticaion(final String token) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	public String getUsername(final String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public long getUserId(final String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("userid", Long.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getUserRoles(final String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("roles", List.class);
	}
	
	public Date getExpiryTime(final String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
	}

	public String resolveToken(final HttpServletRequest req) {
		HttpSession session = req.getSession();
		String bearerToken = (String) session.getAttribute(Constants.HEADER_AUTHORIZATION);
		if (bearerToken == null) {
			bearerToken = req.getHeader("Authorization");
			/*System.out.println("Bearer Token FROM HEADER " + bearerToken);*/
			if (bearerToken != null && bearerToken.startsWith(Constants.HEADER_PREFIX)) {
				return bearerToken.substring(7, bearerToken.length());
			}
			return null;
		} else {
			//System.out.println("Bearer Token FROM SESSION " + bearerToken);
		}
		if (bearerToken != null && bearerToken.startsWith(Constants.HEADER_PREFIX)) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	public boolean validateToken(final String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			if (claims.getBody().getExpiration().before(new Date())) {
				return false;
			}
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

}

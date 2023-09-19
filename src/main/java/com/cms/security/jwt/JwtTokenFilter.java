/**
@Developed By Anil Kumar
*/
package com.cms.security.jwt;

import java.io.File;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.cms.util.Constants;

@SuppressWarnings("unused")
public class JwtTokenFilter extends GenericFilterBean {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(final JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		final String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
		//System.out.println("token >> "+token);
		HttpServletRequest httpReq = (HttpServletRequest) req;
		if (token != null && jwtTokenProvider.validateToken(token)) {
			HttpSession session = httpReq.getSession();
			session.setAttribute(Constants.HEADER_AUTHORIZATION, Constants.HEADER_PREFIX + token);
			Authentication auth = jwtTokenProvider.getAuthenticaion(token);
			if (auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}else{
			httpReq.getSession().invalidate();
		}
		filterChain.doFilter(req, res);

	}

}

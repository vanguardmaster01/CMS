/**
@Developed By Anil Kumar
*/
package com.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.support.RequestContext;

import com.cms.model.UnauthenticatedRequestHandler;
import com.cms.security.jwt.JwtConfigurer;
import com.cms.security.jwt.JwtTokenProvider;
import com.cms.util.Constants;
import com.cms.util.WebUrl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private transient JwtTokenProvider jwtTokenProvider; // jwt Token Provider
    
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
		.httpBasic().disable()
		.csrf().disable()
		.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				.and()
				.authorizeRequests()
				.antMatchers("/auth/signin").permitAll()
				.antMatchers("/api/signin").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/upload").permitAll()
				
				.antMatchers("/favicon.ico").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/ws/**").permitAll()
				.antMatchers("/ws").permitAll()
				
				/*FOR WebSite */
				.antMatchers("/public/**").permitAll()
				.antMatchers("/web/**").permitAll()
				
				.antMatchers("/"+WebUrl.login).permitAll()
				.antMatchers(WebUrl.logout).permitAll()
				.antMatchers(WebUrl.verify).permitAll()
				.antMatchers("/"+WebUrl.dashboard).permitAll()				
				
				
				.antMatchers(WebUrl.create).permitAll()
				.antMatchers(WebUrl.users).permitAll()
				.antMatchers(WebUrl.blogs).permitAll()
				.antMatchers(WebUrl.register).permitAll()
				.antMatchers(WebUrl.addUser).permitAll()
				.antMatchers(WebUrl.updateUser).permitAll()
				.antMatchers(WebUrl.deleteUser).permitAll()
				.antMatchers(WebUrl.preview).permitAll()
//				.antMatchers(WebUrl.preview).hasRole("ADMIN")
				
				.antMatchers(WebUrl.createBlog).permitAll()
				.antMatchers(WebUrl.publishBlog).permitAll()
				.antMatchers(WebUrl.deleteBlog).permitAll()
				
				
				
				.antMatchers("/"+WebUrl.addlisting).permitAll()		
				.antMatchers("/"+WebUrl.addlisting+"/**").permitAll()				
			
				.antMatchers(WebUrl.adminUser).hasRole("ADMIN")
				
				.antMatchers("/error").permitAll().anyRequest().authenticated().and()
				.apply(new JwtConfigurer(jwtTokenProvider));
		
		http.exceptionHandling().authenticationEntryPoint(unauthenticatedRequestHandler());
		http.exceptionHandling().accessDeniedPage("/403");
		
		http.exceptionHandling().authenticationEntryPoint(unauthenticatedRequestHandler());	
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout")).logoutSuccessUrl("/admin/login")
			.deleteCookies(Constants.COOKIE_NAME).invalidateHttpSession(true);		
	}


	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		return (request, response, authException) -> response.sendRedirect("/login");
	}
	
	@Bean
    UnauthenticatedRequestHandler unauthenticatedRequestHandler() {
        return new UnauthenticatedRequestHandler();
    }
}
/**
@Developed By Anil Kumar
*/

package com.cms.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.cms.util.WebUrl;

public class UnauthenticatedRequestHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        System.out.println("Request coming here....!!! "+request.getServletPath());
    	if(request.getServletPath().startsWith("/admin/")) {
        	response.sendRedirect("/admin/login");
        }/*else if(request.getServletPath().startsWith("/admin/createlisting/")) {
        	response.sendRedirect(WebUrl.admincreatelisting);
        }*/else if(request.getServletPath().startsWith("/verify")) {
        	response.sendRedirect("/login?flag=404");
        }else {
            response.sendRedirect(request. getContextPath() +WebUrl.error);
        }
    }
    
}

/**
@Developed By Anil Kumar
*/
package com.cms.security.jwt;

import javax.naming.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 1L;
	
	public InvalidJwtAuthenticationException(String e) {
        super(e);
    }
}
package com.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CmsApplication 
extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncode() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}

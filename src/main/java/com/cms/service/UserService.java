package com.cms.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.cms.model.User;
import com.cms.repository.UserDao;
import com.cms.security.jwt.JwtTokenProvider;
import com.cms.util.Constants;


@Service

public class UserService {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public boolean login(HttpServletRequest request) {
//		Map<String, Object> resultMap = new HashMap<>();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		User user = userDao.findByEmail(email);
//		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), pwd));
//		
//		jwtTokenProvider.createToken(user.getUsername(), user.getUserid(), user.getRoles(), request);
		
		if(user == null) {
//			resultMap.put("status", Constants.no_exist);
			return false;
		}else {
			if(user.getPassword().equals(pwd)) {
//				resultMap.put("status", Constants.success);
				request.getSession().setAttribute("user", user);
				return true;
			}else {
//				resultMap.put("status", Constants.fail);
				return false;
			}
		}		
//		return resultMap;
	}
}

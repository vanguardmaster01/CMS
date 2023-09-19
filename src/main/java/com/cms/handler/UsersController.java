package com.cms.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.model.User;
import com.cms.repository.UserDao;
import com.cms.util.Constants;
import com.cms.util.WebUrl;

@Controller
public class UsersController {
	@Autowired
	UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	
	@RequestMapping(value= {WebUrl.users},method= {RequestMethod.GET})
	public ModelAndView users(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(WebUrl.users);
				
		modelAndView.addObject("type", 2);
		return modelAndView;
	}
	
	@RequestMapping(value= {WebUrl.addUser},method= {RequestMethod.POST})
	public @ResponseBody Map addUser(HttpServletRequest request, @RequestParam("email") String email,  
			@RequestParam("password") String password) {
		
		Map<String, Object> result = new HashMap<>();
		try {
			User user = userDao.findByEmail(email);
			if(user == null) {
				user = new User();
				user.setEmail(email);
				user.setPassword(password);
				userDao.save(user);
				result.put("status", Constants.success);				
			}else {
				result.put("status", Constants.already);
			}
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", Constants.fail);
		}
		
		return result;
	}

	@RequestMapping(value= {WebUrl.updateUser},method= {RequestMethod.POST})
	public @ResponseBody Map updateUser(HttpServletRequest request, @RequestParam("email") String email,  
			@RequestParam("password") String password, @RequestParam("userid") long userid) {
		
		Map<String, Object> result = new HashMap<>();
		try {
			User user = userDao.findByUserid(userid);
			if(user == null) {				
				result.put("status", "no exist");				
			}else {
				user.setEmail(email);
				user.setPassword(password);
				userDao.save(user);
				result.put("status", Constants.success);
			}
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", Constants.fail);
		}
		
		return result;
	}
	
	@RequestMapping(value= {WebUrl.deleteUser},method= {RequestMethod.POST})
	public @ResponseBody Map deleteUser(HttpServletRequest request, @RequestParam("userid") long userid) {
		
		Map<String, Object> result = new HashMap<>();
		try {
			User user = userDao.findByUserid(userid);
			if(user == null) {
				result.put("status", Constants.no_exist);
			}else {
				userDao.deleteById(userid);
				result.put("status", Constants.success);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

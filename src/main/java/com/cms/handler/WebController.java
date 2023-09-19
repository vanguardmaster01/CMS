package com.cms.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.model.User;
import com.cms.repository.UserDao;
import com.cms.service.UserService;
import com.cms.util.WebUrl;

@Controller

public class WebController {
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping(value= {WebUrl.index,"/"},method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request, HttpSession session) {		
		User loginuser = (User)session.getAttribute("user");
		if(loginuser == null) {
//			response.sendRedirect(WebUrl.login);
			ModelAndView modelAndView = new ModelAndView("redirect:"+ WebUrl.login);				
			return modelAndView;
		}else {			
			ModelAndView modelAndView = new ModelAndView("redirect:"+ WebUrl.create);
			return modelAndView;
		}
	}
	
	@RequestMapping(value= {WebUrl.create},method= {RequestMethod.GET})
	public ModelAndView create(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(WebUrl.create);
				
		modelAndView.addObject("type", 0);
		return modelAndView;
	}
}

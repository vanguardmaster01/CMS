package com.cms.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.model.User;
import com.cms.repository.UserDao;
import com.cms.security.jwt.JwtTokenProvider;
import com.cms.service.UserService;
import com.cms.util.Constants;
import com.cms.util.WebUrl;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private RequestCache requestCache = new HttpSessionRequestCache();
    
	/************************************** login Page *******************************************/
	@RequestMapping(value= {WebUrl.login},method= {RequestMethod.GET})
	public ModelAndView login(HttpServletRequest request, @RequestParam(required=false) String flag) {
		ModelAndView modelAndView = new ModelAndView("auth/" + WebUrl.login);
		
		return modelAndView;
	}
	
	@RequestMapping(value= {WebUrl.login},method= {RequestMethod.POST})
	public String postLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if( userService.login(request)) {
            if (savedRequest != null) {
                return "redirect:" + savedRequest.getRedirectUrl();
            } else {
            	return "redirect:" + WebUrl.create;
            }
		} else
			return "/" + WebUrl.login;
	}
	
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
    	request.logout();
        return "redirect:/";
    }
}

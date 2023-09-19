package com.cms.handler;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import com.cms.model.Blog;
import com.cms.repository.BlogDao;
import com.cms.util.Constants;
import com.cms.util.WebUrl;

@Controller
public class BlogsController {
	@Autowired
	BlogDao blogDao;

	@Value("${upload_path}")
	private String uploadPath;
	
	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(BlogsController.class);
	
	@RequestMapping(value= {WebUrl.blogs},method= {RequestMethod.GET})
	public ModelAndView blogs(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(WebUrl.blogs);
		List<Blog> blogList = blogDao.findAllNotDeleted();
		
		modelAndView.addObject("type", 1);
		modelAndView.addObject("blogs", blogList);
		return modelAndView;
	}
	
	/********************************* Delete Blog ***********************************/	
	@RequestMapping(value= {WebUrl.deleteBlog}, method= {RequestMethod.POST})
	public @ResponseBody Map deleteBlog(HttpServletRequest request, @RequestParam("id") Long id) {
		Map<String, Object> result = new HashMap<>();
		try {
			Blog blog = blogDao.findByid(id);
			
			blog.setStatus(2);
			blogDao.save(blog);
			result.put("status", Constants.success);
			
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", Constants.fail);
		}
		
		return result;
	}
}

package com.cms.handler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cms.model.Blog;
import com.cms.repository.BlogDao;
import com.cms.util.Constants;
import com.cms.util.WebUrl;

@Controller
public class PreviewController {
	@Autowired
	BlogDao blogDao;

	@Value("${upload_path}")
	private String uploadPath;

	
	private static final Logger logger = LoggerFactory.getLogger(PreviewController.class);
	
	@RequestMapping(value= {WebUrl.preview},method= {RequestMethod.GET})
	public ModelAndView preview(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(WebUrl.preview);
		String stringId =  request.getParameter("id");
		String stringType =  request.getParameter("type");
		int type = Integer.parseInt(stringType);
		Long id = Long.parseLong(stringId.trim());
		Blog blog = blogDao.findByid(id);
		String image = blog.getImagepath();
		String title = blog.getTitle();
		String content = blog.getContent();
		String createdat = blog.getCreatedat();
		modelAndView.addObject("id", id);
		modelAndView.addObject("type", type);
		modelAndView.addObject("image", image);
		modelAndView.addObject("title", title);
		modelAndView.addObject("content", content);
		modelAndView.addObject("createdat", createdat);
		return modelAndView;
	}
	
	/********************************* Publish Blog ***********************************/	
	@RequestMapping(value= {WebUrl.publishBlog}, method= {RequestMethod.POST})
	public @ResponseBody Map publishBlog(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("title") String title, 
			@RequestParam("content") String content) {
		Map<String, Object> result = new HashMap<>();
		try {
			Blog blog = blogDao.findByid(id);
			
			blog.setStatus(1);
			
			blog.setTitle(title);
			blog.setContent(content);
			
			blogDao.save(blog);
			result.put("status", Constants.success);
			
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", Constants.fail);
		}
		
		return result;
	}
}

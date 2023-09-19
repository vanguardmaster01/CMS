package com.cms.handler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
public class BlogController {
	@Autowired
	BlogDao blogDao;

	@Value("${upload_path}")
	private String uploadPath;

	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	/********************************* Create Blog ***********************************/	
	@RequestMapping(value= {WebUrl.createBlog}, method= {RequestMethod.POST})
	public @ResponseBody Map createBlog(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("content") String content, 
			@RequestParam("attachfile") MultipartFile attachfile, @RequestParam("metatags") String metatags, @RequestParam("alttags") String alttags, @RequestParam("metadescription") String metadescription, 
			@RequestParam("slug") String slug, @RequestParam("tags") String tags) {
		Map<String, Object> result = new HashMap<>();
		try {
			Blog blog = new Blog();
			String fileName = attachfile.getOriginalFilename();
			String imagePath = uploadPath  + fileName;
			attachfile.transferTo( new File(imagePath));
			
			blog.setTitle(title);
			blog.setContent(content);
			blog.setImagepath(fileName);
			blog.setMetatags(metatags);
			blog.setAlttags(alttags);
			blog.setMetadescription(metadescription);
			blog.setSlug(slug);
			blog.setTags(tags);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MMM dd, yyyy hh:mm a");
		    LocalDateTime now = LocalDateTime.now();
		    blog.setCreatedat(dtf.format(now));
			
			blogDao.save(blog);
			long cnt = blogDao.count();
			result.put("status", Constants.success);
			result.put("maxid", cnt);
			
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", Constants.fail);
		}
		
		return result;
	}
}

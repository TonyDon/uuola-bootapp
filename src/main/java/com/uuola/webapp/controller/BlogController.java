/*
 * @(#)BlogController.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.entity.BlogPost;
import com.uuola.webapp.service.BlogInfoService;
import com.uuola.webapp.service.BlogPostService;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    
    @Autowired
    private BlogInfoService blogInfoService;
    
    @Autowired
    private BlogPostService blogPostService;
    
    @GetMapping("/{title}/{id}")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("blog-show");
        BlogInfo blogInfo = blogInfoService.get(id);
        BlogPost blogPost = blogPostService.get(id);
        mv.addObject("blogInfo", blogInfo);
        mv.addObject("blogPost", blogPost);
        return mv;
    }

}

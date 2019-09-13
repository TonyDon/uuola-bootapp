/*
 * @(#)BlogController.java 2018年11月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.query.BlogInfoQuery;
import com.uuola.webapp.service.BlogService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.support.view.Page;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年11月10日
 * </pre>
 */
@RestController("FaceBlogController")
@RequestMapping("/blog")
public class BlogController extends BaseController {
    
    @Autowired
    BlogService blogService;

    @GetMapping("")
    public ModelAndView index() {
        return makeModelView();
    }
    
    @GetMapping("/list")
    public ModelAndView list(BlogInfoQuery query) {
        ModelAndView mv = makeModelView();
        Page<BlogInfo> pageData = blogService.findBlogInfoBy(query);
        mv.addObject("pageData", pageData);
        return mv;
    }
    
    @GetMapping("/{id}/{title}")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = makeModelView();
        BlogDTO blog = blogService.get(id);
        BlogInfoQuery query = new BlogInfoQuery();
        query.setCid(blog.getBlogCatalog().getId());
        List<BlogInfo> recomm = blogService.findRecommended(query);
        mv.addObject("blog", blog);
        mv.addObject("recomm", recomm);
        return mv;
    }
}

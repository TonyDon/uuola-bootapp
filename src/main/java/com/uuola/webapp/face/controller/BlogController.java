/*
 * @(#)BlogController.java 2018年11月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.service.BlogService;
import com.uuola.webapp.support.view.BaseController;


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
    
    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = makeModelView();
        BlogDTO blog = blogService.get(id);
        mv.addObject("blog", blog);
        return mv;
    }
}

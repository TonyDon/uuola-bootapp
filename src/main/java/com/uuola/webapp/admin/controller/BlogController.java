/*
 * @(#)BlogInfoController.java 2018-10-04 14:40:07
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.model.dto.Page;
import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.query.BlogInfoQuery;
import com.uuola.webapp.service.BlogInfoService;
import com.uuola.webapp.service.BlogService;
import com.uuola.webapp.support.view.BaseController;

/**
 * <pre>
 *
 * @author tonydon
 * by make_bootapp_skt.py script generated
 * at 2018-10-04 14:40:07
 * </pre>
 */
@RestController
@RequestMapping("/admin-console/blog")
public class BlogController extends BaseController{
    
    @Autowired
    private BlogService blogService;
    
    @Autowired
    BlogInfoService blogInfoService;
    
    @GetMapping("")
    public ModelAndView index() {
        return makeModelView();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Long id) {
        BlogDTO  blog = blogService.get(id);
        blog.configSid();
        return ResponseEntity.ok(blog);
    }

    @PostMapping("")
    public ResponseEntity<?> create(BlogDTO blog){
        return ResponseEntity.ok(blogService.create(blog));
    }
    
    @PutMapping("")
    public ResponseEntity<?> update(BlogDTO blog){
        int n = blogService.update(blog);
        return ResponseEntity.ok(n);
    }
    
    @DeleteMapping(value="", params="ids[]")
    public ResponseEntity<?> bulkDelete(@RequestParam("ids[]") List<Long> ids) {
        Integer n = blogService.bulkDelete(ids);
        return ResponseEntity.ok(n);
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> search(BlogInfoQuery query){
        Page<BlogInfo> page = blogInfoService.rangePage(query);
        page.getDataSet().forEach(d->{
            d.configSid();
        });
        return ResponseEntity.ok(page);
    }
}

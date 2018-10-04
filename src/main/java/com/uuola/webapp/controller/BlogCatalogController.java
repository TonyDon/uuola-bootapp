/*
 * @(#)BlogCatalogController.java 2018-10-04 14:33:34
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.entity.BlogCatalog;
import com.uuola.webapp.service.BlogCatalogService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.util.DateUtil;

/**
 * <pre>
 *
 * @author tonydon
 * by make_bootapp_skt.py script generated
 * at 2018-10-04 14:33:34
 * </pre>
 */
@RestController
@RequestMapping("/blogcatalog")
public class BlogCatalogController extends BaseController{
    
    @Autowired
    private BlogCatalogService blogCatalogService;
    
    @GetMapping("")
    public ModelAndView index() {
        return makeModelView();
    }

    @PostMapping("")
    public ResponseEntity<?> create(BlogCatalog entity){
        entity.setCreateTime(DateUtil.getNowTime());
        entity.setUpdateTime(entity.getCreateTime());
        blogCatalogService.insert(entity);
        return ResponseEntity.ok(entity);
    }
}

/*
 * @(#)SysCfgController.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.query.SysCfgQuery;
import com.uuola.webapp.service.SysCfgService;
import com.uuola.webapp.support.view.BaseController;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@RestController
@RequestMapping("/admin-console/syscfg")
public class SysCfgController extends BaseController{

    @Autowired
    private SysCfgService sysCfgService;
    
    @GetMapping("")
    public ModelAndView index() {
        return this.makeModelView();
    }
    
    @GetMapping("/search")
    public ResponseEntity<Object> search(SysCfgQuery query){
        return ResponseEntity.ok(sysCfgService.rangePage(query));
    }
}

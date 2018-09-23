/*
 * @(#)SysCfgController.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.model.query.SysCfgQuery;
import com.uuola.webapp.service.SysCfgService;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@RestController
@RequestMapping("/sys-cfg")
public class SysCfgController {

    @Autowired
    private SysCfgService sysCfgService;
    
    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    
    @GetMapping("/search")
    public ResponseEntity<Object> search(SysCfgQuery query){
        query.filter();
        return ResponseEntity.ok(sysCfgService.range(query));
    }
}

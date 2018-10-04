/*
 * @(#)BlogInfoController.java 2018-10-04 14:40:07
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
@RequestMapping("/bloginfo")
public class BlogInfoController extends BaseController{
    
    @GetMapping("")
    public ModelAndView index() {
        return makeModelView();
    }

}
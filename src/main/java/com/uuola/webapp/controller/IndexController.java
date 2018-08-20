/*
 * @(#)IndexController.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", UUID.randomUUID().toString());
        mv.addObject("time", LocalDateTime.now());
        return mv;
    }
}

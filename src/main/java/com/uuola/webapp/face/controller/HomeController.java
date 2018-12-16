/*
 * @(#)IndexController.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.util.DateUtil;
import com.uuola.webapp.util.IdGenerator;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
@RestController
@RequestMapping("/")
public class HomeController extends BaseController{


    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = makeModelView();
        mv.addObject("name", UUID.randomUUID().toString());
        mv.addObject("time", DateUtil.getNowTime());
        mv.addObject("id", IdGenerator.INSTANCE.nextId());
        return mv;
    }
    
    @GetMapping("/show")
    public ResponseEntity<Object> show(HttpServletRequest request){
        Map<String, Object> data = Maps.newHashMap();
        data.put("class", this.getClass().getCanonicalName());
        data.put("time", System.currentTimeMillis());
        data.put("realpath('/')", request.getServletContext().getRealPath("/"));
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/ctx.js")
    public ResponseEntity<?> outContextPath(WebRequest request){
        String ctx = String.format("window.ctx='%s';", request.getContextPath());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/x-javascript;charset=UTF-8")).body(ctx);
    }
    
}

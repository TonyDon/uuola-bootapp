/*
 * @(#)IndexController.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.uuola.webapp.model.entity.SiteCfg;
import com.uuola.webapp.model.query.SiteCfgQuery;
import com.uuola.webapp.service.SiteCfgService;

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
    
    @Autowired
    private SiteCfgService siteCfgService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", UUID.randomUUID().toString());
        mv.addObject("time", LocalDateTime.now());
        return mv;
    }
    
    @GetMapping("show")
    public ResponseEntity<Object> show(){
        Map<String, Object> data = Maps.newHashMap();
        data.put("class", this.getClass().getCanonicalName());
        data.put("time", System.currentTimeMillis());
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/site-cfg/list")
    public ResponseEntity<Object> listSiteCfg(SiteCfgQuery query){
        List<SiteCfg> list = siteCfgService.list(query);
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/site-cfg/{id}")
    public ResponseEntity<Object> showSiteCfg(@PathVariable("id") Integer id){
        SiteCfg siteCfg = siteCfgService.get(id);
        return ResponseEntity.ok(siteCfg);
    }
}

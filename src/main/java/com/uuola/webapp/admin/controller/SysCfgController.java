/*
 * @(#)SysCfgController.java 2018年9月23日
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

import com.uuola.webapp.model.entity.SysCfg;
import com.uuola.webapp.model.query.SysCfgQuery;
import com.uuola.webapp.service.SysCfgService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.util.DateUtil;

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
        return makeModelView();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Integer id) {
        SysCfg  entity = sysCfgService.get(id);
        return ResponseEntity.ok(entity);
    }
    
    @PostMapping("")
    public ResponseEntity<?> create(SysCfg entity){
        entity.setCreateTime(DateUtil.getNowTime());
        entity.setUpdateTime(entity.getCreateTime());
        sysCfgService.insert(entity);
        return ResponseEntity.ok(entity);
    }
    
    @PutMapping("")
    public ResponseEntity<?> update(SysCfg entity){
        entity.setUpdateTime(DateUtil.getNowTime());
        int n = sysCfgService.update(entity);
        return ResponseEntity.ok(n);
    }
    
    @DeleteMapping(value="", params="ids[]")
    public ResponseEntity<?> bulkDelete(@RequestParam("ids[]") List<Integer> ids) {
        Integer n = sysCfgService.bulkDelete(ids);
        return ResponseEntity.ok(n);
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> search(SysCfgQuery query){
        return ResponseEntity.ok(sysCfgService.rangePage(query));
    }
}

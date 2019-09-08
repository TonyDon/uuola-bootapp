/*
 * @(#)NcInfoController.java 2019-09-08 11:31:46
 * 
 * Copy Right@ uuola.com
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

import com.uuola.webapp.model.entity.NcInfo;
import com.uuola.webapp.model.query.NcInfoQuery;
import com.uuola.webapp.service.NcInfoService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.util.DateUtil;

/**
 * <pre>
 * 农产品供销信息
 * @author tonydon
 * by bootapp_skt_maker.py v1.0 generated
 * at 2019-09-08 11:31:46
 * </pre>
 */
@RestController
@RequestMapping("/ncinfo")
public class NcInfoController extends BaseController{

    @Autowired
    private NcInfoService ncInfoService;
    
    @GetMapping("")
    public ModelAndView index() {
        return makeModelView();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Long id) {
        NcInfo  entity = ncInfoService.get(id);
        return ResponseEntity.ok(entity);
    }
    
    @PostMapping("")
    public ResponseEntity<?> create(NcInfo entity){
        entity.setCreateTime(DateUtil.getNowTime());
        entity.setUpdateTime(entity.getCreateTime());
        ncInfoService.insert(entity);
        return ResponseEntity.ok(entity);
    }
    
    @PutMapping("")
    public ResponseEntity<?> update(NcInfo entity){
        entity.setUpdateTime(DateUtil.getNowTime());
        int n = ncInfoService.update(entity);
        return ResponseEntity.ok(n);
    }
    
    @DeleteMapping(value="", params="ids[]")
    public ResponseEntity<?> bulkDelete(@RequestParam("ids[]") List<Long> ids) {
        Integer n = ncInfoService.bulkDelete(ids);
        return ResponseEntity.ok(n);
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> search(NcInfoQuery query){
        return ResponseEntity.ok(ncInfoService.rangePage(query));
    }

}

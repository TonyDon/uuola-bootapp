/*
 * @(#)NcPriceStatController.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.query.NcPriceStatQuery;
import com.uuola.webapp.service.NcPriceStatService;
import com.uuola.webapp.support.view.BaseController;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月10日
 * </pre>
 */
@RestController
@RequestMapping("/ncpricestat")
public class NcPriceStatController extends BaseController{
    
    @Autowired
    private NcPriceStatService ncPriceStatService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return ResponseEntity.ok(ncPriceStatService.get(id));
    }
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(NcPriceStatQuery query){
        return ResponseEntity.ok(ncPriceStatService.list(query));
    }
    
    @GetMapping("/statPriceRpt")
    public ResponseEntity<Object> statPriceRpt(NcPriceStatQuery query){
        List<NcPriceRpt> rpts = ncPriceStatService.statPriceRpt(query);
        return ResponseEntity.ok(rpts);
    }
    

}

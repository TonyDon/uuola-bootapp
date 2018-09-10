/*
 * @(#)NcMarketController.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuola.webapp.model.query.NcMarketQuery;
import com.uuola.webapp.service.NcMarketService;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月10日
 * </pre>
 */
@RestController
@RequestMapping("/nc-market")
public class NcMarketController {

    @Autowired
    private NcMarketService ncMarketService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return ResponseEntity.ok(ncMarketService.get(id));
    }
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(NcMarketQuery query){
        return ResponseEntity.ok(ncMarketService.list(query));
    }
    
}

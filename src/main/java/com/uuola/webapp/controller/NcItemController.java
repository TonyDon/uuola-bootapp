/*
 * @(#)NcZoneController.java 2018年9月8日
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

import com.uuola.webapp.model.query.NcItemQuery;
import com.uuola.webapp.service.NcItemService;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@RestController
@RequestMapping("/nc-item")
public class NcItemController {

    @Autowired
    private NcItemService ncItemService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return ResponseEntity.ok(ncItemService.get(id));
    }
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(NcItemQuery query){
        return ResponseEntity.ok(ncItemService.list(query));
    }
}
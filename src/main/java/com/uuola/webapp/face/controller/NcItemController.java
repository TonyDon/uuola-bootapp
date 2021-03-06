/*
 * @(#)NcZoneController.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuola.webapp.model.query.NcItemQuery;
import com.uuola.webapp.service.NcItemService;
import com.uuola.webapp.support.view.BaseController;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@RestController
@RequestMapping("/ncitem")
public class NcItemController extends BaseController{

    @Autowired
    private NcItemService ncItemService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return ResponseEntity.ok(ncItemService.get(id));
    }
    
    @GetMapping("/itemId/{itemId}")
    public ResponseEntity<Object> show(@PathVariable("itemId") Integer itemId){
        return ResponseEntity.ok(ncItemService.getByItemId(itemId));
    }
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(NcItemQuery query){
        return ResponseEntity.ok(ncItemService.list(query));
    }
}

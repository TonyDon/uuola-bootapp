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

import com.uuola.webapp.model.query.NcZoneQuery;
import com.uuola.webapp.service.NcZoneService;
import com.uuola.webapp.support.view.BaseController;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@RestController
@RequestMapping("/nczone")
public class NcZoneController extends BaseController{

    @Autowired
    private NcZoneService ncZoneService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return ResponseEntity.ok(ncZoneService.get(id));
    }
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(NcZoneQuery query){
        return ResponseEntity.ok(ncZoneService.list(query));
    }
}

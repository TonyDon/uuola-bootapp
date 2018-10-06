/*
 * @(#)NcZoneController.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuola.webapp.model.query.NcPriceRptQuery;
import com.uuola.webapp.service.NcPriceRptService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.task.NcPriceStatReportProcessor;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@RestController
@RequestMapping("/ncpricerpt")
public class NcPriceRptController extends BaseController{

    @Autowired
    private NcPriceRptService ncPriceRptService;
    
    @Autowired
    private NcPriceStatReportProcessor reportProcessor;
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return ResponseEntity.ok(ncPriceRptService.get(id));
    }
    
    @GetMapping("/list")
    public ResponseEntity<Object> list(NcPriceRptQuery query){
        return ResponseEntity.ok(ncPriceRptService.list(query));
    }
    
    @GetMapping("/execute")
    public ResponseEntity<Object> execute(NcPriceRptQuery query){
               reportProcessor.execute(query.getYear(), query.getMonth());
        return ResponseEntity.ok("done.");
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(NcPriceRptQuery query){
        return ResponseEntity.ok(ncPriceRptService.remove(query));
    }
}

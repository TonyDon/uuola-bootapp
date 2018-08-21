/*
 * @(#)SiteCfgService.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.io.Serializable;
import java.util.List;

import com.uuola.webapp.model.entity.SiteCfg;
import com.uuola.webapp.model.query.SiteCfgQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
public interface SiteCfgService {

    SiteCfg get(Serializable id);
    
    List<SiteCfg> list(SiteCfgQuery query);
}

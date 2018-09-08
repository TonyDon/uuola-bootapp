/*
 * @(#)SiteCfgServiceImpl.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.dao.SiteCfgMapper;
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
@Service
public class SiteCfgServiceImpl implements SiteCfgService {
    
    @Autowired
    private SiteCfgMapper siteCfgMapper;

    @Override
    public SiteCfg get(Serializable id) {
        return siteCfgMapper.get(id);
    }

    @Override
    public List<SiteCfg> list(SiteCfgQuery query) {
        return siteCfgMapper.list(query);
    }

}

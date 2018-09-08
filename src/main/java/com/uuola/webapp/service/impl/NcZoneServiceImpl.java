/*
 * @(#)NcZoneServiceImpl.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.dao.NcZoneMapper;
import com.uuola.webapp.model.entity.NcZone;
import com.uuola.webapp.model.query.NcZoneQuery;
import com.uuola.webapp.service.NcZoneService;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@Service
public class NcZoneServiceImpl implements NcZoneService {
    
    @Autowired
    private NcZoneMapper ncZoneMapper;

    @Override
    public NcZone get(Serializable id) {
        return ncZoneMapper.get(id);
    }

    @Override
    public List<NcZone> list(NcZoneQuery query) {
        return ncZoneMapper.list(query);
    }

}

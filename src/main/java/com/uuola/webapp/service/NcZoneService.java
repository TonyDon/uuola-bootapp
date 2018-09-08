/*
 * @(#)NcZoneService.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.io.Serializable;
import java.util.List;

import com.uuola.webapp.model.entity.NcZone;
import com.uuola.webapp.model.query.NcZoneQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
public interface NcZoneService {

    NcZone get(Serializable id);
    
    List<NcZone> list(NcZoneQuery query);
}

/*
 * @(#)NcZoneServiceImpl.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.NcZone;
import com.uuola.webapp.service.NcZoneService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@Service
@PrimaryTx
public class NcZoneServiceImpl extends CrudOperator<NcZone> implements NcZoneService {

    @Override
    public NcZone getByZoneId(Integer zoneId) {
        List<NcZone> list = this.crudDAO.findByField("zoneId", zoneId);
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

}

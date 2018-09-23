/*
 * @(#)SysCfgServiceImpl.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.SysCfg;
import com.uuola.webapp.service.SysCfgService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@Service
@PrimaryTx
public class SysCfgServiceImpl extends CrudOperator<SysCfg> implements SysCfgService {

    @Override
    public SysCfg getByName(String name) {
        List<SysCfg> list= crudDAO.findByField("name", name);
        return CollectionUtils.isEmpty(list) ? null  : list.get(0);
    }


}

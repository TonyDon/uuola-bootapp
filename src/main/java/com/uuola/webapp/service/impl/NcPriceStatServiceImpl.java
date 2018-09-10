/*
 * @(#)NcPriceStatServiceImpl.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.dao.NcPriceStatDAO;
import com.uuola.webapp.model.entity.NcPriceStat;
import com.uuola.webapp.model.query.NcPriceStatQuery;
import com.uuola.webapp.service.NcPriceStatService;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月10日
 * </pre>
 */
@Service
public class NcPriceStatServiceImpl implements NcPriceStatService {
    
    @Autowired
    private NcPriceStatDAO ncPriceStatDAO;

    /* (non-Javadoc)
     * @see com.uuola.webapp.service.NcPriceStatService#get(java.io.Serializable)
     */
    @Override
    public NcPriceStat get(Serializable id) {
        return ncPriceStatDAO.findById(id);
    }

    /* (non-Javadoc)
     * @see com.uuola.webapp.service.NcPriceStatService#list(com.uuola.webapp.model.query.NcPriceStatQuery)
     */
    @Override
    public List<NcPriceStat> list(NcPriceStatQuery query) {
        return ncPriceStatDAO.selectList("list", query);
    }

}

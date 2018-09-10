/*
 * @(#)NcPriceStatService.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.io.Serializable;
import java.util.List;

import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.entity.NcPriceStat;
import com.uuola.webapp.model.query.NcPriceStatQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月10日
 * </pre>
 */
public interface NcPriceStatService {

    NcPriceStat get(Serializable id);
    
    List<NcPriceStat> list(NcPriceStatQuery query);
    
    NcPriceRpt statPriceRpt(NcPriceStatQuery query);
}

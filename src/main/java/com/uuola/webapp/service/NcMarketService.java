/*
 * @(#)NcMarketService.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.io.Serializable;
import java.util.List;

import com.uuola.webapp.model.entity.NcMarket;
import com.uuola.webapp.model.query.NcMarketQuery;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月10日
 * </pre>
 */
public interface NcMarketService {


    NcMarket get(Serializable id);
    
    List<NcMarket> list(NcMarketQuery query);
    
}

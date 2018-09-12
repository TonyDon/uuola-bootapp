/*
 * @(#)NcPriceRptService.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.util.Collection;
import java.util.List;

import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.query.NcPriceRptQuery;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
public interface NcPriceRptService {

    void insert(NcPriceRpt entity);
    
    void batchInsert(Collection<NcPriceRpt> entitis);

    List<NcPriceRpt> list(NcPriceRptQuery query);

    NcPriceRpt get(Long id);
}

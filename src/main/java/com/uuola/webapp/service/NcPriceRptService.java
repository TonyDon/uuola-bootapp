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
    
    /**
     * 根据年月判断是否存在统计记录
     * @param year
     * @param month
     * @return
     */
    Boolean isExistYearMonthReport(Integer year, Integer month);
    
    /**
     * 通过年月删除报表记录
     * @param year
     * @param month
     * @return
     */
    Integer remove(NcPriceRptQuery query);
}

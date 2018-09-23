/*
 * @(#)NcPriceRptService.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.util.Collection;

import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.query.NcPriceRptQuery;
import com.uuola.webapp.support.db.CrudService;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
public interface NcPriceRptService extends CrudService<NcPriceRpt>{
    
    void batchInsert(Collection<NcPriceRpt> entitis);
    
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

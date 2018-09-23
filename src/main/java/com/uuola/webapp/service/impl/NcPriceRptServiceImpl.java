/*
 * @(#)NcPriceRptServiceImpl.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.query.NcPriceRptQuery;
import com.uuola.webapp.service.NcPriceRptService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
@Service
@PrimaryTx
public class NcPriceRptServiceImpl extends CrudOperator<NcPriceRpt> implements NcPriceRptService {

    @Override
    public void batchInsert(Collection<NcPriceRpt> entitis) {
        if(CollectionUtils.isNotEmpty(entitis)) {
            for(NcPriceRpt rpt : entitis) {
                crudDAO.insert(rpt);
            }
        }
    }


    @Override
    public Boolean isExistYearMonthReport(Integer year, Integer month) {
        NcPriceRptQuery query = new NcPriceRptQuery();
        query.setYear(year);
        query.setMonth(month);
        List<Integer> list = crudDAO.selectList("isExistYearMonthReport", query);
        return CollectionUtils.isNotEmpty(list);
    }


    @Override
    public Integer remove(NcPriceRptQuery query) {
        return crudDAO.deleteByMapper("remove", query);
    }

}

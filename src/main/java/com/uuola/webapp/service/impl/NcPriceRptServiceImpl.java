/*
 * @(#)NcPriceRptServiceImpl.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.dao.NcPriceRptDAO;
import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.query.NcPriceRptQuery;
import com.uuola.webapp.service.NcPriceRptService;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
@Service
public class NcPriceRptServiceImpl implements NcPriceRptService {
    
    @Autowired
    private NcPriceRptDAO ncPriceRptDAO;

    
    @Override
    public void insert(NcPriceRpt entity) {
        ncPriceRptDAO.insert(entity);
    }


    @PrimaryTx
    @Override
    public void batchInsert(Collection<NcPriceRpt> entitis) {
        if(CollectionUtils.isNotEmpty(entitis)) {
            for(NcPriceRpt rpt : entitis) {
                ncPriceRptDAO.insert(rpt);
            }
        }
    }


    @Override
    public List<NcPriceRpt> list(NcPriceRptQuery query) {
        return ncPriceRptDAO.selectList("list", query);
    }


    @Override
    public NcPriceRpt get(Long id) {
        return ncPriceRptDAO.findById(id);
    }


    @Override
    public Boolean isExistYearMonthReport(Integer year, Integer month) {
        NcPriceRptQuery query = new NcPriceRptQuery();
        query.setYear(year);
        query.setMonth(month);
        List<Integer> list = ncPriceRptDAO.selectList("isExistYearMonthReport", query);
        return CollectionUtils.isNotEmpty(list);
    }


    @Override
    public Integer remove(NcPriceRptQuery query) {
        return ncPriceRptDAO.deleteByMapper("remove", query);
    }

}

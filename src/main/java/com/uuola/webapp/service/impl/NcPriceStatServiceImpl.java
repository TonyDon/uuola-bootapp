/*
 * @(#)NcPriceStatServiceImpl.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.entity.NcPriceStat;
import com.uuola.webapp.model.query.NcPriceStatQuery;
import com.uuola.webapp.service.NcPriceStatService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月10日
 * </pre>
 */
@Service
@PrimaryTx
public class NcPriceStatServiceImpl extends CrudOperator<NcPriceStat> implements NcPriceStatService {

    @Override
    public List<NcPriceRpt> statPriceRpt(NcPriceStatQuery query) {
        return crudDAO.selectList("statPriceRpt", query);
    }

}

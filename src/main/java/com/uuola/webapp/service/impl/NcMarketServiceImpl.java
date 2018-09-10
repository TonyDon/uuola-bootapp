/*
 * @(#)NcMarketServiceImpl.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.uuola.webapp.dao.NcMarketDAO;
import com.uuola.webapp.model.entity.NcMarket;
import com.uuola.webapp.model.query.NcMarketQuery;
import com.uuola.webapp.service.NcMarketService;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月10日
 * </pre>
 */
@Service
public class NcMarketServiceImpl implements NcMarketService {
    
    @Resource
    private NcMarketDAO ncMarketDAO;

    @Override
    public NcMarket get(Serializable id) {
        return ncMarketDAO.findById(id);
    }

    @Override
    public List<NcMarket> list(NcMarketQuery query) {
        return ncMarketDAO.selectList("list", query);
    }

    
}

/*
 * @(#)NcItemServiceImpl.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.dao.NcItemDAO;
import com.uuola.webapp.model.entity.NcItem;
import com.uuola.webapp.model.query.NcItemQuery;
import com.uuola.webapp.service.NcItemService;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
@Service
public class NcItemServiceImpl implements NcItemService {
    
    @Autowired
    private NcItemDAO ncItemDAO;

    @Override
    public List<NcItem> list(NcItemQuery query) {
        return ncItemDAO.selectList("list", query);
    }

    @Override
    public NcItem get(Long id) {
        return ncItemDAO.findById(id);
    }

}

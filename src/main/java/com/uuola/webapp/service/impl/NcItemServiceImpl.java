/*
 * @(#)NcItemServiceImpl.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.NcItem;
import com.uuola.webapp.service.NcItemService;
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
public class NcItemServiceImpl extends CrudOperator<NcItem> implements NcItemService {

    @Override
    public NcItem getByItemId(Integer itemId) {
        List<NcItem> list = this.crudDAO.findByField("itemId", itemId);
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

}

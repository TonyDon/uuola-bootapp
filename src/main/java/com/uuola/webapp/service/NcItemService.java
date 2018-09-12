/*
 * @(#)NcItemService.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.util.List;

import com.uuola.webapp.model.entity.NcItem;
import com.uuola.webapp.model.query.NcItemQuery;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
public interface NcItemService {

    List<NcItem> list(NcItemQuery query);

    NcItem get(Long id);
    
}

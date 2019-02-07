/*
 * @(#)NcItemService.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import com.uuola.webapp.model.entity.NcItem;
import com.uuola.webapp.support.db.CrudService;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
public interface NcItemService extends CrudService<NcItem>{
  
    NcItem getByItemId(Integer itemId);
}

/*
 * @(#)SiteCfgMapper.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.uuola.webapp.model.entity.SiteCfg;
import com.uuola.webapp.model.query.SiteCfgQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
@Mapper
public interface SiteCfgMapper {
    
    SiteCfg selectById(Serializable id);

    List<SiteCfg> listByQuery(SiteCfgQuery query);
}

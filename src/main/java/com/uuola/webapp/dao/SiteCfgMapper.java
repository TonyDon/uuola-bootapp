/*
 * @(#)SiteCfgMapper.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.dao;

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
public interface SiteCfgMapper extends BaseMapper<SiteCfg, SiteCfgQuery>{

}

/*
 * @(#)NcZoneMapper.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.dao;

import org.apache.ibatis.annotations.Mapper;

import com.uuola.webapp.model.entity.NcZone;
import com.uuola.webapp.model.query.NcZoneQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
@Mapper
public interface NcZoneMapper extends BaseMapper<NcZone, NcZoneQuery> {

}

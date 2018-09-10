/*
 * @(#)PrimaryDAO.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.uuola.webapp.support.db.BaseDAO;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public abstract class PrimaryDAO<T> extends BaseDAO<T> {


    @Autowired
    public void setDbTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate, SqlSessionTemplate sqlSessionTemplate) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}

/*
 * @(#)SysCfgQuery.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
public class SysCfgQuery extends BaseQuery {

    /* (non-Javadoc)
     * @see com.uuola.webapp.model.query.BaseQuery#filter()
     */
    @Override
    public void filter() {
        super.filter();
        if(StringUtils.isNotBlank(matchName)) {
            matchName = "%"+matchName+"%";
        }
    }
    
    private Integer id;
    
    private String name;
    
    private String cfgType;
    
    private Integer cfgState;
    
    private String matchName;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getCfgType() {
        return cfgType;
    }

    
    public void setCfgType(String cfgType) {
        this.cfgType = cfgType;
    }

    
    public Integer getCfgState() {
        return cfgState;
    }

    
    public void setCfgState(Integer cfgState) {
        this.cfgState = cfgState;
    }


    
    public String getMatchName() {
        return matchName;
    }


    
    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

}

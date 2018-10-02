/*
 * @(#)BlogQuery.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
public class BlogInfoQuery extends BaseQuery {

    /* (non-Javadoc)
     * @see com.uuola.webapp.model.query.BaseQuery#filter()
     */
    @Override
    public void filter() {
        // TODO Auto-generated method stub
        super.filter();
    }
    
    private Long id;
    
    private Integer cid;
    
    private String cidPath;
    
    private Integer funcType;
    
    private Integer conType;
    
    private Integer conState;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Integer getCid() {
        return cid;
    }

    
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    
    public String getCidPath() {
        return cidPath;
    }

    
    public void setCidPath(String cidPath) {
        this.cidPath = cidPath;
    }

    
    public Integer getFuncType() {
        return funcType;
    }

    
    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    
    public Integer getConType() {
        return conType;
    }

    
    public void setConType(Integer conType) {
        this.conType = conType;
    }

    
    public Integer getConState() {
        return conState;
    }

    
    public void setConState(Integer conState) {
        this.conState = conState;
    }
    
    

}

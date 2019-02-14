/*
 * @(#)BaseQuery.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.view;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
public abstract class BaseQuery {

    // 当前页码
    protected Integer pageNo = 1;

    // 当前排号
    protected Integer crow = 0;

    // 列表显示记录数
    protected Integer listSize = 10;

    // 查询总记录数
    protected Integer records = 0;

    // 排序 asc or desc
    protected String sord;

    // 排序所在字段名称
    protected String sidx;

    /**
     * 1.合法性校验，过滤参数不符合要求的属性值<br/>
     * 2.查询前对参数进行修改<br/>
     */
    public void filter() {
        if (this.listSize > 100 || this.listSize < 1) {
            this.listSize = 100;
        }
    }

    public BaseQuery() {
        
    }

    /**
     * @return the crow
     */
    public Integer getCrow() {
        return crow;
    }

    /**
     * @param crow
     *            the crow to set
     */
    public void setCrow(Integer crow) {
        this.crow = crow;
    }

    /**
     * @return the listsize
     */
    public Integer getListSize() {
        return listSize;
    }

    /**
     * @param listsize
     *            the listsize to set
     */
    public void setListSize(Integer listSize) {
        this.listSize = listSize;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 计算当前记录行号
     */
    public void calcCurrRowIndex() {
        if (null != pageNo && pageNo > 0) {
            this.crow = this.listSize * (this.pageNo - 1);
        }
    }
}

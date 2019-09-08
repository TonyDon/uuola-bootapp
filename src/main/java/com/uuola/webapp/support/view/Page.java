/*
 * @(#)Page.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
public class Page<T> {
    
    /**
     * 当前页码
     */
    private Integer pageNo;
    
    /**
     * 列表大小
     */
    protected Integer listSize;


    /**
     * 当前记录集合
     */
    private Collection<T> dataSet;

    /**
     * 总记录数
     */
    private int total;

    /**
     * 扩展数据集合
     */
    private Map<String, Object> extra;

    public Page() {
        this.dataSet = new ArrayList<>();
    }

    /**
     * 当前数据集，总数据条数
     * @param datas
     * @param total
     */
    public Page(Collection<T> datas, int total) {
        this.dataSet = datas;
        this.total = total;
        if (datas == null) {
            this.dataSet = Collections.emptyList();
        }
    }

    public Page(T[] datas, int total) {
        this.total = total;
        if (datas == null) {
            this.dataSet = Collections.emptyList();
        }else {
            this.dataSet = Arrays.asList(datas);
        }
    }

    public Collection<T> getDataSet() {
        return dataSet;
    }

    public Page<T> setDataSet(Collection<T> datas) {
        if(null != datas && datas.size()>0) {
            this.dataSet = datas;
        }
        return this;
    }
    
    public Page<T> addDataSet(Collection<T> datas) {
        if(null == dataSet) {
            dataSet = new ArrayList<>();
        }
        if(null != datas && datas.size()>0) {
            this.dataSet.addAll(datas);
        }
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public Page<T> addExtraAttr(String attrKey, Object attrVal) {
        if(null == extra) {
            extra = new HashMap<String, Object>();
        }
        extra.put(attrKey, attrVal);
        return this;
    }

    
    public int getTotal() {
        return total;
    }

    
    public Page<T> setTotal(int total) {
        this.total = total;
        return this;
    }
    
    public static <T> Page<T> build(Collection<T> datas, int total){
        return new Page<>(datas, total);
    }

    
    public Integer getPageNo() {
        return pageNo;
    }

    
    public Page<T> setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    
    public Integer getListSize() {
        return listSize;
    }

    
    public Page<T> setListSize(Integer listSize) {
        this.listSize = listSize;
        return this;
    }
}

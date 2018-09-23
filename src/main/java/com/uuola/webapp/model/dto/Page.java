/*
 * @(#)Page.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

    public Page() {}

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

    public void setDataSet(Collection<T> datas) {
        this.dataSet = datas;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    
    public int getTotal() {
        return total;
    }

    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public static <T> Page<T> build(Collection<T> datas, int total){
        return new Page<>(datas, total);
    }
}

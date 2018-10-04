/*
 * @(#)BlogCatalogQuery.java 2018-10-04 14:33:33
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import java.util.Date;

/**
 * <pre>
 *
 * @author tonydon
 * by make_bootapp_skt.py script generated
 * at 2018-10-04 14:33:33
 * </pre>
 */
public class BlogCatalogQuery extends BaseQuery {

    @Override
    public void filter() {
    	// TODO Auto-generated method stub
        super.filter();
    }


        private Integer id;
        
        private String name;
        
        private Integer state;
        
        private Integer recordNum;
        
        private Date createTime;
        
        private Date updateTime;
        


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
        
        public Integer getState() {
            return state;
        }
        
        public void setState(Integer state) {
            this.state = state;
        }
        
        public Integer getRecordNum() {
            return recordNum;
        }
        
        public void setRecordNum(Integer recordNum) {
            this.recordNum = recordNum;
        }
        
        public Date getCreateTime() {
            return createTime;
        }
        
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        
        public Date getUpdateTime() {
            return updateTime;
        }
        
        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }
        
    
}

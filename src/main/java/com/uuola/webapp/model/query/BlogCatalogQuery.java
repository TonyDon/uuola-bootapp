/*
 * @(#)BlogCatalogQuery.java 2018-10-04 14:33:33
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import java.util.Date;

import com.uuola.webapp.support.view.BaseQuery;

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
        
        private Date beginCreateTime;
        
        private Date endCreateTime;


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

        
        public Date getBeginCreateTime() {
            return beginCreateTime;
        }

        
        public void setBeginCreateTime(Date beginCreateTime) {
            this.beginCreateTime = beginCreateTime;
        }

        
        public Date getEndCreateTime() {
            return endCreateTime;
        }

        
        public void setEndCreateTime(Date endCreateTime) {
            this.endCreateTime = endCreateTime;
        }


    
}

/*
 * @(#)BlogCatalog.java 2018-10-04 14:33:33
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* <pre>
* @author tonydon
* by make_bootapp_skt.py script generated
* at 2018-10-04 14:33:33 , table_name:blog_catalog
* </pre>
*/
@Table
@Entity
public class BlogCatalog {

        
        @Id
        private Integer id;
                
        @Column
        private String name;
                
        @Column
        private Integer state;
                
        @Column
        private Integer recordNum;
                
        @Column
        private Date createTime;
                
        @Column
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

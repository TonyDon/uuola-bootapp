/*
 * @(#)EntityClassLoader.java 2014年11月19日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.db;

import java.util.Set;

import javax.persistence.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.uuola.webapp.util.ClassUtil;
import com.uuola.webapp.util.StringUtil;



/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2014年11月19日
 * </pre>
 */
public class EntityClassLoader {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 查找实体类的包路径
     */
    private String[] entityPackagePaths;
    
    /**
     * 是否递归查找
     */
    private boolean recursiveFind = false;
    
    public void init(){
        Assert.notEmpty(entityPackagePaths, "EntityClassLoader.entityPackagePaths[] not config!");
        log.info("initialize entity class loader!");
        EntityDefManager.clear();
        for(String pack : entityPackagePaths){
            if(StringUtil.isNotEmpty(pack)){
                invokeEntityDefManagerAdd(ClassUtil.getClasses(pack, recursiveFind));
            }
        }
    }
    
    private void invokeEntityDefManagerAdd(Set<Class<?>> entityClasses) {
        for(Class<?> entityClazz : entityClasses){
            Entity entityAnnotation = entityClazz.getAnnotation(Entity.class);
            if (null != entityAnnotation) {
                EntityDefManager.addEntityClass(entityClazz);
            }
        }
    }

    public String[] getEntityPackagePaths() {
        return entityPackagePaths;
    }

    
    public void setEntityPackagePaths(String[] entityPackagePaths) {
        this.entityPackagePaths = entityPackagePaths;
    }

    
    public boolean isRecursiveFind() {
        return recursiveFind;
    }

    
    public void setRecursiveFind(boolean recursiveFind) {
        this.recursiveFind = recursiveFind;
    }
    
    public void destroy() {
        EntityDefManager.clear();
        log.info("clear entity class manager!");
    }
}

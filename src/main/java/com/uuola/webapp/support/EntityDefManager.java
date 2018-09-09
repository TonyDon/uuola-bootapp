/*
 * @(#)EntityPropColumnManager.java 2014-11-12
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.persistence.Column;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.uuola.webapp.util.ClassUtil;
import com.uuola.webapp.util.FieldUtil;
import com.uuola.webapp.util.StringUtil;





/**
 * <pre>
 * 实体属性与表列名属性管理器
 * @author tangxiaodong
 * 创建日期: 2014-11-12
 * </pre>
 */
public class EntityDefManager {
    
    private static Logger log = LoggerFactory.getLogger(EntityDefManager.class);

    private static ConcurrentMap<Class<?>, EntityDefine> entityPropContainer = new ConcurrentHashMap<Class<?>, EntityDefine>();

    public static EntityDefine addEntityClass(Class<?> clazz) {
        EntityDefine defBean = entityPropContainer.get(clazz);
        if (null == defBean) {
            defBean = resolveEntityClass(clazz);
            entityPropContainer.putIfAbsent(clazz, defBean);
            log.info("add entity class def bean to manager : " + clazz.getCanonicalName());
            defBean = entityPropContainer.get(clazz);
        }
        return defBean;
    }
    
    public static EntityDefine getDef(Class<?> clazz){
        return addEntityClass(clazz);
    }

    private static EntityDefine resolveEntityClass(Class<?> clazz) {
        EntityDefine defBean = new EntityDefine();
        defBean.setEntityClass(clazz);
        defBean.setTableName(ClassUtil.getTableName(clazz));
        Map<String, Field> propFieldMap = FieldUtil.getAllAccessibleFieldNameMap(defBean.getEntityClass());
        Assert.notEmpty(propFieldMap, "Entity 's Field  not define! In " + clazz.getSimpleName());
        defBean.setPropFieldMap(propFieldMap);
        Map<String, String> propColumnMap = getPropertyColumnMap(defBean);
        Assert.notEmpty(propColumnMap, "Entity 's @Column not Exist! In " + clazz.getSimpleName());
        defBean.setPropColumnMap(propColumnMap);
        return defBean;
    }
    
    /**
     * 得到实体属性名与列标注名关系
     * @param entityClass2
     * @return
     */
    private  static Map<String, String> getPropertyColumnMap(EntityDefine defBean) {
        Map<String, Field> propFieldMap = defBean.getPropFieldMap();
        Map<String, String> propColumnMap = new HashMap<String, String>();
        boolean isFoundIdColumn = false;
        for (Map.Entry<String, Field> entry : propFieldMap.entrySet()) {
            String propName = entry.getKey();
            Field field = propFieldMap.get(propName);
            Assert.notNull(field, "By Class's defBean find field is null!");
            Column column = field.getAnnotation(Column.class);
            String colName = null;
            if (null != column) {
                if (StringUtil.isEmpty(colName = column.name())) {
                    colName = StringUtil.getUnderscoreName(field.getName());
                    log.warn("Not Set @Column.name ! Entity:[{}], using name:{} replace it.", defBean.getEntityClass().getCanonicalName(), colName);
                } 
                propColumnMap.put(propName, colName);
            }
            if (!isFoundIdColumn) {
                // 构建主键ID对应的表字段名称
                Id id = field.getAnnotation(Id.class);
                if (null != id) {
                    isFoundIdColumn = true;
                    // 如果 @Id标注主键没有被@Column标注，则自动转换属性列名关系
                    if (null == colName) {
                        propColumnMap.put(propName, propName.equalsIgnoreCase("id") ? "id" : StringUtil.getUnderscoreName(propName));
                    }
                    defBean.setUniqueKeyPropName(propName);
                }
            }
        }
        return propColumnMap;
    }
    
    /**
     * 清空实体属性容器
     */
    public static void clear(){
        entityPropContainer.clear();
    }
}

/*
 * @(#)SysCfgServiceImpl.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.uuola.webapp.enums.TRUE_OR_FALSE;
import com.uuola.webapp.model.entity.SysCfg;
import com.uuola.webapp.service.SysCfgService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;
import com.uuola.webapp.util.JsonUtil;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@Service
@PrimaryTx
public class SysCfgServiceImpl extends CrudOperator<SysCfg> implements SysCfgService {

    @Override
    public SysCfg getByName(String name) {
        List<SysCfg> list= crudDAO.findByField("name", name);
        return CollectionUtils.isEmpty(list) ? null  : list.get(0);
    }

    @Override
    public Number getNumber(String name) {
        SysCfg cfg = getByName(name);
        if(isInvalid(cfg)) {
            return null;
        }
        return new BigDecimal(cfg.getCfgVal());
    }

    @Override
    public String getText(String name) {
        SysCfg cfg = getByName(name);
        if(isInvalid(cfg)) {
            return null;
        }
        return cfg.getCfgVal();
    }

    private boolean isInvalid(SysCfg cfg) {
        return null == cfg || TRUE_OR_FALSE.F.intVal().equals(cfg.getCfgState()) || null == cfg.getCfgVal();
    }

    @Override
    public Boolean getBool(String name) {
        SysCfg cfg = getByName(name);
        if(isInvalid(cfg)) {
            return null;
        }
        return Boolean.valueOf(cfg.getCfgVal());
    }

    @Override
    public <T> List<T> getList(String name) {
        SysCfg cfg = getByName(name);
        if(isInvalid(cfg)) {
            return null;
        }
        return JsonUtil.convert(cfg.getCfgVal());
    }

    @Override
    public <K, V> Map<K, V> getDict(String name) {
        SysCfg cfg = getByName(name);
        if(isInvalid(cfg)) {
            return null;
        }
        return JsonUtil.convert(cfg.getCfgVal());
    }

    @Override
    public <E> Set<E> getSet(String name) {
        SysCfg cfg = getByName(name);
        if(isInvalid(cfg)) {
            return null;
        }
        String val = cfg.getCfgVal();
        if (val.startsWith("{") && val.endsWith("}") && val.length() > 2) {
            val = "[" + val.substring(1, val.length() - 1) + "]";
        }
        List<E> list = JsonUtil.convert(val);
        return new HashSet<E>(list);
    }
}

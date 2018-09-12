/*
 * @(#)NcPriceRptMonthTask.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.task;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uuola.webapp.enums.NC_PRICE_STAT_TYPE;
import com.uuola.webapp.model.entity.NcPriceRpt;
import com.uuola.webapp.model.query.NcPriceStatQuery;
import com.uuola.webapp.service.NcPriceRptService;
import com.uuola.webapp.service.NcPriceStatService;
import com.uuola.webapp.util.DateUtil;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
public class NcPriceRptMonthTask implements Callable<String> {
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    private NcPriceStatQuery query;
    
    private NcPriceStatService statService;
    
    private NcPriceRptService rptService;
    
    public NcPriceRptMonthTask() {
    }
    
    public NcPriceRptMonthTask setStatService(NcPriceStatService statService) {
        this.statService = statService;
        return this;
    }
    
    public NcPriceRptMonthTask setRptService(NcPriceRptService rptService) {
        this.rptService = rptService;
        return this;
    }
    
    public NcPriceRptMonthTask setQuery(NcPriceStatQuery query) {
        this.query = query;
        return this;
    }

    @Override
    public String call() throws Exception {
        String result = null;
        long t = System.currentTimeMillis();
        logger.info("--Begin-stat-rpt-on {}", getQueryStr());
        try {
            List<NcPriceRpt> rpts = statService.statPriceRpt(query);
            checkAndSetValue(rpts);
            rptService.batchInsert(rpts);
            result = String.format("--success, query:%s", getQueryStr());
        }catch(Exception e) {
            logger.error("query:{},error:{}", getQueryStr(), ExceptionUtils.getRootCauseMessage(e));
            result = String.format("--error, query:%s", getQueryStr());
        }finally {
            logger.info("--End-stat-rpt-on {}, use {}ms.", getQueryStr(), System.currentTimeMillis()-t );
            if(null == result) {
                result = String.format("--unknow, query:%s", getQueryStr());
            }
        }
        return result;
    }
    
    private void checkAndSetValue(List<NcPriceRpt> rpts) {
        Date currTime = DateUtil.getNowTime();
        Integer year = DateUtil.getYear(query.getBeginStatDate());
        Integer month = DateUtil.getMonth(query.getBeginStatDate());
        rpts.forEach(rpt->{
            if(null == rpt.getMinPrice()) {
                rpt.setMinPrice(0.0);
            }
            if(null == rpt.getMaxPrice()) {
                rpt.setMaxPrice(0.0);
            }
            if(null == rpt.getAvgPrice()) {
                rpt.setAvgPrice(0.0);
            }
            rpt.setCreateTime(currTime);
            rpt.setYear(year);
            rpt.setMonth(month);
            rpt.setStatType(NC_PRICE_STAT_TYPE.year.intVal());
        });
    }

    private String getQueryStr() {
         StringBuilder out = new StringBuilder();
         out.append("itemId:").append(query.getItemId());
         out.append(", beginStatDate:").append(DateUtil.formatDate(query.getBeginStatDate()));
         out.append(", endStatDate:").append(DateUtil.formatDate(query.getEndStatDate()));
         return out.toString();
    }

}

/*
 * @(#)NcPriceStatReportProcessor.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.uuola.webapp.constants.DATE_FORMAT;
import com.uuola.webapp.model.entity.NcItem;
import com.uuola.webapp.model.query.NcItemQuery;
import com.uuola.webapp.model.query.NcPriceStatQuery;
import com.uuola.webapp.service.NcItemService;
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
@Component
public class NcPriceStatReportProcessor {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NcPriceStatService statService;
    
    @Autowired
    private NcPriceRptService rptService;
    
    @Autowired
    private NcItemService ncItemService;
    
    @Autowired
    private ExecutorService executorService;
    
    public void execute(Integer year, Integer month) {
        if(!checkParams(year, month)) {
            logger.info("please check params {},{}", year, month);
            return ;
        }
        List<NcItem> items = ncItemService.list(new NcItemQuery());
        List<NcPriceRptMonthTask> tasks = Lists.newArrayList();
        Date beginStatDate = DateUtil.parseDate(String.format("%04d-%02d-01 00:00:00", year, month), DATE_FORMAT.YYYY_MM_DD_HH_MM_SS);
        Date endStatDate = DateUtil.add(beginStatDate, Calendar.MONTH, 1);
        logger.info("begin execute for params:  {} ~ {}", DateUtil.formatDate(beginStatDate), DateUtil.formatDate(endStatDate));
        items.forEach(it -> {
            NcPriceStatQuery query = new NcPriceStatQuery();
            query.setItemId(it.getItemId());
            query.setBeginStatDate(beginStatDate);
            query.setEndStatDate(endStatDate);
            NcPriceRptMonthTask t = new NcPriceRptMonthTask();
            t.setStatService(statService).setRptService(rptService).setQuery(query);
            tasks.add(t);
        });
        try {
            if(tasks.size()>0) {
                List<Future<String>> futures = executorService.invokeAll(tasks, 300, TimeUnit.SECONDS);// all task overtime in 300s
                for(Future<String> f : futures) {
                    logger.info(f.get());
                }
            }else {
                logger.info("not found items... execute over!");
            }
        } catch (Exception e) {
            logger.error("execute futures error:", e);
        }
    }

    private Boolean checkParams(Integer year, Integer month) {
        if(null == year || null == month) {
            return false;
        }
        // 如存在报表记录则不再统计该月份
        return !rptService.isExistYearMonthReport(year, month);
    }
}

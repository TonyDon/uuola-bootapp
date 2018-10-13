/*
 * @(#)StringToDateConverter.java 2013-11-9
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.converter;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.uuola.webapp.constants.DATE_FORMAT;
import com.uuola.webapp.constants.REGEX;
import com.uuola.webapp.util.DateUtil;



/**
 * <pre>
 * String -> Data 转换器
 * @author tangxiaodong
 * 创建日期: 2013-11-9
 * </pre>
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        if (REGEX.RE_LONG.matcher(source).matches()) {
            return new Date(Long.parseLong(source));
        } else if (REGEX.RE_DATE.matcher(source).matches()) {
            return DateUtil.parseDate(source, DATE_FORMAT.YYYY_MM_DD);
        } else if (REGEX.RE_DATETIME_NOT_SS.matcher(source).matches()) {
            return DateUtil.parseDate(source, DATE_FORMAT.YYYY_MM_DD_HH_MM);
        } else if (REGEX.RE_DATETIME.matcher(source).matches()) {
            return DateUtil.parseDate(source, DATE_FORMAT.YYYY_MM_DD_HH_MM_SS);
        } else if (REGEX.RE_DATETIME_TIMEZONE.matcher(source).matches()) {
            return DateUtil.parseDate(source, DATE_FORMAT.YYYY_MM_DDTHH_MM_SS_Z);
        } else {
            throw new IllegalArgumentException("Invalid Date value '" + source + "'");
        }
    }

}

/**
 * 
 */

package com.uuola.webapp.config;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年6月13日
 * </pre>
 */
@RestControllerAdvice
public class AppExceptionHandler{
    
    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.error("ExceptionHandler:", ex);
        String msg = String.format("Server Error: %s", ExceptionUtils.getMessage(ex));
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

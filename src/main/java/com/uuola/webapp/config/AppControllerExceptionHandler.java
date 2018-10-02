/**
 * 
 */

package com.uuola.webapp.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年6月13日
 * </pre>
 */
@RestControllerAdvice
public class AppControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.error("ExceptionHandler:", ex);
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>("server error", status);
    }
    
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}

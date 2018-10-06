/*
 * @(#)AdminConsoleController.java 2018年10月6日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.uuola.webapp.constants.Constants;
import com.uuola.webapp.model.dto.AdminDTO;
import com.uuola.webapp.model.entity.SysCfg;
import com.uuola.webapp.model.query.AdminQuery;
import com.uuola.webapp.service.SysCfgService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.util.DateUtil;
import com.uuola.webapp.util.coder.DigestHash;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月6日
 * </pre>
 */
@RestController
@RequestMapping("/admin-console")
public class ConsoleController extends BaseController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    SysCfgService sysCfgService;

    @GetMapping("/verify")
    public ResponseEntity<?> verify(AdminQuery query, HttpServletRequest request){
        AdminDTO admin = new AdminDTO();
        admin.setName(query.getName());
        admin.setLoginTime(DateUtil.getNowTime());
        Map<String,Object> result = Maps.newHashMap();
        String code = (String)request.getSession().getAttribute(Constants.SESSION_IMAGE_CODE);
        if(StringUtils.isEmpty(query.getCode()) || null == code || !code.equalsIgnoreCase(query.getCode())) {
            //验证码错误
            result.put("state", -1);
        }else {
            SysCfg adminCfg = sysCfgService.getByName(query.getName());
            if(null == adminCfg) {
                result.put("state", -2);
            }else {
                String password = adminCfg.getCfgVal();
                String serverHash = DigestHash.md5(String.format("%s%s", password, code));
                if(!serverHash.equals(query.getPassword())) {
                    result.put("state", -3);
                }else {
                    request.getSession().setAttribute(Constants.SESSION_ADMIN, admin);
                    result.put("state", 1);
                }
            }
        }
        log.info("console-login[state={}, admin={}]", result.get("state"), admin);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        HttpSession sn = request.getSession(false);
        if(null != sn) {
            sn.setAttribute(Constants.SESSION_ADMIN, null);
        }
        Map<String,Object> result = Maps.newHashMap();
        result.put("state", 1);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/mylog")
    public ResponseEntity<?> log(HttpServletRequest request){
        HttpSession sn = request.getSession(false);
        Map<String,Object> result = Maps.newHashMap();
        result.put("state", 0);
        if(null != sn) {
            AdminDTO admin = (AdminDTO)sn.getAttribute(Constants.SESSION_ADMIN);
            if(null != admin) {
                result.put("state", 1);
                result.put("admin", admin);
            }
        }
        return ResponseEntity.ok(result);
    }
}
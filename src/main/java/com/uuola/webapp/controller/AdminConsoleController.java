/*
 * @(#)AdminConsoleController.java 2018年10月6日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.controller;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.uuola.webapp.constants.Contants;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.util.NumberUtil;
import com.uuola.webapp.util.imagecode.ImageCodeMaker;
import com.uuola.webapp.util.imagecode.ImageCodeParams;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月6日
 * </pre>
 */
@RestController
@RequestMapping("/admin-console")
public class AdminConsoleController extends BaseController {
    
    private Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
    

    @GetMapping("/imagecode")
    public ResponseEntity<?> showImageCode(HttpServletRequest request) {
        String code = String.valueOf(NumberUtil.genRndInt(1000, 100000));
        ImageCodeParams params = new ImageCodeParams(code);
        ByteArrayOutputStream bufferStream = new ByteArrayOutputStream();
        params.setOutputStream(bufferStream)
        .setCharBoxSize(22)
        .setDrawLine(true)
        .setRotate(true)
        .setWidth(90)
        .setHeight(30)
        .setBackgroundColors(Color.GRAY)
        .setFontColors(Color.BLACK,Color.LIGHT_GRAY)
        .setFont(font);
        ImageCodeMaker.outputImage(params);
        request.getSession().setAttribute(Contants.SESSION_IMAGE_CODE, code);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(bufferStream.toByteArray());
    }
}

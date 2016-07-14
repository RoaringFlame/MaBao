package com.mabao.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理控制器
 * Created by jackie on 2016/07/13.
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(){
        return "login";
    }
}

package com.zhuofengyuan.blog.blogcommon.advice;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler(value =  Exception.class)
    public RestResponseBo handleException(Exception e, HttpServletRequest req) {
        return RestResponseBo.fail(500, e.getMessage());
    }
}

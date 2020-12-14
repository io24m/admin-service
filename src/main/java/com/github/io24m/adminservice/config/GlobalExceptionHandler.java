package com.github.io24m.adminservice.config;

import com.github.io24m.adminservice.common.dto.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lk1
 * @description
 * @create 2020-11-18 9:46
 */
@Slf4j
@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest request, Exception exception) {
        log.error("错误信息：", exception);
        AjaxResponse err = AjaxResponse.error("未知错误");
        return new ResponseEntity<>(err, HttpStatus.valueOf(200));
    }
}

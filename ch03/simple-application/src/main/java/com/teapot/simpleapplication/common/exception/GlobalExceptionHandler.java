package com.teapot.simpleapplication.common.exception;

import com.teapot.simpleapplication.common.response.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.login.AccountExpiredException;
import java.nio.file.AccessDeniedException;
import java.util.Objects;

/**
 * @Author: HuRuiFeng
 * @File: GlobalExceptionHandler.java
 * @Time: 2024/5/27 14:35
 * @Project: high-concurrency-in-action
 * @Desc: 全局异常统一处理类
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseException(BaseException e) {
        return BaseResponse.error(e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    public BaseResponse businessException(CustomException e) {
        if (StringUtils.equals(null, e.getCode().toString())) {
            return BaseResponse.error(e.getMessage());
        }
        return BaseResponse.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public BaseResponse handleNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return BaseResponse.error(HttpStatus.NOT_FOUND.value(), "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public BaseResponse handleAuthorizationException(AccessDeniedException e) {
        log.error(e.getMessage());
        return BaseResponse.error(HttpStatus.FORBIDDEN.value(), "没有权限，请联系管理员授权");
    }

    @ExceptionHandler(AccountExpiredException.class)
    public BaseResponse handleAccountExpiredException(AccountExpiredException e) {
        log.error(e.getMessage());
        return BaseResponse.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e) {
        log.error(e.getMessage());
        return BaseResponse.error(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public BaseResponse validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return BaseResponse.error(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return BaseResponse.error(message);
    }
}

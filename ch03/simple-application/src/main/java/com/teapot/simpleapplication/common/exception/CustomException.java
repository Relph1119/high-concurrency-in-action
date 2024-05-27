package com.teapot.simpleapplication.common.exception;

/**
 * @Author: HuRuiFeng
 * @File: CustomException.java
 * @Time: 2024/5/27 14:15
 * @Project: high-concurrency-in-action
 * @Desc: 自定义业务异常
 **/
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private final String message;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public CustomException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}

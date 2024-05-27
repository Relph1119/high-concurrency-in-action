package com.teapot.simpleapplication.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author: HuRuiFeng
 * @File: BaseResponse.java
 * @Time: 2024/5/27 14:38
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
@ApiModel
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回编码")
    private Integer code;

    @ApiModelProperty(value = "返回消息提示")
    private String msg;

    @ApiModelProperty(value = "返回实体对象")
    private T data;

    public BaseResponse() {};

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public BaseResponse(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static BaseResponseBuilder builder() {
        return new BaseResponseBuilder();
    }

    public static class BaseResponseBuilder {
        private Integer code;
        private String msg;
        public BaseResponseBuilder() {}
        public BaseResponseBuilder code(Integer code) {
            this.code = code;
            return this;
        }
        public BaseResponseBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }
        public BaseResponse build() {
            return new BaseResponse(this.code, this.msg);
        }

        @Override
        public String toString() {
            return "BaseResponseBuilder{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    public static BaseResponse success() {
        return new BaseResponse(ResultCode.SUCCESS);
    }

    public static <T> BaseResponse success(T data) {
        return new BaseResponse<T>(ResultCode.SUCCESS, data);
    }

    public static BaseResponse success(String msg) {
        return new BaseResponse(ResultCode.SUCCESS.getCode(), msg);
    }

    public static BaseResponse success(Integer code, String msg) {
        return new BaseResponse(code, msg);
    }

    public static <T> BaseResponse success(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }

    public static BaseResponse success(ResultCode resultCode) {
        return new BaseResponse(resultCode);
    }

    public static BaseResponse error() {
        return new BaseResponse(ResultCode.INTERNAL_SERVER_ERROR);
    }

    public static <T> BaseResponse error(T data) {
        return new BaseResponse<T>(ResultCode.INTERNAL_SERVER_ERROR, data);
    }

    public static BaseResponse error(String msg) {
        return new BaseResponse(ResultCode.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static BaseResponse error(Integer code, String msg) {
        return new BaseResponse(code, msg);
    }

    public static <T> BaseResponse error(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }

    public static BaseResponse error(ResultCode resultCode) {
        return new BaseResponse(resultCode);
    }
}

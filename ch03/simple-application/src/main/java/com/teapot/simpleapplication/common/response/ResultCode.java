package com.teapot.simpleapplication.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: HuRuiFeng
 * @File: ResultCode.java
 * @Time: 2024/5/27 14:47
 * @Project: high-concurrency-in-action
 * @Desc: 状态码
 **/
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    MOVED_PERM(301, "资源已被移除"),
    NOT_FOUND(404, "资源、服务未找到"),
    INTERNAL_SERVER_ERROR(500, "系统内部错误");
    final int code;
    final String msg;
}

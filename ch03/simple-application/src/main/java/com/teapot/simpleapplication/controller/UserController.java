package com.teapot.simpleapplication.controller;

import com.teapot.simpleapplication.domain.UserInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "测试swagger", tags = "用户管理模块")
public class UserController {
    public UserInfo validateUser(@Valid @RequestBody UserInfo userInfo) {
        return userInfo;
    }
}

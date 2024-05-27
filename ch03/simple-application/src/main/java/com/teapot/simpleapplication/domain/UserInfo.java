package com.teapot.simpleapplication.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInfo {
    private Long id;

    @Size(min = 2, max = 10, message = "姓名长度必须为2~10")
    private String name;

    private Boolean gender;

    @NotNull(message = "密码不能为空")
    private String password;

    @Min(value = 16, message = "年龄最小为16岁")
    @Max(value = 100, message = "年龄最大为100岁")
    private Integer age;
}

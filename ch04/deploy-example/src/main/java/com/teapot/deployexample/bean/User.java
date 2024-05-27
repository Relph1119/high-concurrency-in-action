package com.teapot.deployexample.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @Author: HuRuiFeng
 * @File: User.java
 * @Time: 2024/5/27 20:04
 * @Project: high-concurrency-in-action
 * @Desc: 用户类
 **/
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static final long serialVersionUID = 1L;
    // 用户ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 用户账号
    private String name;
    // 用户邮箱
    private String email;
    // 头像地址
    private String photoUrl;
    // 手机号码
    private String phoneNumber;
    private Boolean support;
    private Boolean confirmedAndActive;
}

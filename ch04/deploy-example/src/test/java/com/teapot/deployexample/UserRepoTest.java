package com.teapot.deployexample;

import com.teapot.deployexample.bean.User;
import com.teapot.deployexample.repos.UserRepo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: HuRuiFeng
 * @File: UserRepoTest.java
 * @Time: 2024/5/27 20:18
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;
    private User defUser;

    @BeforeEach
    public void setUp() {
        defUser = User.builder()
                .name("test")
                .email("邮箱地址")
                .confirmedAndActive(false)
                .photoUrl("头像地址")
                .phoneNumber("手机号")
                .support(false)
                .build();
    }

    @Test
    public void getUserById() {
        userRepo.save(defUser);
        assertEquals(1, userRepo.count());
        User user = userRepo.findById(defUser.getId()).get();
        assertEquals(defUser, user);
    }
}

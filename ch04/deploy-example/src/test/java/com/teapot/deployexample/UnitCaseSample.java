package com.teapot.deployexample;

import org.junit.jupiter.api.*;

/**
 * @Author: HuRuiFeng
 * @File: UnitCaseSample.java
 * @Time: 2024/5/27 19:41
 * @Project: high-concurrency-in-action
 * @Desc: 普通单元测试
 **/
@DisplayName("单元测试用例展示")
public class UnitCaseSample {
    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }

    @BeforeEach
    public void before() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void after() {
        System.out.println("当前测试方法结束");
    }

    @DisplayName("测试第一个用例")
    @Test
    void firstCase() {
        System.out.println("正在测试第一个用例");
    }

    @DisplayName("测试第二个用例")
    @Test
    void secondCase() {
        System.out.println("正在测试第二个用例");
    }
}

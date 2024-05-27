package com.teapot.deployexample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * @Author: HuRuiFeng
 * @File: JUnitSample.java
 * @Time: 2024/5/27 19:45
 * @Project: high-concurrency-in-action
 * @Desc: JUnit常用注解
 **/
@DisplayName("JUnit 5 Sample")
public class JUnitSample {
    @ParameterizedTest
    @ValueSource(strings = {"hello", "world"})
    @DisplayName("string-length")
    void stringLength(String value) {
        System.out.println(value);
        assertThat(value).hasSize(5);
    }

    @RepeatedTest(3)
    @DisplayName("重复测试")
    void repeatedTest() {
        assertThat(true).isTrue();
    }

    @TestFactory
    DynamicTest[] dynamicTests() {
        return new DynamicTest[] {
                dynamicTest("Dynamic test 1", () -> assertThat(10).isGreaterThan(5)),
                dynamicTest("Dynamic test 2", () -> assertThat("Dynamic").hasSize(7)),
        };
    }

}

package com.teapot.simpleapplication.domain.po;

import lombok.Data;

/**
 * @Author: HuRuiFeng
 * @File: Order.java
 * @Time: 2024/5/27 18:11
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
@Data
public class Order {
    Customer customer;
    Address billingAddress;
}

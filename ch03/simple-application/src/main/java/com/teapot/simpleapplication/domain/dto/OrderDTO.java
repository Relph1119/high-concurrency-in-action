package com.teapot.simpleapplication.domain.dto;

import lombok.Data;

/**
 * @Author: HuRuiFeng
 * @File: OrderDTO.java
 * @Time: 2024/5/27 18:15
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
@Data
public class OrderDTO {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;
}

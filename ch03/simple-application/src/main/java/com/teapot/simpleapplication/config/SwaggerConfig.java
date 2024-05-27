package com.teapot.simpleapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.spec.PSSParameterSpec;

/**
 * @Author: HuRuiFeng
 * @File: SwaggerConfig.java
 * @Time: 2024/5/27 19:23
 * @Project: high-concurrency-in-action
 * @Desc: Swagger配置类
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 扫描的路径包，设置basePackage将包下所有被@Api标识的类方法作为API
                .apis(RequestHandlerSelectors.basePackage("com.teapot.simpleapplication"))
                // 处理所有的路径
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Demo REST API")
                .description("Demo REST API")
                .contact(new Contact("overland", "URL链接", "邮箱地址"))
                .license("The MIT License")
                .licenseUrl("licenses地址")
                .version("V1")
                .build();
    }
}

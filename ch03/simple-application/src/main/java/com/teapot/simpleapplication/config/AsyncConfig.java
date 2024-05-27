package com.teapot.simpleapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Author: HuRuiFeng
 * @File: AsyncConfig.java
 * @Time: 2024/5/27 16:03
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
@Configuration
@EnableAsync
public class AsyncConfig {
    public static final String ASYNC_EXECUTOR_NAME = "asyncExecutor";

    @Bean(name = ASYNC_EXECUTOR_NAME)
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 线程池相关配置
        executor.setTaskDecorator(new ContextCopyingDecorator());
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("AsyncThread-");
        return executor;
    }
}

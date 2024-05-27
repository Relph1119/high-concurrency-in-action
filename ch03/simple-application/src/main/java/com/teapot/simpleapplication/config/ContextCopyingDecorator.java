package com.teapot.simpleapplication.config;

import org.springframework.core.task.TaskDecorator;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @Author: HuRuiFeng
 * @File: ContextCopyingDecorator.java
 * @Time: 2024/5/27 18:00
 * @Project: high-concurrency-in-action
 * @Desc:
 **/
public class ContextCopyingDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        // 复制请求上下文
        RequestAttributes context = RequestContextHolder.currentRequestAttributes();
        return () -> {
            try {
                // 将上下文传递给信息的线程
                RequestContextHolder.setRequestAttributes(context);
                runnable.run();
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        };
    }
}

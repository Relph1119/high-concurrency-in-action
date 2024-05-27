package com.teapot.simpleapplication.validate;

import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD,
        ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ListNotHasNull {
    int value() default 0;
    String message() default "在List集合中不能含有null元素";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        ListNotHasNull[] value();
    }
}

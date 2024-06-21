package com.mohyla;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidateAge {
    int min() default 1;
    int max() default 70;
}
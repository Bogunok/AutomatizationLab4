package com.mohyla;

import java.lang.reflect.Field;

public class AnnotationValidator {

    public static void validate(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ValidateAge.class)) {
                ValidateAge annotation = field.getAnnotation(ValidateAge.class);
                field.setAccessible(true);
                try {
                    int value = (int) field.get(obj);
                    if (value < annotation.min() || value > annotation.max()) {
                        throw new IllegalArgumentException(
                                "Field " + field.getName() + " in class " + obj.getClass().getSimpleName() + " must be between " + annotation.min() + " and " + annotation.max()
                        );
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
package com.codeedx;

import com.codeedx.external.app.ManualService;

import java.lang.reflect.InvocationTargetException;

public class BasicReflectionDemo {
    public static void main(String[] args) {
        String className = "com.codeedx.external.app.ManualService";
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Get the class name
        System.out.println("Class Name: " + clazz.getName());

        // Get the superclass
        System.out.println("Superclass: " + clazz.getSuperclass().getName());

        try {
            ManualService manualService = (ManualService) clazz.getDeclaredConstructor().newInstance();
            manualService.execute();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Failed to create a new instance of: " + clazz.getName(), e);
        }
    }
}

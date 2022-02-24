package com.sda.advanced.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DemoReflection {

    public static void main(String[] args) {
        try {
            Laptop laptop = new Laptop();

            // the class type of laptop
            Class object = laptop.getClass();

            // get field
            Field field = object.getField("brand");

            // update field
            field.set(laptop, "hp");

            // get value of field
            String typeValue = (String) field.get(laptop);
            System.out.println("value: " + typeValue);

            // get access modifiers
            int modifiers = field.getModifiers();

            // convert modifier to String
            String fieldModifiers = Modifier.toString(modifiers);
            System.out.println(fieldModifiers);

            // get methods
            Method[] methods = object.getMethods();

            // get method names
            for (Method method : methods) {
                System.out.println("method name: " + method.getName());

                // get method access modifiers
                int methodModifiers = method.getModifiers();
                System.out.println("method modifiers: " + Modifier.toString(methodModifiers));

                // get return type of method
                Class<?> returnType = method.getReturnType();
                System.out.println("method return type: " + returnType);
            }

            // get constructors
            Constructor[] constructors = object.getConstructors();

            for (Constructor constructor : constructors) {

                // get constructor name
                System.out.println("constructor: " + constructor.getName());

                System.out.println("constructor modifiers: " + Modifier.toString(constructor.getModifiers()));

                System.out.println("constructor parameter count: " + constructor.getParameterCount());
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

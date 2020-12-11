package ru.geekbrains.lesson_7.homework;

import ru.geekbrains.lesson_7.homework.annotations.AfterSuite;
import ru.geekbrains.lesson_7.homework.annotations.BeforeSuite;
import ru.geekbrains.lesson_7.homework.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestStarter {
    private static Object object;

    public static void start(Class testClass) throws Exception{
//        Class<ClassToTest> c = ClassToTest.class;
//        Constructor<ClassToTest> constructor = c.getConstructor();
//        ClassToTest object = constructor.newInstance();
        object = testClass.newInstance();

        Method before = null;
        Method after = null;
        int beforeCount = 0;
        int afterCount = 0;

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                before = method;
                beforeCount++;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                after = method;
                afterCount++;
            }
        }

        if (beforeCount > 1 || afterCount > 1) {
            throw new RuntimeException("More than one @BeforeSuite or @AfterSuite annotation");
        }

        if (before != null){
            before.setAccessible(true);
            before.invoke(object);
            System.out.println(before.getName());
            before.setAccessible(false);
        }

        for (int i = 1; i <= 10; i++) {
            for (Method method : testClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class) && method.getAnnotation(Test.class).priority() == i){
                    method.setAccessible(true);
                    System.out.println(method.invoke(object));
                    System.out.println(method.getName());
                    method.setAccessible(false);
                }
            }
        }

        if (after != null){
            after.setAccessible(true);
            after.invoke(object);
            System.out.println(after.getName());
            after.setAccessible(false);
        }
    }
}

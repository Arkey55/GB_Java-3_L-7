package ru.geekbrains.lesson_7.homework;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassToTest classToTest = new ClassToTest();
        TestStarter.start(classToTest.getClass());
    }
}

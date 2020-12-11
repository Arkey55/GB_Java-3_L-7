package ru.geekbrains.lesson_7.homework;

import ru.geekbrains.lesson_7.homework.annotations.AfterSuite;
import ru.geekbrains.lesson_7.homework.annotations.BeforeSuite;
import ru.geekbrains.lesson_7.homework.annotations.Test;

public class ClassToTest {
    @AfterSuite
    public void method1() {
        System.out.println("@AfterSuite");
    }

    @BeforeSuite
    private void method2() {
        System.out.println("@BeforeSuite");
    }

    @Test
    private void method3() {
        System.out.println("@Test()");
    }

    @Test(priority = 10)
    public void method4() {
        System.out.println("@Test(10)");
    }

    @Test(priority = 2)
    private void method5() {
        System.out.println("@Test(2)");
    }

    @Test
    public void method6() {
        System.out.println("@Test()");
    }
}

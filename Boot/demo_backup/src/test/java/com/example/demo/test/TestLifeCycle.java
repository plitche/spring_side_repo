package com.example.demo.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("TestLifeCycle.beforeAll");
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("TestLifeCycle.afterAll");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("TestLifeCycle.beforeEach");
        System.out.println();
    }

    @AfterEach
    void afterEach() {
        System.out.println("TestLifeCycle.afterEach");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("TestLifeCycle.test1");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2() {
        System.out.println("TestLifeCycle.test2");
        System.out.println();
    }

    @Test
    @Disabled // 테스트를 실행하지 않게 설정하는 어노테이션
    void test3() {
        System.out.println("TestLifeCycle.test3");
        System.out.println();
    }
}

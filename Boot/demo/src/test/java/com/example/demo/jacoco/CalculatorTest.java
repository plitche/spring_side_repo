package com.example.demo.jacoco;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    @Test
    public void addTest() {
        int expected = 3;

        assertEquals(3, expected);
    }

    @Test
    public void multipleTest() {
        int expected = 2;

        assertEquals(3, expected);
    }

}

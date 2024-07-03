package com.example.demo.jacoco;

import com.example.demo.jacoco_test_ex.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void addTest() {
        int actual = calculator.add(1, 2);
        int expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    public void multipleTest() {
        int actual = calculator.multiple(1, 2);
        int expected = 2;

        assertEquals(actual, expected);
    }

}

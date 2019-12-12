package com.veselov.alex.unittesting.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessLogicTest {

    @Test
    void calculateSum() {
        SomeBusinessLogic logic = new SomeBusinessLogic();
        int actual = logic.calculateSum(new int[]{1, 2, 3});
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void calculateZero() {
        SomeBusinessLogic logic = new SomeBusinessLogic();
        int actual = logic.calculateSum(new int[]{});
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateOneValue() {
        SomeBusinessLogic logic = new SomeBusinessLogic();
        int actual = logic.calculateSum(new int[]{1});
        int expected = 1;
        assertEquals(expected, actual);
    }
}
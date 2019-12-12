package com.veselov.alex.unittesting.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessLogicTest {

    @Test
    void calculateSum() {
        SomeBusinessLogic logic = new SomeBusinessLogic();
        SomeDataService mock = mock(SomeDataService.class);
        when(mock.retrieveData()).thenReturn(new int[]{1, 2, 3});
        logic.setService(mock);
        int actual = logic.calculateSumUsingService();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void calculateZero() {
        SomeBusinessLogic logic = new SomeBusinessLogic();
        SomeDataService mock = mock(SomeDataService.class);
        when(mock.retrieveData()).thenReturn(new int[]{});
        logic.setService(mock);
        int actual = logic.calculateSumUsingService();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateOneValue() {
        SomeBusinessLogic logic = new SomeBusinessLogic();
        SomeDataService mock = mock(SomeDataService.class);
        when(mock.retrieveData()).thenReturn(new int[]{3});
        logic.setService(mock);
        int actual = logic.calculateSumUsingService();
        int expected = 3;
        assertEquals(expected, actual);
    }
}
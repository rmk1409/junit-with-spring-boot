package com.veselov.alex.unittesting.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessLogicTest {

    @Mock
    SomeDataService mock;
    @InjectMocks
    SomeBusinessLogic logic = new SomeBusinessLogic();

    @Test
    void calculateSum() {
        when(mock.retrieveData()).thenReturn(new int[]{1, 2, 3});
        logic.setService(mock);
        int actual = logic.calculateSumUsingService();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void calculateZero() {
        when(mock.retrieveData()).thenReturn(new int[]{});
        logic.setService(mock);
        int actual = logic.calculateSumUsingService();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculateOneValue() {
        when(mock.retrieveData()).thenReturn(new int[]{3});
        logic.setService(mock);
        int actual = logic.calculateSumUsingService();
        int expected = 3;
        assertEquals(expected, actual);
    }
}
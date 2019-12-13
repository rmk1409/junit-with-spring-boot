package com.veselov.alex.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJMatchers {
    List<Integer> numbers = Arrays.asList(12, 15, 45);

    @Test
    public void learning() {
        assertThat(numbers)
                .hasSize(3)
                .contains(12, 45)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100);

        assertThat("").isEmpty();
        assertThat("ADBCD")
                .contains("DBC")
                .startsWith("ADB")
                .endsWith("BCD");
    }
}

package com.veselov.alex.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchers {
    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12, 45));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("", is(emptyString()));
        assertThat("ADBCD", containsString("DBC"));
        assertThat("ADBCD", startsWith("ADB"));
        assertThat("ADBCD", endsWith("BCD"));
    }
}

package com.veselov.alex.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void learning() {
        String response = "[{id:1001,name:Item1,price:11,quantity:21,value:231},{id:1002,name:Item2,price:12,quantity:22,value:264},{id:1003,name:Item1,price:13,quantity:23,value:299}]";
        DocumentContext context = JsonPath.parse(response);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1001, 1002, 1003);
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
    }
}

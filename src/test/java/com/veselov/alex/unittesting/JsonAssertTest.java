package com.veselov.alex.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String json = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_NoStrict() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Ball\"}";
        JSONAssert.assertEquals(expected, json, false);
    }

    @Test
    public void jsonAssert_Strict() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Ball\",\"price\": 10,\"quantity\":100}";
        JSONAssert.assertEquals(expected, json, true);
    }

    @Test
    public void jsonAssert_NoEscCharacter() throws JSONException {
        String expected = "{id:1,name:Ball,price: 10,quantity:100}";
        JSONAssert.assertEquals(expected, json, true);
    }
}

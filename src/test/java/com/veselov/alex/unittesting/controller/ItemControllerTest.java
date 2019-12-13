package com.veselov.alex.unittesting.controller;

import com.veselov.alex.unittesting.model.Item;
import com.veselov.alex.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mock;

    @MockBean
    private ItemBusinessService service;

    @Test
    public void dummyItem_basic() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    public void dummyItemFromServiceLayer_basic() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/dummy-item-from-business-layer")
                .accept(MediaType.APPLICATION_JSON);
        when(service.retrieveItem()).thenReturn(new Item(2, "Snagk", 5, 33));
        MvcResult result = mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Snagk,price:5}"))
                .andReturn();
    }

    @Test
    public void dummyItemDataLayer_basic() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/all-item-from-data-base")
                .accept(MediaType.APPLICATION_JSON);
        when(service.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(1001, "Item1", 11, 21),
                        new Item(1002, "Item2", 12, 22),
                        new Item(1003, "Item3", 13, 23))
        );
        mock.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1001,name:Item1,price:11,quantity:21,value:0},{id:1002,name:Item2,price:12,quantity:22,value:0},{id:1003,name:Item3,price:13,quantity:23,value:0}]"))
                .andReturn();
    }
}

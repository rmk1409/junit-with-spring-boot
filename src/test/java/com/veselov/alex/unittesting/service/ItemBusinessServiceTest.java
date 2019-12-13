package com.veselov.alex.unittesting.service;

import com.veselov.alex.unittesting.data.ItemRepository;
import com.veselov.alex.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
    @Mock
    private ItemRepository mock;
    @InjectMocks
    private ItemBusinessService service = new ItemBusinessService();

    @Test
    void retrieveAllItems() {
        when(this.mock.findAll()).thenReturn(
                Arrays.asList(
                        new Item(1001, "Item1", 11, 21),
                        new Item(1002, "Item2", 12, 22),
                        new Item(1003, "Item3", 13, 23))
        );
        List<Item> items = service.retrieveAllItems();
        assertEquals(231, items.get(0).getValue());
        assertEquals(264, items.get(1).getValue());
        assertEquals(299, items.get(2).getValue());
    }
}
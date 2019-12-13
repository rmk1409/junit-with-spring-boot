package com.veselov.alex.unittesting.data;

import com.veselov.alex.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }
}
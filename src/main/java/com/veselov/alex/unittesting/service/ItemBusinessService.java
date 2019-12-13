package com.veselov.alex.unittesting.service;

import com.veselov.alex.unittesting.data.ItemRepository;
import com.veselov.alex.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveItem() {
        return new Item(2, "Snagk", 5, 33);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = this.repository.findAll();
        items.forEach(current -> current.setValue(current.getPrice() * current.getQuantity()));
        return items;
    }
}

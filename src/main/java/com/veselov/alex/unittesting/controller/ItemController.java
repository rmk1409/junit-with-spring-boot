package com.veselov.alex.unittesting.controller;

import com.veselov.alex.unittesting.model.Item;
import com.veselov.alex.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    public ItemBusinessService service;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/dummy-item-from-business-layer")
    public Item dummyItemFromBusinessLayer() {
        return this.service.retrieveItem();
    }

    @GetMapping("/all-item-from-data-base")
    public List<Item> dummyItemFromDataLayer() {
        return this.service.retrieveAllItems();
    }
}

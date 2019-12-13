package com.veselov.alex.unittesting.service;

import com.veselov.alex.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {
    public Item retrieveItem() {
        return new Item(2, "Snagk", 5, 33);
    }
}

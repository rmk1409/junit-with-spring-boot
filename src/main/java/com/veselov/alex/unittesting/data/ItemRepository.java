package com.veselov.alex.unittesting.data;

import com.veselov.alex.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}

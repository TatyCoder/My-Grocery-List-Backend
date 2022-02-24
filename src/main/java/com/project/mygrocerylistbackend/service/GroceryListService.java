package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.repository.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceryListService {
    private GroceryListRepository groceryListRepository;

    @Autowired
    public void setGroceryListRepository(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }
}

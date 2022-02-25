package com.project.mygrocerylistbackend.controller;

import com.project.mygrocerylistbackend.model.Item;
import com.project.mygrocerylistbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/user/{userId}/groceryList/{groceryListId}/item")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId
    public Item createItem(@PathVariable Long userId, @PathVariable Long groceryListId, @RequestBody Item itemObject) {
        System.out.println("calling createItem");
        return itemService.createItem(userId, groceryListId, itemObject);
    }

}

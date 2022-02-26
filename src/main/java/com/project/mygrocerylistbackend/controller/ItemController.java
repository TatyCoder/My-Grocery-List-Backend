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

    @PostMapping("/user/{userId}/groceryList/{groceryListId}/item/{categoryId}")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId/item/categoryId
    public Item createItem(@PathVariable Long userId, @PathVariable Long groceryListId, @RequestBody Item itemObject, @PathVariable Long categoryId) {
        System.out.println("calling createItem");
        return itemService.createItem(userId, groceryListId, itemObject, categoryId);
    }

    @GetMapping("/user/{userId}/groceryList/{groceryListId}/item/{itemId}")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId/item/itemId
    public Item getItem(@PathVariable Long userId, @PathVariable Long groceryListId, @PathVariable Long itemId) {
        System.out.println("calling getItem");
        return itemService.getItem(userId, groceryListId, itemId);
    }

    @DeleteMapping("/user/{userId}/groceryList/{groceryListId}/item/{itemId}")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId/item/itemId
    public Item deleteItem(@PathVariable Long userId, @PathVariable Long groceryListId, @PathVariable Long itemId) {
        System.out.println("calling deleteItem");
        return itemService.deleteItem(userId, groceryListId, itemId);
    }

}

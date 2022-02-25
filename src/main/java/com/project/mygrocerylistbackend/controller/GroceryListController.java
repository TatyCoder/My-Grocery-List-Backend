package com.project.mygrocerylistbackend.controller;

import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.service.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")   // url -> http://localhost:9092/api
public class GroceryListController {

    private GroceryListService groceryListService;

    @Autowired
    public void setGroceryListService(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @GetMapping("/user/{userId}/groceryList")   // url -> http://localhost:9092/api/user/userId/groceryList
    public List<GroceryList> getAllGroceryLists(@PathVariable Long userId) {
        System.out.println("calling getAllGroceryLists");
        return groceryListService.getAllGroceryLists(userId);
    }

    @PostMapping("/user/{userId}/groceryList")   // url -> http://localhost:9092/api/user/userId/groceryList
    public GroceryList createGroceryList(@PathVariable Long userId, @RequestBody GroceryList groceryListObject) {
        System.out.println("calling createGroceryList");
        return groceryListService.createGroceryList(userId, groceryListObject);
    }

    @GetMapping("/user/{userId}/groceryList/{groceryListId}")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId
    public GroceryList getGroceryList(@PathVariable Long userId, @PathVariable Long groceryListId) {
        System.out.println("calling getGroceryList");
        return groceryListService.getGroceryList(userId, groceryListId);
    }

    @DeleteMapping("/user/{userId}/groceryList/{groceryListId}")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId
    public GroceryList deleteGroceryList(@PathVariable Long userId, @PathVariable Long groceryListId) {
        System.out.println("calling deleteGroceryList");
        return groceryListService.deleteGroceryList(userId, groceryListId);
    }

}

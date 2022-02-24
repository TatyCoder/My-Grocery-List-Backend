package com.project.mygrocerylistbackend.controller;

import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.User;
import com.project.mygrocerylistbackend.service.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

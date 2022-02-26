package com.project.mygrocerylistbackend.controller;

import com.project.mygrocerylistbackend.model.Category;
import com.project.mygrocerylistbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Category getAllCategories() {
        System.out.println("calling getAllCategories");
        return categoryService.getAllCategories();
    }

    @GetMapping("/user/{userId}/groceryList/{groceryListId}/item/{itemId}/category/{categoryId}")   // url -> http://localhost:9092/api/user/userId/groceryList/groceryListId/item/itemId/category/categoryId
    public Category getCategory(@PathVariable Long userId, @PathVariable Long groceryListId, @PathVariable Long itemId, @PathVariable Long categoryId) {
        System.out.println("calling getCategory");
        return categoryService.getCategory(userId, groceryListId, itemId, categoryId);
    }
}

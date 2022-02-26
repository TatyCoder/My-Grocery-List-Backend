package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.exceptions.InformationNotFoundException;
import com.project.mygrocerylistbackend.model.Category;
import com.project.mygrocerylistbackend.model.Item;
import com.project.mygrocerylistbackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public Category getCategoryByName(String categoryName) {
        Category category = categoryRepository.getCategoryByName(categoryName);
        if (category != null) {
            return category;
        } else {
            throw new InformationNotFoundException("category with name " + categoryName + " not found.");
        }
    }

    public Category getCategoryById(Long categoryId) {
        Category category = categoryRepository.getCategoryByCategoryId(categoryId);
        if (category != null) {
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found.");
        }
    }

    public Category getCategory(Long userId, Long groceryListId, Long itemId, Long categoryId) {
        // This is calling getItem() from ItemService.
        Item item = itemService.getItem(userId, groceryListId, itemId);
        Category category = categoryRepository.getCategoryByCategoryId(categoryId);
        if (category != null) {
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found.");
        }
    }
}

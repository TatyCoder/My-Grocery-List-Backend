package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.User;
import com.project.mygrocerylistbackend.repository.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListService {
    private GroceryListRepository groceryListRepository;

    @Autowired
    public void setGroceryListRepository(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<GroceryList> getAllGroceryLists(Long userId) {
        // This gives me the userObject and throws an exception if it doesn't exist. Is calling getUser() from UserService.
        User user = userService.getUser(userId).get();
        List<GroceryList> groceryList = groceryListRepository.getAllGroceryListsByUser(user);
        return groceryList;
    }
}

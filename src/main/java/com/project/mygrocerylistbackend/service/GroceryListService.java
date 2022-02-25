package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.exceptions.InformationExistException;
import com.project.mygrocerylistbackend.exceptions.InformationNotFoundException;
import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.User;
import com.project.mygrocerylistbackend.repository.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public GroceryList createGroceryList(@PathVariable Long userId, @RequestBody GroceryList groceryListObject) {
        User user = userService.getUser(userId).get();
         GroceryList groceryList = groceryListRepository.getGroceryListByUserAndName(user, groceryListObject.getName());
        if (groceryList == null) {
            groceryListObject.setUser(user);   // This is linking a groceryList to the user.
            return groceryListRepository.save(groceryListObject);
        } else {
            throw new InformationExistException("GroceryList " + groceryListObject.getName() + " already exists.");
        }
    }

    public GroceryList getGroceryList(Long userId, Long groceryListId) {
        User user = userService.getUser(userId).get();
        GroceryList groceryList = groceryListRepository.getGroceryListByUserAndGroceryListId(user, groceryListId);
        if (groceryList != null) {
            return groceryList;
        } else {
            throw new InformationNotFoundException("groceryList with id " + groceryListId + " not found.");
        }
    }

    public GroceryList deleteGroceryList(Long userId, Long groceryListId) {
        User user = userService.getUser(userId).get();
        GroceryList groceryList = groceryListRepository.getGroceryListByUserAndGroceryListId(user, groceryListId);
        if (groceryList != null) {
            groceryListRepository.delete(groceryList);
            return groceryList;
        } else {
            throw new InformationNotFoundException("groceryList with id " + groceryListId + " not found.");
        }
    }

}

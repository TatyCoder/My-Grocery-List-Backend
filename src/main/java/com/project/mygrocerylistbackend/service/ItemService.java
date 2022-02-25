package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.exceptions.InformationExistException;
import com.project.mygrocerylistbackend.exceptions.InformationNotFoundException;
import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.Item;
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

    private GroceryListService groceryListService;

    @Autowired
    public void setGroceryListService(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    public Item createItem(Long userId, Long groceryListId, Item itemObject) {
    //  This is calling getGroceryList() from GroceryService.
        GroceryList groceryList = groceryListService.getGroceryList(userId, groceryListId);
        Item item = itemRepository.getItemByGroceryList(groceryList);
        if (item == null) {
            itemObject.setGroceryList(groceryList);
            return itemRepository.save(itemObject);
        } else {
            throw new InformationExistException("item " + itemObject.getName() + " already exists.");
        }
    }

    public Item deleteItem(Long userId, Long groceryListId, Long itemId) {
        //  This is calling getGroceryList() from GroceryService.
        GroceryList groceryList = groceryListService.getGroceryList(userId, groceryListId);
        Item item = itemRepository.getItemByGroceryListAndItemId(groceryList, itemId);
        if (item != null) {
            itemRepository.delete(item);
            return item;
        } else {
            throw new InformationNotFoundException("item with id " + itemId + " not found.");
        }
    }

}

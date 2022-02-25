package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.exceptions.InformationExistException;
import com.project.mygrocerylistbackend.exceptions.InformationNotFoundException;
import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.Item;
import com.project.mygrocerylistbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public Item createItem(Long userId, Long groceryListId, Item itemObject) {
//    //  This is calling getGroceryList() from GroceryService.
//        GroceryList groceryList = groceryListService.getGroceryList(userId, groceryListId);
//        Item item = itemRepository.getItemByGroceryList(groceryList);
//        if (item == null) {
//            itemObject.setGroceryList(groceryList);
//            return itemRepository.save(itemObject);
//        } else {
//            throw new InformationExistException("item " + itemObject.getName() + " already exists.");
//        }
//    }

    public Item createItem(Long userId, Long groceryListId, Item itemObject) {
        // Is calling getGroceryList() from GroceryService.
        GroceryList groceryList = groceryListService.getGroceryList(userId, groceryListId);
        List<Item> items = itemRepository.getItemsByGroceryList(groceryList);
        // Verify that the grocery list items doesn't already contain the item we're trying to add.
        int count = 0;
        for (Item i : items) {
            if (i.getName().equals(itemObject.getName())){
                count++;
            }
        }
        // This is a better way of doing same thing using stream + filter
        //  Long count = items.stream().filter( i -> i.getName().equals(itemObject.getName())).count();
        if (count == 0) {
            itemObject.setGroceryList(groceryList);
            return itemRepository.save(itemObject);
        } else {
            throw new InformationExistException("item " + itemObject.getName() + " already exists.");
        }
    }

    public Item deleteItem(Long userId, Long groceryListId, Long itemId) {
        // This is calling getGroceryList() from GroceryService.
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

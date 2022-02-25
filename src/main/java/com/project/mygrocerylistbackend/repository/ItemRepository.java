package com.project.mygrocerylistbackend.repository;

import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item getItemByGroceryList(GroceryList groceryList);

    Item getItemByGroceryListAndItemId(GroceryList groceryList, Long item);

    List<Item> getItemsByGroceryList(GroceryList groceryList);
}

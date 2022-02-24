package com.project.mygrocerylistbackend.repository;

import com.project.mygrocerylistbackend.model.GroceryList;
import com.project.mygrocerylistbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {

    List<GroceryList> getAllGroceryListsByUser(User user);
}

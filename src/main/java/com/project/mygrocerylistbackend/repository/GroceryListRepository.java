package com.project.mygrocerylistbackend.repository;

import com.project.mygrocerylistbackend.model.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {
}

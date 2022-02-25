package com.project.mygrocerylistbackend.repository;

import com.project.mygrocerylistbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
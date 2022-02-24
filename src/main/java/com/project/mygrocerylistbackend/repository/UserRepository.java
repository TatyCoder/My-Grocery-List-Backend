package com.project.mygrocerylistbackend.repository;

import com.project.mygrocerylistbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String userName);
}

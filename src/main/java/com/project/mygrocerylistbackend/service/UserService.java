package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.model.User;
import com.project.mygrocerylistbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> user = this.userRepository.findAll();
        return user;
    }

}

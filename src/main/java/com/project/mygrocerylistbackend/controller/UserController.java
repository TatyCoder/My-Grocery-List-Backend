package com.project.mygrocerylistbackend.controller;

import com.project.mygrocerylistbackend.model.User;
import com.project.mygrocerylistbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")   // url -> http://localhost:9092/api
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")   // url -> http://localhost:9092/api/user
    public List<User> getAllUsers() {
        System.out.println("calling getAllUsers");
        return userService.getAllUsers();
    }
}

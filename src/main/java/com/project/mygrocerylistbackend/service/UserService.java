package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.exceptions.InformationExistException;
import com.project.mygrocerylistbackend.model.User;
import com.project.mygrocerylistbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User createUser(User userObject) {
        User user = userRepository.findByName(userObject.getName());
        if (user != null) {
            throw new InformationExistException("user with name " + user.getName() + " already exists.");
        } else {
            return userRepository.save(userObject);
        }
    }

}

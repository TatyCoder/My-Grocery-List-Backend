package com.project.mygrocerylistbackend.service;

import com.project.mygrocerylistbackend.exceptions.InformationExistException;
import com.project.mygrocerylistbackend.exceptions.InformationNotFoundException;
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

    public Optional<User> getUser(Long userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isPresent()) {
            return user;
        } else {
            throw new InformationNotFoundException("user with id " + userId + " not found.");
        }
    }

    public User deleteUser(Long userId) {
        Optional<User> optionalObject = this.userRepository.findById(userId);
        if (optionalObject.isPresent()) {
            User user = optionalObject.get();
            userRepository.delete(user);
            return user;
        } else {
            throw new InformationNotFoundException("user with id " + userId + " not found.");
        }
    }

}

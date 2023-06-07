package com.example.restful_webservice.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restful_webservice.exception.ResourceNotFoundException;
import com.example.restful_webservice.model.User;
import com.example.restful_webservice.repository.UserRepository;
import com.example.restful_webservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Boolean validateUser(String username, String password) {

        User existingUser = userRepository.findByUsername(username);

        if (existingUser == null) {
            throw new ResourceNotFoundException("User does not exist with Username: " + username);
        }

        boolean isValid = (username == existingUser.getUsername() && password == existingUser.getPassword());

        return isValid;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser == null) {
            throw new ResourceNotFoundException("User does not exist with Username: " + user.getUsername());
        }

        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        User existingUser = userRepository.findByUsername(username);

        if (existingUser == null) {
            throw new ResourceNotFoundException("User does not exist with Username: " + username);
        }

        userRepository.delete(existingUser);
    }

    public String getCurrentUsername(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return username;
        }
        return null; // or handle the case when the user is not authenticated
    }

}

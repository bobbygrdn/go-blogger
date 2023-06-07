package com.example.restful_webservice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.restful_webservice.model.User;

public interface UserService {

    // Post
    public User createUser(User user);

    // Post
    public Boolean validateUser(String username, String password);

    // Get One
    public User getUser(String username);

    // Get One
    public String getCurrentUsername(HttpSession session);

    // Get All
    public List<User> getUsers();

    // Put
    public User updateUser(User user);

    // Delete
    public void deleteUser(String username);

}

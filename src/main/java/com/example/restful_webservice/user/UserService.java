package com.example.restful_webservice.user;

import java.util.List;

public interface UserService {

    // Post
    public User createUser(User user);

    // Post
    public Boolean validateUser(String username, String password);

    // Get One
    public User getUser(String username);

    // Get All
    public List<User> getUsers();

    // Put
    public User updateUser(User user);

    // Delete
    public void deleteUser(String username);

}

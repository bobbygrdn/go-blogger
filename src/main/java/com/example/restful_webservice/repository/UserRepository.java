package com.example.restful_webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restful_webservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}

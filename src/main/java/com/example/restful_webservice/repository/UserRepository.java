package com.example.restful_webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.restful_webservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.username = :username")
    public void updatePassword(@Param("username") String username, @Param("password") String password);
}

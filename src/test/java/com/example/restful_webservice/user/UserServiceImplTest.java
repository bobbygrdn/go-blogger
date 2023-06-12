package com.example.restful_webservice.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetUsers() {
        // Arrange

        // Act
        List<User> result = userService.getUsers();

        // Assert
        assertNotNull(result);

    }
}

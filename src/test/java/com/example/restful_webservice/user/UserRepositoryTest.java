package com.example.restful_webservice.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserRepositoryTest {
    @Test
    public void testFindByUsername() {

        // Create mock users
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setUsername("Author1");
        user2.setUsername("Author2");
        user3.setUsername("Author3");

        user1.setPassword("password");
        user2.setPassword("password");
        user3.setPassword("password");

        // Create a mock repository and set it up to return the mock List
        UserRepository repoMock = mock(UserRepository.class);
        when(repoMock.findByUsername(anyString())).thenReturn(user1);

        // Call the method with a mock username
        User result = repoMock.findByUsername("Author1");
        System.out.println(result);

        // Assert that the result matches our expectations
        assertEquals("Author1", result.getUsername());
        assertEquals("password", result.getPassword());
    }

}

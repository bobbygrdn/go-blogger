package com.example.restful_webservice.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.example.restful_webservice.user.User;

public class BlogPostRepositoryTest {
    @Test
    public void testFindByAuthorUsername() {

        // Create mock users
        User user1 = new User();
        User user2 = new User();

        user1.setUsername("Author1");
        user2.setUsername("Author2");

        user1.setPassword("password");
        user2.setPassword("password");

        // Create BlogPosts
        BlogPost blogPost1 = new BlogPost();
        BlogPost blogPost2 = new BlogPost();
        BlogPost blogPost3 = new BlogPost();

        blogPost1.setTitle("Title1");
        blogPost1.setContent("Content1");
        blogPost1.setAuthor(user1);

        blogPost2.setTitle("Title2");
        blogPost2.setContent("Content2");
        blogPost2.setAuthor(user2);

        blogPost3.setTitle("Title3");
        blogPost3.setContent("Content3");
        blogPost3.setAuthor(user1);

        // Create a mock List of BlogPosts
        List<BlogPost> blogPosts = Arrays.asList(
                blogPost1, blogPost2, blogPost3);

        // Create a mock repository and set it up to return the mock List
        BlogPostRepository repoMock = mock(BlogPostRepository.class);
        when(repoMock.findByAuthorUsername(anyString())).thenAnswer(invocation -> {
            String authorUsername = invocation.getArgument(0);
            return blogPosts.stream()
                    .filter(post -> post.getAuthor().getUsername().equals(authorUsername))
                    .collect(Collectors.toList());
        });

        // Call the method with a mock username
        List<BlogPost> result = repoMock.findByAuthorUsername("Author1");

        // Assert that the result matches our expectations
        assertEquals(2, result.size());
        assertEquals("Title1", result.get(0).getTitle());
        assertEquals("Content1", result.get(0).getContent());
        assertEquals("Author1", result.get(0).getAuthor().getUsername());
        assertEquals("Title3", result.get(1).getTitle());
        assertEquals("Content3", result.get(1).getContent());
        assertEquals("Author1", result.get(1).getAuthor().getUsername());
    }

}

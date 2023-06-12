package com.example.restful_webservice.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restful_webservice.user.User;
import com.example.restful_webservice.user.UserRepository;

@SpringBootTest
public class BlogPostServiceTest {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogPostService blogPostService;

    @Test
    public void testGetBlogPost() throws Exception {
        // Arrange
        User user = new User();
        user.setUsername("Author1");
        user.setPassword("password");
        userRepository.save(user);

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Test Title");
        blogPost.setContent("Test Content");
        blogPost.setPublicationDate(LocalDateTime.now());
        blogPost.setAuthor(user);
        blogPostRepository.save(blogPost);

        // Act
        BlogPost result = blogPostService.getBlogPost(blogPost.getId());

        // Assert
        assertNotNull(result);
        assertEquals(blogPost.getId(), result.getId());
        assertEquals("Test Title", result.getTitle());
        assertEquals("Test Content", result.getContent());

    }

    @ParameterizedTest
    @CsvSource({
            "Title 1, Content 1",
            "Title 2, Content 2",
            "Title 3, Content 3",
    })
    void testCreateBlogPost(String title, String content) {
        // Create a new blog post
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setAuthor(userRepository.findByUsername("admin"));
        blogPost.setPublicationDate(LocalDateTime.of(2023, 06, 12, 0, 0));

        // Save the blog post using the service
        blogPostService.createBlogPost(blogPost);

        // Retrieve the blog post from the repository
        BlogPost result = blogPostRepository.findById(blogPost.getId()).orElse(null);

        // Verify that the blog post was saved correctly
        assertEquals(blogPost, result);
    }
}

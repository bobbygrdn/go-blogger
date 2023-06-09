package com.example.restful_webservice.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restful_webservice.exception.ResourceNotFoundException;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost getBlogPost(Long id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course does not exist with the ID: " + id));
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost updateBlogPost(Long id, BlogPost blogPost) {
        BlogPost existingBlogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog Post does not exist with the ID: " + id));

        existingBlogPost.setTitle(blogPost.getTitle());
        existingBlogPost.setContent(blogPost.getContent());
        existingBlogPost.setAuthor(blogPost.getAuthor());

        return blogPostRepository.save(existingBlogPost);
    }

    @Override
    public void deleteBlogPost(Long id) {
        BlogPost existingBlogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog Post does not exist with the ID: " + id));

        blogPostRepository.delete(existingBlogPost);
    }

    @Override
    public List<BlogPost> getAllBlogPostByUsername(String username) {

        return blogPostRepository.findByAuthorUsername(username);
    }

}

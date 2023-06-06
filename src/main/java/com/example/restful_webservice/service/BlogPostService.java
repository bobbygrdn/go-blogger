package com.example.restful_webservice.service;

import java.util.List;

import com.example.restful_webservice.model.BlogPost;

public interface BlogPostService {

    // Post
    public BlogPost createBlogPost(BlogPost blogPost);

    // Get One
    public BlogPost getBlogPost(Long id);

    // Get All
    public List<BlogPost> getAllBlogPosts();

    // Get All
    public List<BlogPost> getAllBlogPostByUsername(String username);

    // Put
    public BlogPost updateBlogPost(Long id, BlogPost blogPost);

    // Delete
    public void deleteBlogPost(Long id);
}

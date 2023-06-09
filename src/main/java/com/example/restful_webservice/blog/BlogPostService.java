package com.example.restful_webservice.blog;

import java.util.List;

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

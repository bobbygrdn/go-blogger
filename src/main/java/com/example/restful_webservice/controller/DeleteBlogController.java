package com.example.restful_webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.service.BlogPostService;

@Controller
public class DeleteBlogController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/deleteBlog/{id}")
    public String DeleteBlog(@PathVariable long id) {
        BlogPost blogPost = blogPostService.getBlogPost(id);

        if (blogPost != null) {
            this.blogPostService.deleteBlogPost(id);
        }

        return "redirect:/myBlogs";
    }
}

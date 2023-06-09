package com.example.restful_webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.service.BlogPostService;

@Controller
public class EditBlogController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/editBlog/{id}")
    public String editBlog(@PathVariable("id") long id, Model model) {

        BlogPost blogPost = blogPostService.getBlogPost(id);

        model.addAttribute("blogPost", blogPost);

        return "editBlog";
    }

    @PutMapping("/editBlog/{id}")
    public String updateBlog(@PathVariable("id") long id, @RequestParam("title") String title,
            @RequestParam("content") String content) {

        BlogPost existingBlogPost = blogPostService.getBlogPost(id);

        if (existingBlogPost == null) {
            return "redirect:/myBlogs";
        }

        existingBlogPost.setTitle(title);
        existingBlogPost.setContent(content);

        return "redirect:/myBlogs";
    }

}

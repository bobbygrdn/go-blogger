package com.example.restful_webservice.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.model.User;
import com.example.restful_webservice.service.BlogPostService;
import com.example.restful_webservice.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CreateBlogController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String createBlogPage() {
        return "createBlog";
    }

    @PostMapping("/create")
    public String createBlog(HttpSession session, @RequestParam("title") String title,
            @RequestParam("content") String content) {

        String username = (String) session.getAttribute("username");

        User user = userService.getUser(username);

        // Create a new Blog object
        BlogPost blog = new BlogPost();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPublicationDate(LocalDateTime.now());
        blog.setAuthor(user);

        // Save the blog post to the database
        blogPostService.createBlogPost(blog);

        // Redirect to the home page
        return "redirect:/home";
    }
}

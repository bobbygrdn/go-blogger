package com.example.restful_webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.repository.BlogPostRepository;

@Controller
public class MyBlogsController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/myBlogs")
    public String showBlogs(Model model) {

        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = userPrincipal.getUsername();

        List<BlogPost> usersBlogPosts = blogPostRepository.findByAuthorUsername(username);

        System.out.println(usersBlogPosts);

        model.addAttribute("usersBlogPosts", usersBlogPosts);
        model.addAttribute("username", username);

        return "myBlogs";
    }
}

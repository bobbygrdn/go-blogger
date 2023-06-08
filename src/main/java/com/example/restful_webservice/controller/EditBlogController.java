package com.example.restful_webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.repository.BlogPostRepository;

@Controller
public class EditBlogController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/editBlog/{id}")
    public String editBlog(@PathVariable("id") long id, Model model) {

        BlogPost blogPost = blogPostRepository.findById(id).get();

        model.addAttribute("blogPost", blogPost);

        return "editBlog";
    }

}

package com.example.restful_webservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.repository.BlogPostRepository;

@Controller
public class BlogDetailController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/blog/{id}")
    public String showBlogDetail(@PathVariable("id") long id, Model model) {
        Optional<BlogPost> blogPostOptional = blogPostRepository.findById(id);

        if (blogPostOptional.isPresent()) {
            BlogPost blogPost = blogPostOptional.get();
            model.addAttribute("blogPost", blogPost);
        }

        return "BlogDetail";
    }
}

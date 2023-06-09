package com.example.restful_webservice.pages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.restful_webservice.blog.BlogPost;
import com.example.restful_webservice.blog.BlogPostRepository;

@Controller
public class HomeController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/home")
    public String homePage(Model model) {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        model.addAttribute("blogPosts", blogPosts);
        return "home";
    }
}

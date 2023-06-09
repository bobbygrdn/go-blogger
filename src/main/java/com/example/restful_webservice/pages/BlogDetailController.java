package com.example.restful_webservice.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.restful_webservice.blog.BlogPost;
import com.example.restful_webservice.blog.BlogPostService;

@Controller
public class BlogDetailController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blog/{id}")
    public String showBlogDetail(Model model, @PathVariable("id") long id) {
        BlogPost existingBlogPost = blogPostService.getBlogPost(id);

        if (existingBlogPost != null) {
            model.addAttribute("blogPost", existingBlogPost);
        }

        return "blogDetail";
    }
}

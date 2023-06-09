package com.example.restful_webservice.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/editBlog/{id}")
    public String updateBlog(@PathVariable("id") long id, @RequestParam("title") String title,
            @RequestParam("content") String content, Model model) {

        BlogPost existingBlogPost = blogPostService.getBlogPost(id);

        existingBlogPost.setTitle(title);
        existingBlogPost.setContent(content);

        blogPostService.updateBlogPost(id, existingBlogPost);

        return "redirect:/myBlogs";
    }

}

package com.example.restful_webservice.blog;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restful_webservice.user.User;
import com.example.restful_webservice.user.UserService;

@Transactional
@Controller
public class BlogPostController {

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

        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = userPrincipal.getUsername();

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

    @GetMapping("/deleteBlog/{id}")
    public String DeleteBlog(@PathVariable long id) {
        BlogPost blogPost = blogPostService.getBlogPost(id);

        if (blogPost != null) {
            this.blogPostService.deleteBlogPost(id);
        }

        return "redirect:/myBlogs";
    }

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

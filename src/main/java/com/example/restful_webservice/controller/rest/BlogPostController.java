package com.example.restful_webservice.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restful_webservice.model.BlogPost;
import com.example.restful_webservice.service.BlogPostService;

@RestController
@RequestMapping("api/v1")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("blogposts")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {

        return blogPostService.createBlogPost(blogPost);

    }

    @GetMapping("blogposts")
    public List<BlogPost> getBlogPosts() {

        return blogPostService.getAllBlogPosts();

    }

    @GetMapping("blogposts/{id}")
    public ResponseEntity<BlogPost> getBlogPost(@PathVariable("id") long blogPostId) {

        BlogPost existingBlogPost = blogPostService.getBlogPost(blogPostId);

        return ResponseEntity.ok(existingBlogPost);

    }

    @PutMapping("blogposts/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable("id") long blogPostId,
            @RequestBody BlogPost blogPost) {

        BlogPost existingBlogPost = blogPostService.updateBlogPost(blogPostId, blogPost);

        return ResponseEntity.ok(existingBlogPost);
    }

    @DeleteMapping("blogposts/{id}")
    public ResponseEntity<String> deleteBlotPost(@PathVariable("id") long blogPostId) {

        blogPostService.deleteBlogPost(blogPostId);

        return ResponseEntity.ok("Blog post deleted");
    }

}

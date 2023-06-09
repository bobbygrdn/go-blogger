package com.example.restful_webservice.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class BlogPostRestController {

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
    public String updateBlogPost(@PathVariable("id") long blogPostId,
            @RequestBody BlogPost blogPost) {

        blogPostService.updateBlogPost(blogPostId, blogPost);

        return "redirect:/myBlogs";
    }

    @DeleteMapping("blogposts/{id}")
    public String deleteBlotPost(@PathVariable("id") long blogPostId) {

        blogPostService.deleteBlogPost(blogPostId);

        return "redirect:/myBlogs";
    }

}

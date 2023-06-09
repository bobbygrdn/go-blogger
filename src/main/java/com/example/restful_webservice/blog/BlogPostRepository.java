package com.example.restful_webservice.blog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByAuthorUsername(String username);
}

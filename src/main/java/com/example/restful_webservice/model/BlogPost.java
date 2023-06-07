package com.example.restful_webservice.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "blog_posts")
@Data
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User author;

    @Column(nullable = false)
    private LocalDateTime publicationDate;
}

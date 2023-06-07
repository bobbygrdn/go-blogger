package com.example.restful_webservice.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

}

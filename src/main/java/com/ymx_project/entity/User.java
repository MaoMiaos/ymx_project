package com.ymx_project.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Data
@Entity
@Table(name = "user")
public class User {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Id
    @GenericGenerator(name = "ksuid", strategy = "com.ymx_project.util.KsuidIdentifierGenerator")
    @GeneratedValue(generator = "ksuid")
    @Column(name = "id")
    private String id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

}

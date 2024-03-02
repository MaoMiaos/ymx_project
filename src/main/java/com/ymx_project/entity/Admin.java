package com.ymx_project.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data // 自动生成getter和setter
@Entity // 标识这是一个JPA实体
@Table(name = "admin") // 指定表名
public class Admin {
    @Id // 标识主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略
    @GenericGenerator(name = "ksuid", strategy = "com.ymx_project.util.KsuidIdentifierGenerator")
    @GeneratedValue(generator = "ksuid")
    @Column(name = "id") // 指定列名
    private String id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;
}
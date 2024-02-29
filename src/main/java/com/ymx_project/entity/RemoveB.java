package com.ymx_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "remove_b")
public class RemoveB {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand")
    private String brand;

    @Column(name = "ASIN")
    private String asin;

    @Column(name = "ASIN_link")
    private String asinLink;

    @Column(name = "create_data")
    private Date createData;
}
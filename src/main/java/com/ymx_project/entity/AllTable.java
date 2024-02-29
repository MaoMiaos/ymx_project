package com.ymx_project.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "all_table")
public class AllTable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASIN")
    private String asin;

    @Column(name = "brand")
    private String brand;

    @Column(name = "ASIN_link")
    private String asinLink;

    @Column(name = "create_data")
    private Date create_data;
}


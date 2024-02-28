package com.ymx_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "remove_a")
public class RemoveA {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASIN")
    private String asin;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "ASIN_LINK")
    private String asinLink;

    @Column(name = "CREATE_DATA")
    private Date createData;
}

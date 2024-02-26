package com.ymx_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "forbid_goods")
public class ForbidGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASIN")
    private String asin;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "ASIN_LINK")
    private String asinLink;

    @Column(name = "GOODS_TYPE")
    private String goodsType;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "HEIGHT")
    private String height;

    @Column(name = "FBA_VALUE")
    private String fbaValue;

    @Column(name = "CREATE_DATA")
    private Date createData;

    @Column(name = "OUT_TYPE")
    private String outType;
}

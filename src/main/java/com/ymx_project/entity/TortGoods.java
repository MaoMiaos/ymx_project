package com.ymx_project.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "tort_goods")
public class TortGoods {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    @Column(name = "ASIN")
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 1)
    private String brand;

    @Column(name = "GOODS_TYPE")
    @ExcelProperty(index = 2)
    //    销量
    private String goodsType;

    @Column(name = "HEIGHT")
    @ExcelProperty(index = 3)
    private String height;

    @Column(name = "PRICE")
    @ExcelProperty(index = 4)
    private String price;

    @Column(name = "FBA_VALUE")
    @ExcelProperty(index = 5)
    private String fbaValue;

    @Column(name = "PICTURE_LINK")
    @ExcelProperty(index = 6)
    private String picture_link;

    @Column(name = "ASIN_LINK")
    @ExcelIgnore
    private String asinLink;

    @Column(name = "CREATE_DATA")
    @ExcelIgnore
    private Date createData;

    @Column(name = "OUT_TYPE")
    @ExcelIgnore
    private String outType;

}

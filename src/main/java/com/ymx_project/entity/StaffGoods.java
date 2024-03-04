package com.ymx_project.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "staff_goods")
public class StaffGoods {

    @ExcelProperty(index = 0,value = "采购链接")
    @Column(name = "caigou_link")
    private String caigouLink;

    @ExcelProperty(index = 1,value = "采购价")
    @Column(name = "caigou_price")
    private String caigouPrice;

    @Id
    @Column(name = "ASIN")
    @ExcelProperty(value = "ASIN",index = 2,converter = CustomStringStringConverter.class)
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 3,value = "品牌")
    private String brand;

    @ExcelProperty(index = 4,value = "月销")
    @Column(name = "goods_count")
    private String goodsCount;

    @Column(name = "HEIGHT")
    @ExcelProperty(index = 5,value = "重量（g）")
    private String height;

    @Column(name = "PRICE")
    @ExcelProperty(index = 6,value = "售价")
    private String price;

    @Column(name = "FBA_VALUE")
    @ExcelProperty(index = 7,value = "FBA费用")
    private String fbaValue;

    @Column(name = "ASIN_LINK")
    @ExcelIgnore
//    @ExcelProperty(index = ,value = "ASIN链接",converter = CustomStringStringConverter.class)
    private String asinLink;

    @Column(name = "CREATE_DATA")
//    @ExcelProperty(value = "创建日期",index = 7)
    @ExcelIgnore
    private Date createData;

    @Column(name = "pic_link")
    @ExcelIgnore
//    @ExcelProperty(index = 6,value = "图片链接",converter = CustomStringStringConverter.class)
    private String picture_link;

    @ExcelIgnore
//    @ExcelProperty(index = 10,value = "采购数量")
    @Column(name = "caigou_count")
    private String caigouCount;

    @ExcelIgnore
//    @ExcelProperty(index = 11,value = "汇率")
    @Column(name = "huilv")
    private String huilv;

    @Column(name = "user_id")
    @ExcelIgnore
    private String userId;

}

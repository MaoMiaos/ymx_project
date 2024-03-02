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


    @Column(name = "ASIN_LINK")
    @ExcelProperty(index = 0,value = "ASIN链接",converter = CustomStringStringConverter.class)
    private String asinLink;

    @Id
    @Column(name = "ASIN")
    @ExcelProperty(value = "ASIN",index = 1,converter = CustomStringStringConverter.class)
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 2,value = "品牌")
    private String brand;

    @Column(name = "HEIGHT")
    @ExcelProperty(index = 3,value = "重量")
    private String height;

    @Column(name = "PRICE")
    @ExcelProperty(index = 4,value = "价格")
    private String price;


    @Column(name = "FBA_VALUE")
    @ExcelProperty(index = 5,value = "FBA值")
    private String fbaValue;

    @Column(name = "CREATE_DATA")
//    @ExcelProperty(value = "创建日期",index = 7)
    @ExcelIgnore
    private Date createData;

    @Column(name = "pic_link")
    @ExcelProperty(index = 6,value = "图片链接",converter = CustomStringStringConverter.class)
    private String picture_link;

    @ExcelProperty(index = 7,value = "月销量")
    @Column(name = "goods_count")
    private String goodsCount;

    @ExcelProperty(index = 8,value = "采购链接")
    @Column(name = "caigou_link")
    private String caigouLink;

    @ExcelProperty(index = 9,value = "采购价格")
    @Column(name = "caigou_price")
    private String caigouPrice;

    @ExcelProperty(index = 10,value = "采购数量")
    @Column(name = "caigou_count")
    private String caigouCount;

    @ExcelProperty(index = 11,value = "汇率")
    @Column(name = "huilv")
    private String huilv;

    @Column(name = "user_id")
    @ExcelIgnore
    private String userId;

}

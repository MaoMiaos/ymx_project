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

@Entity
@Data
@Table(name = "repeat_goods")
public class RepeatGoods {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    @Column(name = "asin")
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 1)
    private String brand;

    @Column(name = "GOODS_COUNT")
    @ExcelProperty(index = 2)
    //    销量
    private String goodsCount;

    @Column(name = "HEIGHT")
    @ExcelProperty(index = 3)
    private String height;

    @Column(name = "PRICE")
    @ExcelProperty(index = 4)
    private String price;

    @Column(name = "FBA_VALUE")
    @ExcelProperty(index = 5)
    private String fbaValue;

    @Column(name = "PIC_LINK")
    @ExcelProperty(index = 6)
    private String picture_link;

    @Column(name = "CREATE_DATA")
    @ExcelIgnore
    private Date createData;

    @Column(name = "ASIN_LINK")
    @ExcelIgnore
    private String asinLink;
}

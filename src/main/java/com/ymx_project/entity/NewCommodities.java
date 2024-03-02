package com.ymx_project.entity;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "new_commodities")
public class NewCommodities {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASIN")
    @ExcelProperty(index = 1,converter = CustomStringStringConverter.class)
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 2)
    private String brand;

    @Column(name = "ASIN_LINK")
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    private String asinLink;

    @Column(name = "GOODS_TYPE")
    @ExcelProperty(index = 3)
    private String goodsType;

    @Column(name = "PRICE")
    @ExcelProperty(index = 5)
    private String price;

    @Column(name = "HEIGHT")
    @ExcelProperty(index = 4)
    private String height;

    @Column(name = "FBA_VALUE")
    @ExcelProperty(index = 6)
    private String fbaValue;

    @Column(name = "CREATE_DATA")
//    @ExcelProperty(value = "创建日期",index = 7)
    private Date createData;
    @Column(name = "pic_link")
    @ExcelProperty(index = 8,converter = CustomStringStringConverter.class)
    private String picture_link;
}

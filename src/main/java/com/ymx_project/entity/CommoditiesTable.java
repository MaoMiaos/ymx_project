package com.ymx_project.entity;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "commodities_table")
public class CommoditiesTable {

    @Column(name = "PICTURE_LINK")
    @ExcelProperty(index = 0)
    private String picture_link;


    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 1,converter = CustomStringStringConverter.class)
    @Column(name = "ASIN")
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 2)
    private String brand;

    @Column(name = "ASIN_LINK")
    private String asinLink;

    @Column(name = "GOODS_TYPE")
    @ExcelProperty(index = 3)
        //    销量
    private String goodsType;

    @Column(name = "HEIGHT")
    @ExcelProperty(index = 4)
    private String height;


    @Column(name = "PRICE")
    @ExcelProperty(index = 5)
    private String price;



    @Column(name = "FBA_VALUE")
    @ExcelProperty(index = 6)
    private String fbaValue;

    @Column(name = "CREATE_DATA")
    private Date createData;

    @Column(name = "USER_ID")
    private String userId;


}

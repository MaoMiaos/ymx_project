package com.ymx_project.entity;
import com.alibaba.excel.annotation.ExcelProperty;
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
    @ExcelProperty(value = "ASIN",index = 0)
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(value = "品牌",index = 1)
    private String brand;

    @Column(name = "ASIN_LINK")
    @ExcelProperty(value = "ASIN超链接",index = 2)
    private String asinLink;

    @Column(name = "GOODS_TYPE")
    @ExcelProperty(value = "商品类别",index = 3)
    private String goodsType;

    @Column(name = "PRICE")
    @ExcelProperty(value = "商品价格",index = 4)
    private String price;

    @Column(name = "HEIGHT")
    @ExcelProperty(value = "商品重量",index = 5)
    private String height;

    @Column(name = "FBA_VALUE")
    @ExcelProperty(value = "FBA值",index = 6)
    private String fbaValue;

    @Column(name = "CREATE_DATA")
    @ExcelProperty(value = "创建日期",index = 7)
    private Date createData;
}

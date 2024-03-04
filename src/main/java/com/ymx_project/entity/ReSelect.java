package com.ymx_project.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "re_select")
public class ReSelect {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    @Column(name = "ASIN")
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 1,converter = CustomStringStringConverter.class)
    private String brand;

    @Column(name = "ASIN_LINK")
    @ExcelIgnore
    private String asinLink;

    @Column(name = "CREATE_DATA")
    @ExcelIgnore
    private Date createData;
}


package com.ymx_project.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "all_table")
public class AllTable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASIN")
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    private String asin;

    @ExcelProperty(index = 1,converter = CustomStringStringConverter.class)
    @Column(name = "brand")
    private String brand;

    @Column(name = "ASIN_link")
    @ExcelIgnore
    private String asinLink;

    @Column(name = "create_data")
    @ExcelIgnore
    private Date create_data;
}


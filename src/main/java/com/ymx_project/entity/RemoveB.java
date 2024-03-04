package com.ymx_project.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "remove_b")
public class RemoveB {

    @Column(name = "ASIN")
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    private String asin;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(index = 1,converter = CustomStringStringConverter.class)
    @Column(name = "brand")
    private String brand;



    @Column(name = "ASIN_link")
    @ExcelIgnore
    private String asinLink;

    @Column(name = "create_data")
    @ExcelIgnore
    private Date createData;
}
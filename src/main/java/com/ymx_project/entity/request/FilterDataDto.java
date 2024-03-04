package com.ymx_project.entity.request;

import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class FilterDataDto {

    @Id
    @Column(name = "ASIN")
    @ExcelProperty(index = 0,converter = CustomStringStringConverter.class)
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(index = 2)
    private String brand;

}

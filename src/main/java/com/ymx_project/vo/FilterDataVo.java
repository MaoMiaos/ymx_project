package com.ymx_project.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.ymx_project.util.CustomStringStringConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class FilterDataVo {
    @Id
    @Column(name = "ASIN")
    @ExcelProperty(value = "ASIN",converter = CustomStringStringConverter.class)
    private String asin;

    @Column(name = "BRAND")
    @ExcelProperty(value = "品牌")
    private String brand;
}

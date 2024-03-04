package com.ymx_project.util;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
public class HyperlinkConverter implements Converter<String> {

    @Override
    public Class<?> supportJavaTypeKey() {
        // 指定支持的Java类型
        return String.class;
    }

//    @Override
//    public CellDataTypeEnum supportExcelTypeKey() {
//        // 指定支持的Excel类型
//        return CellDataTypeEnum.HYPERLINK;
//    }

    @Override
    public String convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        // 检查单元格是否为超链接
        log.info("demo:{}",JSON.toJSONString(cellData));
        // 如果不是超链接，返回null或者原始值
        return null;
    }
//
//    // 这个方法通常用于写操作，这里不需要实现
//    @Override
//    public WriteCellData<?> convertToExcelData(T value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
//        throw new UnsupportedOperationException("Convert to Excel data is not supported for hyperlinks.");
//    }
}
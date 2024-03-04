package com.ymx_project.util;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.WriteHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomStringStringConverter implements Converter<String> ,WriteHandler{
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     *解开ASIN的超链接，同时将超链接作为String类型存入数据库
     * @param context
     * @return
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
        // 检查单元格是否为超链接
        log.info("demo:{}",context.getReadCellData().getType());
        // 如果不是超链接，返回null或者原始值
        return ""+context.getReadCellData().getStringValue();
    }
//
//    @Override
//    public String convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
//        // 检查单元格是否为超链接
//        log.info("demo:{}",JSON.toJSONString(cellData));
//        // 如果不是超链接，返回null或者原始值
//        return "test";
//    }

    /**
     * 这里是写的时候会调用 不用管
     * 包装String的超链接为Hyperlink,并写入表中
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        String asin = context.getValue();

//        log.info("写出asin{}",JSON.toJSONString(context.getValue()));
//
//        WriteCellData<Hyperlink> hyperlink = new WriteCellData<>("B0CM9FM3HW");
//        HyperlinkData hyperlinkData = new HyperlinkData();
//        try {
//            hyperlinkData.setAddress(context.getValue());
//            hyperlinkData.setHyperlinkType(HyperlinkData.HyperlinkType.URL);
//            hyperlink.setHyperlinkData(hyperlinkData);
//            Hyperlink hy
//            return hyperlink;
//        }catch (Exception e){
//            log.error(e.getMessage(), e);
//            return null;
//        }
        return new WriteCellData<>(context.getValue());
    }

}


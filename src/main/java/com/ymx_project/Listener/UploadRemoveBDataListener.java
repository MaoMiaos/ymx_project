package com.ymx_project.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;


import com.ymx_project.entity.RemoveB;
import com.ymx_project.repository.RemoveBRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class UploadRemoveBDataListener implements ReadListener<RemoveB> {


    private String asinToJavaData;
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    private List<RemoveB> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private RemoveBRepository removeBRepository;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param removeBRepository
     */
    public UploadRemoveBDataListener(RemoveBRepository removeBRepository) {
        this.removeBRepository = removeBRepository;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. It is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(RemoveB data, AnalysisContext context) {
        String data1 = JSON.toJSONString(data);
        log.info("解析到一条数据:{}", data1);
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        Iterator<RemoveB> it = cachedDataList.iterator();
        while(it.hasNext()) {
            RemoveB removeB = it.next();
            removeB.setAsinLink(asinToJavaData);
            removeBRepository.save(removeB);
        }
        log.info("存储数据库成功！");
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        if (extra.getType() == CellExtraTypeEnum.HYPERLINK){
            log.info("在extra读取到了一条额外信息:{}", JSON.toJSONString(context));
            log.info("在extra读取到了一条额外信息:{}", JSON.toJSONString(extra));
            asinToJavaData = extra.getText();
            if (extra.getText().contains("http")) {
                log.info("额外信息是ASIN超链接,在rowIndex:{},columnIndex;{},内容是:{}", extra.getRowIndex(),
                        extra.getColumnIndex(), extra.getText());

            } else if ("Sheet2!A1".equals(extra.getText())) {
                log.info(
                        "额外信息是超链接,而且覆盖了一个区间,在firstRowIndex:{},firstColumnIndex;{},lastRowIndex:{},lastColumnIndex:{},"
                                + "内容是:{}",
                        extra.getFirstRowIndex(), extra.getFirstColumnIndex(), extra.getLastRowIndex(),
                        extra.getLastColumnIndex(), extra.getText());
            } else {
                Assert.hasLength("Unknown hyperlink!");
            }
        }else if(extra.getType() == CellExtraTypeEnum.COMMENT){
            log.info("额外信息是批注,在rowIndex:{},columnIndex;{},内容是:{}", extra.getRowIndex(), extra.getColumnIndex(),
                    extra.getText());
        }else if(extra.getType() == CellExtraTypeEnum.MERGE){
            log.info(
                    "额外信息是MERGE,而且覆盖了一个区间,在firstRowIndex:{},firstColumnIndex;{},lastRowIndex:{},lastColumnIndex:{}",
                    extra.getFirstRowIndex(), extra.getFirstColumnIndex(), extra.getLastRowIndex(),
                    extra.getLastColumnIndex());
        }
    }



}

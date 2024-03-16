package com.ymx_project.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.read.listener.ReadListener;
import com.ymx_project.Listener.UploadAllTableDataListener;
import com.ymx_project.entity.AllTable;
import com.ymx_project.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ExcelReaderService {

    private final AllTableRepository allTableRepository;
    private final RemoveBRepository removeBRepository;
    private final RemoveARepository removeARepository;
    private final ReSelectRepository reSelectRepository;
    private final CommoditiesTableRepository commoditiesTableRepository;
    private final NewCommoditiesRepository newCommoditiesRepository;
    private final TortGoodsRepository tortGoodsRepository;
    private final ForbidGoodsRepository forbidGoodsRepository;
    private final CheapGoodsRepository cheapGoodsRepository;
    private final RepeatGoodsRepository repeatGoodsRepository;



    public void readExcelFile(MultipartFile file, Class<?> head, ReadListener<?> listener) throws IOException {
        EasyExcel.read(file.getInputStream(), head, listener)
                .extraRead(CellExtraTypeEnum.HYPERLINK)
                .headRowNumber(0)
                .sheet().doRead();
    }

    public void writeExcelFile(MultipartFile file, Class<?> write, ReadListener<?> listener) throws IOException{
        EasyExcel.read(file.getInputStream(), write, listener)
                .extraRead(CellExtraTypeEnum.HYPERLINK)
                .headRowNumber(0)
                .sheet().doRead();
    }
}

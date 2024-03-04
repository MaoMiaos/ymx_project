package com.ymx_project.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.ReadListener;
import com.ymx_project.Listener.UploadAllTableDataListener;
import com.ymx_project.entity.AllTable;
import com.ymx_project.repository.AllTableRepository;
import java.io.IOException;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("alltable")
@CrossOrigin
public class AllTableController {
    private final AllTableRepository allTableRepository;

    public AllTableController(AllTableRepository allTableRepository) {
        this.allTableRepository = allTableRepository;
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("tableName") String tableName) throws IOException {
        EasyExcel.read(file.getInputStream(), AllTable.class, new UploadAllTableDataListener(allTableRepository))
                .extraRead(CellExtraTypeEnum.COMMENT)
                .extraRead(CellExtraTypeEnum.HYPERLINK)
                .extraRead(CellExtraTypeEnum.MERGE)
                .headRowNumber(0)
                .sheet().doRead();
        return "success";
    }
}

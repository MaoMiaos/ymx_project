package com.ymx_project.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.ymx_project.Listener.UploadAllTableDataListener;
import com.ymx_project.Listener.UploadCommoditiesTableDataListener;
import com.ymx_project.entity.Admin;
import com.ymx_project.entity.AllTable;
import com.ymx_project.entity.request.TableNameRequest;
import com.ymx_project.entity.request.UserCreateRequest;
import com.ymx_project.repository.AdminRepository;
import com.ymx_project.repository.AllTableRepository;
import com.ymx_project.service.AdminService;
import com.ymx_project.service.AllTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("admin")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
@ResponseBody
public class AdminController {

    private final AdminService adminService;


    @PostMapping("/create")
    void CreateAdmin(@RequestBody UserCreateRequest userCreateRequest){
        adminService.create(userCreateRequest);
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("tableName") String tableName) throws IOException {
        adminService.upload(file, tableName);
        return "success";
    }

    @GetMapping("/download")
    private void download(HttpServletResponse response,@RequestParam("tableName") String tableName) throws IOException {
        adminService.download(response, tableName);
    }

    @PostMapping("/remove")
    private void remove(@RequestBody TableNameRequest tableName){
        adminService.remove(tableName.getTableName());
    }


    @PostMapping("/select")
    private String select(@RequestBody TableNameRequest tableName){
        return Long.toString(adminService.select(tableName.getTableName()));

    }

    @PostMapping("/filterExcel")
    private void filterExcel(@RequestParam("file") MultipartFile file,@RequestBody TableNameRequest tableName) throws IOException {
        adminService.filterExcel(file,tableName.getTableName());
    }



}

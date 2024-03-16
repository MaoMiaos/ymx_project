package com.ymx_project.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.fastjson.JSON;
import com.ymx_project.Listener.*;
import com.ymx_project.entity.*;
import com.ymx_project.repository.*;
import com.ymx_project.service.AdminService;
import com.ymx_project.request.UserCreateRequest;
import com.ymx_project.service.ExcelReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
    public Admin create(UserCreateRequest userCreateRequest) {
        Admin admin = new Admin();
        Optional<Admin> byUsername = adminRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        admin.setUsername(userCreateRequest.getUsername());
//        admin.setPassword(userCreateRequest.getPassword());
        admin.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getPassword()));
        return adminRepository.save(admin);
    }

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
    private final ExcelReaderService excelReaderService;
    @Override
    public String upload(MultipartFile file, String fileName) throws IOException {
        if (file == null) {
            return "failure";
        }
        switch (fileName) {
            case "all_table":
                excelReaderService.readExcelFile(file,AllTable.class, new UploadAllTableDataListener(allTableRepository));
                break;
            case "remove_a":
                excelReaderService.readExcelFile(file,RemoveA.class, new UploadRemoveADataListener(removeARepository));
                break;
            case "remove_b":
                excelReaderService.readExcelFile(file,RemoveB.class, new UploadRemoveBDataListener(removeBRepository));
                break;
            case "re_select":
                excelReaderService.readExcelFile(file,ReSelect.class, new UploadReSelectDataListener(reSelectRepository));
                break;
            case "commodities_table":
                excelReaderService.readExcelFile(file,CommoditiesTable.class, new UploadCommoditiesTableDataListener(commoditiesTableRepository));
                break;
            case "new_commodities":
                excelReaderService.readExcelFile(file,NewCommodities.class, new UploadNewCommoditiesDataListener(newCommoditiesRepository));
                break;
            case "forbid_goods":
                excelReaderService.readExcelFile(file,ForbidGoods.class, new UploadForbidGoodsDataListener(forbidGoodsRepository));
                break;
            case "tort_goods":
                excelReaderService.readExcelFile(file,TortGoods.class, new UploadTortGoodsDataListener(tortGoodsRepository));
                break;
            case "cheap":
                excelReaderService.readExcelFile(file,CheapGoods.class, new UploadCheapGoodsDataListener(cheapGoodsRepository));
                break;
            case "repeat":
                excelReaderService.readExcelFile(file,RepeatGoods.class, new UploadRepeatGoodsDataListener(repeatGoodsRepository));
                EasyExcel.read(file.getInputStream(), RepeatGoods.class, new UploadRepeatGoodsDataListener(repeatGoodsRepository))
                        .extraRead(CellExtraTypeEnum.HYPERLINK)
                        .headRowNumber(0)
                        .sheet().doRead();
                break;
        }
        return fileName;
    }

    @Override
    public void download(HttpServletResponse response, String tableName) throws IOException {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            switch (tableName) {
                // 这里需要设置不关闭流
                case "all_table":
                    EasyExcel.write(response.getOutputStream(), AllTable.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(allTableRepository.findAll());
                    break;
                case "remove_a":
                    EasyExcel.write(response.getOutputStream(), RemoveA.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(removeARepository.findAll());
                    break;
                case "remove_b":
                    EasyExcel.write(response.getOutputStream(), RemoveB.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(removeBRepository.findAll());
                    break;
                case "re_select":
                    EasyExcel.write(response.getOutputStream(), ReSelect.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(reSelectRepository.findAll());
                    break;
                case "commodities_table":
                    EasyExcel.write(response.getOutputStream(), CommoditiesTable.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(commoditiesTableRepository.findAll());
                    break;
                case "new_commodities":
                    EasyExcel.write(response.getOutputStream(), NewCommodities.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(newCommoditiesRepository.findAll());
                    break;
                case "forbid_goods":
                    EasyExcel.write(response.getOutputStream(), ForbidGoods.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(forbidGoodsRepository.findAll());
                    break;
                case "tort_goods":
                    EasyExcel.write(response.getOutputStream(), TortGoods.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(tortGoodsRepository.findAll());
                    break;
                case "cheap":
                    EasyExcel.write(response.getOutputStream(), CheapGoods.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(cheapGoodsRepository.findAll());
                    break;
                case "repeat":
                    EasyExcel.write(response.getOutputStream(), RepeatGoods.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                            .doWrite(repeatGoodsRepository.findAll());
            }

        } catch (Exception e) {
            // 重置response
            Map<String, String> map = MapUtils.newHashMap();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }

    }

    @Override
    public Long select(String tableName) {
        long count;
        switch (tableName) {
            // 这里需要设置不关闭流
            case "all_table":
                return allTableRepository.count();
            case "remove_a":
                return removeARepository.count();
            case "remove_b":
                return removeBRepository.count();
            case "re_select":
                return reSelectRepository.count();
            case "commodities_table":
                return commoditiesTableRepository.count();
            case "new_commodities":
                return newCommoditiesRepository.count();
            case "forbid_goods":
                return forbidGoodsRepository.count();
            case "tort_goods":
                return tortGoodsRepository.count();
            case "cheap":
                return cheapGoodsRepository.count();
            case "repeat":
                return repeatGoodsRepository.count();
        }
        return 0L;
    }

    @Override
    public void filterExcel(MultipartFile file, String tableName) throws IOException {
        switch (tableName) {
            // 这里需要设置不关闭流
            case "all_table":
                excelReaderService.writeExcelFile(file,AllTable.class, new UploadAllTableDataListener(allTableRepository));
                break;
            case "remove_a":
                excelReaderService.writeExcelFile(file,RemoveA.class, new UploadRemoveADataListener(removeARepository));
                break;
            case "remove_b":
                excelReaderService.writeExcelFile(file,RemoveB.class, new UploadRemoveBDataListener(removeBRepository));
                break;
            case "re_select":
                excelReaderService.writeExcelFile(file,ReSelect.class, new UploadReSelectDataListener(reSelectRepository));
                break;
            case "commodities_table":
                excelReaderService.writeExcelFile(file,CommoditiesTable.class, new UploadCommoditiesTableDataListener(commoditiesTableRepository));
                break;
            case "new_commodities":
                excelReaderService.writeExcelFile(file,NewCommodities.class, new UploadNewCommoditiesDataListener(newCommoditiesRepository));
                break;
            case "forbid_goods":
                excelReaderService.writeExcelFile(file,ForbidGoods.class, new UploadForbidGoodsDataListener(forbidGoodsRepository));
                break;
            case "tort_goods":
                excelReaderService.writeExcelFile(file,TortGoods.class, new UploadTortGoodsDataListener(tortGoodsRepository));
                break;
        }
    }

    @Override
    public void remove(String tableName) {
        switch (tableName) {
            // 这里需要设置不关闭流
            case "all_table":
                allTableRepository.deleteAll();
                break;
            case "remove_a":
                removeARepository.deleteAll();
                break;
            case "remove_b":
                removeBRepository.deleteAll();
                break;
            case "re_select":
                reSelectRepository.deleteAll();
                break;
            case "commodities_table":
                commoditiesTableRepository.deleteAll();
                break;
            case "new_commodities":
                newCommoditiesRepository.deleteAll();
                break;
            case "forbid_goods":
                forbidGoodsRepository.deleteAll();
                break;
            case "tort_goods":
                tortGoodsRepository.deleteAll();
                break;
            case "cheap":
                cheapGoodsRepository.deleteAll();
            case "repeat":
                repeatGoodsRepository.deleteAll();
        }
    }

}

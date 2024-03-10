package com.ymx_project.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.ymx_project.Listener.UploadCommoditiesTableDataListener;
import com.ymx_project.entity.*;
import com.ymx_project.entity.request.CommoditiesTableRequest;
import com.ymx_project.entity.request.TableNameRequest;
import com.ymx_project.entity.request.UserIdRequest;
import com.ymx_project.repository.*;
import com.ymx_project.service.CommoditiesTableService;
import com.ymx_project.service.StaffGoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;

//@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/staff")
public class CommoditiesTableController {

    private final CommoditiesTableRepository commoditiesTableRepository;


    private final CommoditiesTableService commoditiesTableService;

    private final StaffGoodsService staffGoodsService;

    private final UserRepository userRepository;

    @PostMapping("update_commodities")
    String addCommodities(@RequestBody CommoditiesTableRequest commoditiesTableRequest) throws ParseException {
        commoditiesTableService.addCommodities(commoditiesTableRequest);
        return "OK";
    }

    // TODO: 3/3/2024 增加锁数据逻辑 
    @PostMapping("query_commodities")
    CommoditiesTable getRandomData(@RequestBody UserIdRequest userIdRequest){
        return commoditiesTableService.getRandomData(userIdRequest.getUserId());
    }

    @PostMapping("my_commodities")
    List<StaffGoods> getMyCommodities(@RequestBody UserIdRequest userIdRequest){
//        log.info("{}messagea",userIdRequest.getUserId());
        return staffGoodsService.findAllByUserId(userIdRequest.getUserId());
    }

    // TODO: 3/2/2024 增加一个超链接到表中 
    @GetMapping("out_myCommodities")
    public void out_commodities(HttpServletResponse response,@RequestParam("userId") String userId) throws IOException, ParseException {
//        log.info("{}userid",userId);
        String username =  userRepository.findUsernameById(userId);
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(username, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), StaffGoods.class).sheet(username).doWrite(staffGoodsService.findAllByUserId(userId));
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,@RequestParam("tableName") String tableName) throws IOException {
        if (file == null){
            return "failure";
        }
        System.out.println("收到文件");
        EasyExcel.read(file.getInputStream(), CommoditiesTable.class, new UploadCommoditiesTableDataListener(commoditiesTableRepository))
                // 需要读取批注 默认不读取
                .extraRead(CellExtraTypeEnum.COMMENT)
                // 需要读取超链接 默认不读取
                .extraRead(CellExtraTypeEnum.HYPERLINK)
                // 需要读取合并单元格信息 默认不读取
                .extraRead(CellExtraTypeEnum.MERGE)
                //从第一行开始读
                .headRowNumber(0)
                .sheet().doRead();
        return "success";
    }


}

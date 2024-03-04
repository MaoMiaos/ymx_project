package com.ymx_project.controller;


import com.alibaba.excel.EasyExcel;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.fastjson.JSON;
import com.ymx_project.Listener.UploadNewCommoditiesDataListener;
import com.ymx_project.entity.NewCommodities;
import com.ymx_project.repository.NewCommoditiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
@CrossOrigin
@RequiredArgsConstructor
public class DefaultController {

    @GetMapping
    public String login(){
        return "hello";
    }

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link NewCommodities}
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    private final NewCommoditiesRepository newCommoditiesRepository;


    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException, ParseException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试11", "UTF-8").replaceAll("\\+", "%20");

        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream(), NewCommodities.class).sheet("模板").doWrite(newCommoditiesRepository.findAll());
    }

    @GetMapping("download1")

    public void downloadFailedUsingJson(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), NewCommodities.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                    .doWrite(newCommoditiesRepository.findAll());
        } catch (Exception e) {
            // 重置response
            Map<String, String> map = MapUtils.newHashMap();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link NewCommodities}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadNewCommoditiesDataListener}
     * <p>3. 直接读即可
     */
    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null){
            return "failure";
        }
        System.out.println("收到文件");
//        EasyExcel.read(file.getInputStream(), NewCommodities.class, new UploadDataListener(newCommoditiesRepository)).sheet().doRead();
        EasyExcel.read(file.getInputStream(), NewCommodities.class, new UploadNewCommoditiesDataListener(newCommoditiesRepository))
                // 需要读取批注 默认不读取
                .extraRead(CellExtraTypeEnum.COMMENT)
                // 需要读取超链接 默认不读取
                .extraRead(CellExtraTypeEnum.HYPERLINK)
                // 需要读取合并单元格信息 默认不读取
                .extraRead(CellExtraTypeEnum.MERGE).sheet().doRead();

        return "console.log('success')";
    }

}

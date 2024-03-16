package com.ymx_project.service;

import com.ymx_project.entity.Admin;
import com.ymx_project.request.UserCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public interface AdminService {

    Admin create(UserCreateRequest userCreateRequest);

    String upload(MultipartFile file, String fileName) throws IOException;

    void download(HttpServletResponse response, String tableName) throws IOException;

    Long select(String tableName);

    void filterExcel(MultipartFile file, String tableName) throws IOException;

    void remove(String tableName);
}

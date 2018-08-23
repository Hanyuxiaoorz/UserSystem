package com.mis.user.backstagemanagement.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Service
public interface ExcelInputService {

    String batchImport(String fileName, MultipartFile mfile, HttpSession session);
    String readExcel(Workbook wb, File tempFile);
}

package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.iml.ExcelInputServiceImpl;
import com.mis.user.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/backstageManagement")
public class ExcelInput {

    @Autowired
    ExcelInputServiceImpl excelInputServiceIml;

    /**
     * @param file
     * @param session
     * */
    @RequestMapping(value = "/excelUserInfo",method = POST)
    public Object upload(@RequestParam(value="file", required = false)MultipartFile file, HttpSession session) throws Exception {
        Map map = new HashMap<String,String>(16);
        try {
            //判断文件是否为空
            if (file == null) {
                map.clear();
                //4,文件为空
                map.put("excelUserInfo","您所上传文件为空！！");
            }

            //获取文件名
            String fileName = file.getOriginalFilename();

            //验证文件名是否合格
            if (!ExcelUtil.validateExcel(fileName)) {
                map.clear();
                //3，文件不符合要求
                map.put("excelUserInfo","文件类型不符合要求");
            }

            //获取到文件名后，再次判断是否符合要求，是否为空
            long size = file.getSize();
            if (StringUtils.isEmpty(fileName) || size == 0) {
                //4,文件大小或名称为空
                map.put("excelUserInfo","文件大小或名称为空!!");
            }

            //批量导入
            String message = excelInputServiceIml.batchImport(fileName,file,session);
            map.clear();
            map.put("excelUserInfo",message);

        }catch (Exception e){
            map.clear();
            map.put("excelUserInfo","上传失败！！！");
            e.printStackTrace();
        }
        return JSON.toJSON(map);
    }
}
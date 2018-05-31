package com.mis.user.backstagemanagement.controller;

import com.mis.user.backstagemanagement.service.iml.UpdateDatasServiceIml;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/backstageManagement")
public class UpdateDatas {

    @RequestMapping(value = "/updateUserInfo",method = POST)
    public String upload(@RequestParam(value = "file", required = false)
                                     MultipartFile file, HttpServletRequest request, ModelMap model, Model mod) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println("文件路径为"+path);
        String originDileName = file.getOriginalFilename();
        String type = file.getContentType();
        System.out.println("目标文件名称"+originDileName+"目标文件类型"+type);
        File targetFile = new File(path,originDileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }else if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //获得上传文件的扩展名
        String subName = originDileName.substring(originDileName.lastIndexOf(".")+1);
        System.out.println("文件扩展名"+subName);

        try{
            file.transferTo(targetFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        UpdateDatasServiceIml updateDatasServiceIml = new UpdateDatasServiceIml();
        String rootPath = path+File.separator + originDileName;
        List<String[]> excellist =updateDatasServiceIml.readExcel(rootPath);
        int len = excellist.size();
        System.out.println("集合长度为"+len);
        for(int i = 0; i < len;i++){
            String[] fileds = excellist.get(i);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String userName = fileds[0];
            Double valueOf = Double.valueOf(fileds[i]);
            int sampleType = valueOf.intValue();
            String password = fileds[2];
            String sex = fileds[3];

        }
        return null;
    }
    }

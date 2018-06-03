package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.iml.ExcelInputServiceIml;
import com.mis.user.canstants.Canstants;
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

    Map map = new HashMap();
    @Autowired
    ExcelInputServiceIml excelInputServiceIml;
    @RequestMapping(value = "/excelUserInfo",method = POST)
    public Object upload(@RequestParam(value="file", required = false)MultipartFile file, HttpSession session) throws Exception {
        //判断文件是否为空
        if (file == null) {
            return Canstants.BACK_NULL;//4,文件为空
        }

        //获取文件名
        String fileName = file.getOriginalFilename();

        //验证文件名是否合格
        if (!ExcelUtil.validateExcel(fileName)) {
            return Canstants.BACK_PERMISSION_NULL;//3，文件不符合要求
        }

        //获取到文件名后，再次判断是否符合要求，是否为空
        long size = file.getSize();
        if (StringUtils.isEmpty(fileName) || size == 0) {
            return Canstants.BACK_NULL;//4,文件大小或名称为空
        }

        //批量导入
        String message = excelInputServiceIml.batchImport(fileName,file,session);
        map.clear();
        map.put("excelUserInfo",message);
        return JSON.toJSON(map);
    }
}





















        /*String path = request.getSession().getServletContext().getRealPath("upload");
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
    }*/

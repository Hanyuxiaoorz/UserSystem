package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.model.UserShowInfo;
import com.mis.user.canstants.Canstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserImage {
    Map map = new HashMap<String,String>();
    @Value("${file.path}")
    private String filePath;
    @RequestMapping(value = "/userImg",method = POST)
    public Object userImg(@RequestParam(value="file")MultipartFile file, HttpSession session) throws Exception {
        if(session.getAttribute("user")!= null || session.getAttribute("token") != null) {
            String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            File file1 = new File("D:\\userImg\\"+session.getAttribute("user"));
            //判断文件夹是否存在，不存在的话增加后缀，添加自己的文件夹，防止无限添加
            if(!file1.exists()){
                //创建文件夹，用于存放个人数据
                file1.mkdir();
                filePath = filePath + session.getAttribute("user")+"\\";
            }
            String fileName = session.getAttribute("user")+extName;
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(filePath+ fileName)));
            map.put("userImg",Canstants.SUCCESS);
        }
        else{
            map.put("userImg",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    @RequestMapping(value = "/userPhoto",method = POST)
    public Object userPhoto(HttpSession session,HttpServletResponse response){
        if (session.getAttribute("user") != null || session.getAttribute("token") != null){
            FileInputStream fis = null;
            response.setContentType("image/gif");
            try {
                OutputStream out = response.getOutputStream();
                File file = new File(filePath+File.separator+session.getAttribute("user")+".jpg");
                fis = new FileInputStream(file);
                byte[] b = new byte[fis.available()];
                fis.read(b);
                out.write(b);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }


































        /*UserShowInfo userShowInfo = new UserShowInfo();
        if(! file.isEmpty()){
            try {
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("f:\\旗杯\\demo5\\src\\main\\webapp\\"+userShowInfo.getUserName()+".jpg")));//保存图片到目录下)
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
                String filename="f:\\旗杯\\demo5\\src\\main\\webapp\\"+userShowInfo.getUserName()+".jpg";
                *//*user.setTupian(filename);*//*
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return Canstants.SUCCESS;
        } else {
            return "上传失败，因为文件是空的.";
        }
    }*/
}

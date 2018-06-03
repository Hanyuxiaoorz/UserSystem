package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.canstants.Canstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserImage {
    Map map = new HashMap<String,String>();
    @Value("${file.path}")
    private String filePath;
    @RequestMapping(value = "/userImg",method = POST)
    public Object userImg(@RequestParam(value="file")MultipartFile file, HttpSession session) throws Exception {
        map.clear();
        try{
            if(session.getAttribute("user")!= null || session.getAttribute("token") != null) {
                String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                File file1 = new File("D:"+File.separator+"SSOUser"+File.separator+session.getAttribute("user"));
                //判断文件夹是否存在，不存在的话增加后缀，添加自己的文件夹，防止无限添加
                if(!file1.exists()){
                    //创建文件夹，用于存放个人数据
                    file1.mkdirs();
                }
                filePath = filePath + session.getAttribute("user")+File.separator;
                String fileName = session.getAttribute("user")+extName;
                //判断是否已有头像，若有，进行删除，防止找不到相应的头像
                File file2 = new File(filePath+fileName);
                if(file2.exists()){
                    file2.delete();
                }
                //若无，直接进行储存
                else {
                    FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(filePath+ fileName)));
                    map.put("userImg",Canstants.SUCCESS);
                }
            }
            else{
                map.put("userImg",Canstants.FAIL);
            }
            filePath = filePath.replace((CharSequence) session.getAttribute("user"),"");
        }catch ( Exception e){
            e.printStackTrace();
        }
        return JSON.toJSON(map);
    }

    @RequestMapping(value = "/userPhoto",method = POST)
    public Object userPhoto(HttpSession session){
        try {
            if (session.getAttribute("user") != null){
                File file = new File(filePath+session.getAttribute("user")+File.separator+session.getAttribute("user")+".jpg");
                String path = filePath+session.getAttribute("user")+File.separator+session.getAttribute("user")+".jpg";
                if(!file.exists()){
                    map.clear();
                    map.put("userPhoto",Canstants.BACK_NULL);//4,该用户目前无头像
                }
                else{
                    map.clear();
                    map.put("userPhoto",path);
                }
            } else {
                map.clear();
                map.put("userPhoto", Canstants.FAIL);
                return JSON.toJSON(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSON(map);
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

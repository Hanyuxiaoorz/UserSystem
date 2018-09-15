package com.mis.user.regist.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.commom.canstants.Canstants;
import com.mis.user.regist.service.impl.UserRegistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
* 控制层
* 用户唯一性验证以及注册
* @author:Genius
* Data:2018.4.15
*
* */
@RestController
public class UserRegistVerfy {

    @Autowired
    UserRegistServiceImpl userRegistServiceIml;

    /**
     * @param id
     *
     * 用户id唯一性验证
     *  */
    @GetMapping(value = "/regist/userIdVerify{id}")
    private Object userIdVerify(String id){
        Map map = new HashMap<String,Object>(16);
        try {
            map.clear();
            map.put("userIdVerify",this.userRegistServiceIml.userIdVerify(id));
            //转换成JSON形式返回给前端
            return  JSON.toJSON(map);
        }catch (Exception e){
            map.clear();
            map.put("userIdVerify",Canstants.FAIL);
            return JSON.toJSON(map);
        }
    }


    /**
     * @param eMail
     *
     * 用户id唯一性验证
     *  */
    @GetMapping(value = "/regist/useremailverify{eMail}")
    private Object userEmailVerify(String eMail){
        Map map = new HashMap<String,Object>(16);
        try {
            map.clear();
            map.put("userEmailVerify",this.userRegistServiceIml.userEmailVerify(eMail));
            //转换成JSON形式返回给前端
            return  JSON.toJSON(map);
        }catch (Exception e){
            map.clear();
            map.put("userEmailVerify",Canstants.FAIL);
            return JSON.toJSON(map);
        }
    }
}

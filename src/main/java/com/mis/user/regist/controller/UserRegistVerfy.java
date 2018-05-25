package com.mis.user.regist.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.regist.service.impl.UserRegistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 控制层
* 用户唯一性信息是否已经被注册
* @author:Genius
* Data:2018.4.15
*
* */
@RestController
public class UserRegistVerfy {

    Map map = new HashMap<String,Object>();
    //用户名是否已经被注册的验证
    @Autowired
    UserRegistServiceImpl userRegistServiceIml;
    @GetMapping(value = "/regist/userNameVerify{userName}")
    private Object userNameVerify(String userName){
        Map map = new HashMap<String,Object>(1);
        map.put("userNameVerify",this.userRegistServiceIml.userNameVerify(userName));
        //以JSON形式返回给前端
        return JSON.toJSON(map);
    }

    //用户Id是否已经被注册的验证
    @GetMapping(value = "/regist/userIdVerify{id}")
    private Object userIdVerify(String id){
        map.clear();
        map.put("userIdVerify",this.userRegistServiceIml.userIdVerify(id));
        //转换成JSON形式返回给前端
        return  JSON.toJSON(map);
    }

    //验证用户邮箱是否已经被注册的方法
    @GetMapping(value = "/regist/userEmailVerify{eMail}")
    private Object userEmailVerify(String eMail){
        map.clear();
        map.put("userEmailVerify",this.userRegistServiceIml.userEmailVerify(eMail));
        //转换成JSON形式返回给前端
        return  JSON.toJSON(map);
    }

}

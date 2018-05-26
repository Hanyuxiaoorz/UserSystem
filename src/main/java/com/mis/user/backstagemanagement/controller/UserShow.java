package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.iml.UserShowServiceIml;
import com.mis.user.canstants.Canstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
*用户信息的查询
* @author:Dengsiyuan
* @date:2018年4月15日
 */
//@RestController这条注解集成了@Controller和@RespondBody两条注解,但不会跳转页面，而是返回值
@RestController
public class UserShow {

    @Autowired
    UserShowServiceIml userShowServiceIml;
    Map map = new HashMap<String,String>();
    /*
    * select all users` infomation
    *
    */
    @PostMapping(value="/backstageManagement/userInfo")
    private Object showUser(){
        map.clear();
        map.put("userInfo",this.userShowServiceIml.selectUserList());
        //以JSON形式返回给前端
        return JSON.toJSON(map);
    }

    /*
    * select a user
    *
    * */
    @PostMapping(value = "/backstageManagement/selectUserInfo{searchValue}")
    private Object selectUser(String searchValue){
        if(userShowServiceIml.selectUserByInput(searchValue) !=null){
            return JSON.toJSON(userShowServiceIml.selectUserByInput(searchValue));
        }
        else{
            map.put("selectUserInfo",Canstants.FAIL);
            return JSON.toJSON(map);
        }
    }
}

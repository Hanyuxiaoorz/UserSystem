package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.iml.UserShowServiceIml;
import com.mis.user.canstants.Canstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *用户信息的查询
 * @author:Dengsiyuan
 * @date:2018年4月15日
 **/
//@RestController这条注解集成了@Controller和@RespondBody两条注解,但不会跳转页面，而是返回值
@RestController
@RequestMapping(value = "/backstageManagement")
public class UserShow {

    @Autowired
    UserShowServiceIml userShowServiceIml;
    Map map = new HashMap<String,String>();
    /*
    * select all users` infomation
    *
    */
    @RequestMapping(value="/userInfo",method = POST)
    public Object showUser(HttpServletRequest request){
        map.clear();
        if (request.getSession().getAttribute("user") != null) {
            map.put("userInfo", this.userShowServiceIml.selectUserList());
            //以JSON形式返回给前端
        }else {
            map.put("userInfo", Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /*
    * select a user
    *
    * */
    @RequestMapping(value = "/selectUserInfo{searchValue}",method = POST)
    public Object selectUser(HttpServletRequest request,String searchValue){
        map.clear();
        if (request.getSession().getAttribute("user") != null) {
            if(userShowServiceIml.selectUserByInput(searchValue) !=null){
            return JSON.toJSON(userShowServiceIml.selectUserByInput(searchValue));
            }
            else{
                map.put("selectUserInfo",Canstants.FAIL);
            }
        }else {
            map.put("selectUserInfo",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /*
    * the amount of user and admin
    *
    * */
    @RequestMapping(value = "/mainAmount",method = GET)
    public Object userAmount(HttpServletRequest request){
        map.clear();
        if (request.getSession().getAttribute("user") != null) {
            map.put("userAmount", userShowServiceIml.userAmount());
            map.put("adminAmount", userShowServiceIml.managerAmount());
        }else {
            map.put("error",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /*
    *the amount of every direction
    *
    * */
    @RequestMapping(value = "/study_directionAmount",method = GET)
    public Object study_direction(){
        map.clear();
        map.put("androidNum",userShowServiceIml.androidNum());
        map.put("bgNum",userShowServiceIml.bgNum());
        map.put("frontNum",userShowServiceIml.frontNum());
        map.put("PyNum",userShowServiceIml.PyNum());
        map.put("algNum",userShowServiceIml.algNum());
        return JSON.toJSON(map);
    }
}

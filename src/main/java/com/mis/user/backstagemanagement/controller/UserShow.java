package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.UserShowService;
import com.mis.user.commom.canstants.Canstants;
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
@RestController
@RequestMapping(value = "/backstageManagement")
public class UserShow {

    @Autowired
    UserShowService userShowService;
    /**
    * select all users` information
    *
    */
    @RequestMapping(value="/userInfo",method = POST)
    public Object showUser(HttpServletRequest request){
        Map map = new HashMap<String,String>(16);
        map.clear();
        if (request.getSession().getAttribute("userId") != null) {
            map.put("userInfo", this.userShowService.selectUserList());
            //以JSON形式返回给前端
        }else {
            map.put("userInfo", Canstants.BACK_PERMISSION_FAIL);
        }
        return JSON.toJSON(map);
    }

    /**
    * select a user
    *
    * */
    @RequestMapping(value = "/selectUserInfo{searchValue}",method = POST)
    public Object selectUser(HttpServletRequest request,String searchValue){
        Map map = new HashMap<String,String>(16);
        try {
            map.clear();
            if (request.getSession().getAttribute("userId") != null) {
                if(userShowService.selectUserByInput(searchValue) !=null){
                    return JSON.toJSON(userShowService.selectUserByInput(searchValue));
                }
                else{
                    //4,未查询到该用户
                    map.put("selectUserInfo",Canstants.BACK_NULL);
                }
            }else {
                //2,未登陆
                map.put("selectUserInfo",Canstants.BACK_PERMISSION_FAIL);
            }

        }catch (Exception e){
            //0,此功能出现异常，请联系管理员
            map.put("selectUserInfo",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /**
     * the amount of user and admin
     *
     * */
    @RequestMapping(value = "/mainAmount",method = GET)
    public Object userAmount(HttpServletRequest request){
        Map map = new HashMap<String,String>(16);
        try {
            if (request.getSession().getAttribute("userId") != null) {
                map.put("userAmount", userShowService.userAmount());
                map.put("adminAmount", userShowService.managerAmount());
            }else {
                //2,未登录
                map.put("error",Canstants.BACK_PERMISSION_FAIL);
            }
        }catch (Exception e){
            //0,出现异常，请联系管理员
            map.put("error",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /**
     *the amount of every direction
     *
     * */
    @RequestMapping(value = "/study_directionAmount",method = GET)
    public Object study_direction(){
        Map map = new HashMap<String,String>(16);
        map.put("androidNum",userShowService.androidNum());
        map.put("bgNum",userShowService.bgNum());
        map.put("frontNum",userShowService.frontNum());
        map.put("PyNum",userShowService.PyNum());
        map.put("algNum",userShowService.algNum());
        return JSON.toJSON(map);
    }
}

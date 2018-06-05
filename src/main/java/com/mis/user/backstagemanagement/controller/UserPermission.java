package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.canstants.Canstants;
import com.mis.user.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/backstageManagement")
public class UserPermission {

    @Autowired
    UserPermissionService userPermissionService;
    CookieUtil cookieUtil;
    Map map = new HashMap<String,String>();
    /*
    * update user`s password
    *
    * */
    @RequestMapping(value = "/updatePassword{byUserName}",method = POST)
    public Object resetPassword( String byUserName,HttpServletRequest request,HttpSession session){
        System.out.println("11111");
        if(session.getAttribute("user") != null){
            System.out.println("00000");
            String hostUserName = cookieUtil.getCookieByName(request,"user").getValue();
            System.out.println(hostUserName);
            map.clear();
            map.put("updatePassword",userPermissionService.changePasswordByUserName(hostUserName,byUserName));
        }else {
            map.clear();
            map.put("updatePassword",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /*
    * delete a user
    *
    * */
    @RequestMapping(value = "/deleteUser{byUserName}",method = POST)
    public Object deleteUser(String byUserName, HttpSession session){
        String hostUserName = (String) session.getAttribute("user");
        map.clear();
        map.put("deleteUser",userPermissionService.deleteUserByUserName(hostUserName,byUserName));
        return JSON.toJSON(map);
    }

    /*
    * update user`s state
    *
    * */
    @RequestMapping(value = "/userState{byUserName,state}",method = POST)
    public Object updateUserStage(String byUserName, int state,HttpSession session){
        String hostUserName = (String) session.getAttribute("user");
        System.out.println(hostUserName);
        map.clear();
        map.put("userState",userPermissionService.updateUserStageByuserName(hostUserName,byUserName,state));
        return JSON.toJSON(map);
    }
}

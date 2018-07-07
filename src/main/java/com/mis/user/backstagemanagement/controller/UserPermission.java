package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.canstants.Canstants;
import com.mis.user.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Object resetPassword(String byUserName,HttpServletRequest request,HttpSession session){
        try {
            if(session.getAttribute("user") != null){
                String hostUserName = (String) cookieUtil.ReadCookievalue(request,session);
                map.clear();
                map.put("updatePassword",userPermissionService.changePasswordByUserName(hostUserName,byUserName));
            }else {
                map.clear();
                map.put("updatePassword",Canstants.FAIL);
            }
        }catch (Exception e){
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
        try {
            String hostUserName = (String) session.getAttribute("user");
            map.clear();
            map.put("deleteUser",userPermissionService.deleteUserByUserName(hostUserName,byUserName));
        }catch (Exception e){
            map.clear();
            map.put("deleteUser",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /*
    * update user`s state
    *
    * */
    @RequestMapping(value = "/userState{byUserName,state}",method = POST)
    public Object updateUserStage(String byUserName, int state,HttpServletRequest request){
        try{
            String hostUserName = (String) request.getSession().getAttribute("user");
            map.clear();
            map.put("userState",userPermissionService.updateUserStageByuserName(hostUserName,byUserName,state));
        }catch (Exception e){
            map.clear();
            map.put("userState",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }
}

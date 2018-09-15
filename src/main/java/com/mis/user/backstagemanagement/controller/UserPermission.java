package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.commom.canstants.Canstants;
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
    /**
    * update user`s password
    *
    * */
    @RequestMapping(value = "/updatePassword{byUserId}",method = POST)
    public Object resetPassword(String byUserId,HttpSession session){
        Map map = new HashMap<String,String>(16);
        try {
            if(session.getAttribute("userId") != null){
                String hostUserId = (String) session.getAttribute("userId");
                map.clear();
                map.put("updatePassword",userPermissionService.changePasswordByUserId(hostUserId,byUserId));
            }else {
                map.clear();
                //2，未登录
                map.put("updatePassword",Canstants.BACK_PERMISSION_FAIL);
            }
        }catch (Exception e){
            map.clear();
            map.put("updatePassword",Canstants.FAIL);
            e.printStackTrace();
        }
        return JSON.toJSON(map);
    }

    /**
    * delete a user
    *
    * */
    @RequestMapping(value = "/deleteUser{byUserId}",method = POST)
    public Object deleteUser(String byUserId, HttpSession session){
        Map map = new HashMap<String,String>(16);
        try {
            String hostUserId = (String) session.getAttribute("userId");
            map.clear();
            map.put("deleteUser",userPermissionService.deleteUserByUserId(hostUserId,byUserId));
        }catch (Exception e){
            map.clear();
            map.put("deleteUser",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }

    /**
    * update user`s state
    *
    * */
    @RequestMapping(value = "/userState{byUserId,state}",method = POST)
    public Object updateUserStage(String byUserId, int state,HttpServletRequest request){
        Map map = new HashMap<String,String>(16);
        try{
            String hostUserId = (String) request.getSession().getAttribute("userId");
            map.clear();
            map.put("userState",userPermissionService.updateUserStageByUserId(hostUserId,byUserId,state));
        }catch (Exception e){
            e.printStackTrace();
            map.clear();
            map.put("userState",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }
}

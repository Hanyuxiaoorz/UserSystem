package com.mis.user.backstagemanagement.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.backstagemanagement.service.iml.UserPermissionServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserPermission {

    @Autowired
    UserPermissionServiceIml  userPermissionServiceIml;
    Map map = new HashMap<String,String>();
    /*
    * update user`s password
    *
    * */
    @PostMapping(value = "/backstageManagement/updatePassword{hostUserName,byUserName}")
    private Object resetPassword(String hostUserName,String byUserName){
        map.clear();
        map.put("updatePassword",this.userPermissionServiceIml.changePasswordByUserName(hostUserName,byUserName));
        return JSON.toJSON(map);
    }

    /*
    * delete a user
    *
    * */
    @PostMapping(value = "/backstageManagement/deleteUser{hostUserName,byUserName}")
    private Object deleteUser(String hostUserName,String byUserName){
        map.clear();
        map.put("deleteUser",this.userPermissionServiceIml.deleteUserByUserName(hostUserName,byUserName));
        return JSON.toJSON(map);
    }

    /*
    * update user`s state
    *
    * */
    @PostMapping(value = "/backstageManagement/userState{hostUserName,byUserName,state}")
    private Object updateUserStage(String hostUserName,String byUserName,int state){
        map.clear();
        map.put("userState",this.userPermissionServiceIml.updateUserStageByuserName(hostUserName,byUserName,state));
        return JSON.toJSON(map);
    }
}

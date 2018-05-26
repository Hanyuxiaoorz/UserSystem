package com.mis.user.backstagemanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface UserPermissionService {

    //通过用户名更改用户密码
    String changePasswordByUserName(String hostUserName, String byUserName);

    //通过用户名更改用户的等级
    String updateUserStageByuserName(String hostUserName,String byUserName,Integer state);

    //通过用户名删除用户
    String deleteUserByUserName(String hostUserName,String byUserName);
}

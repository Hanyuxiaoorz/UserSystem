package com.mis.user.backstagemanagement.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface UserPermissionService {

    //通过用户名查询state
    int selectState(String hostUserName);

    //通过用户名更改用户密码
    int changePasswordByUserName(String hostUserName, String byUserName);

    //通过用户名更改用户的等级
    int updateUserStageByuserName(String hostUserName, String byUserName,int state);

    //通过用户名删除用户
    int deleteUserByUserName(String hostUserName, String byUserName);
}

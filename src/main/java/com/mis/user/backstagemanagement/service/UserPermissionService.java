package com.mis.user.backstagemanagement.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface UserPermissionService {

    //通过学号查询state
    int selectState(String hostUserId);

    //通过学号更改用户密码
    int changePasswordByUserId(String hostUserId, String byUserId);

    //通过学号更改用户的等级
    int updateUserStageByUserId(String hostUserId, String byUserId,int state);

    //通过学号删除用户
    int deleteUserByUserId(String hostUserId, String byUserId);
}

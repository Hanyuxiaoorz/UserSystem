package com.mis.user.login.dao;

import com.mis.user.login.model.UserLoginInfo;
import org.springframework.stereotype.Repository;

@Repository(value = "userLoginMapper")
public interface UserLoginMapper {

    UserLoginInfo loginUserByEmail(UserLoginInfo userLoginInfo);
    UserLoginInfo loginUserById(UserLoginInfo userLoginInfo);

    UserLoginInfo judgeId(String id);
    UserLoginInfo judgeEmail(String e_mail);

    String userNameById(String id);
    String userNameByEmail(String e_mail);

    String userIdByEmail(String e_mail);

}
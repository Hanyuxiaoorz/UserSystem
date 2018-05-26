package com.mis.user.login.dao;

import com.mis.user.login.model.UserLoginInfo;
import org.springframework.stereotype.Repository;

@Repository(value = "userLoginMapper")
public interface UserLoginMapper {

    UserLoginInfo loginUserByUserName(UserLoginInfo userLoginInfo);
    UserLoginInfo loginUserByEmail(UserLoginInfo userLoginInfo);
    UserLoginInfo loginUserById(UserLoginInfo userLoginInfo);

    UserLoginInfo judgeUserName(String userName);
    UserLoginInfo judgeId(String id);
    UserLoginInfo judgeEmail(String e_mail);

    Integer stateVerifyByUserName(String userName);
    Integer stateVerifyById(String id);
    Integer stateVerifyByEmail(String e_mail);
}

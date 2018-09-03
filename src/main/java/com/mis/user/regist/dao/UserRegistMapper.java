package com.mis.user.regist.dao;

import com.mis.user.regist.model.UserRegistInfo;
import org.springframework.stereotype.Repository;

@Repository("userRegsitMapper")
public interface UserRegistMapper {

    UserRegistInfo registUserByUserId(String id);
    UserRegistInfo registUserByUserEmail(String e_mail);
    int insertUser(UserRegistInfo userRegistInfo);
}

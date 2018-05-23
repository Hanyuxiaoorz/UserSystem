package com.mis.user.commom.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userToken")
public interface UserTokenMapper {

    String selectUserToken(String userToken);

    String insertUserToken(String userToken);
}

package com.mis.user.personalMess.dao;

import com.mis.user.personalMess.model.UserPersonalMess;
import org.springframework.stereotype.Repository;

@Repository(value = "userPersonMessMapper")
public interface UserPersonalMessMapper {

    UserPersonalMess searchUserPersonalMess(String id);

    boolean updateUserPersonalMess(UserPersonalMess userPersonalMess);

    boolean updateUserEmail(String Mail);

}

package com.mis.user.personalMess.dao;

import com.mis.user.personalMess.model.UserPersonalMess;
import org.springframework.stereotype.Repository;

@Repository(value = "userPersonMessMapper")
public interface UserPersonalMessMapper {

    UserPersonalMess searchUserPersonMess(String id);

    boolean updateUserPersonMess(UserPersonalMess userPersonalMess);

}

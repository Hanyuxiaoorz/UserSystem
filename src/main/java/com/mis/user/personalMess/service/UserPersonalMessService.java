package com.mis.user.personalMess.service;

import com.mis.user.personalMess.model.UserPersonalMess;
import org.springframework.stereotype.Service;

@Service
public interface UserPersonalMessService {

    Object searchUserPersonMess(String id);

    boolean updateUserPersonMess(UserPersonalMess userPersonalMess);

    boolean updateUserEmail(String mailVCode,String mail);

}

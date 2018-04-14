package com.mis.user.dao;

import com.mis.user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    boolean insertUser(User user);
}
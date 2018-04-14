package com.mis.user.service.impl;

import com.mis.user.dao.UserMapper;
import com.mis.user.model.User;
import com.mis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CreatedBy: dengsiyuan
 * On: 2018/4/13.
 * you are the best! do more and more.
 * describle:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public boolean insertUser(User user) {
        boolean isInsert = userMapper.insertUser(user);
        System.out.println(isInsert ? "insert is ok" : false);
        return isInsert;
    }
}
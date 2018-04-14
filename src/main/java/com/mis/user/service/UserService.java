package com.mis.user.service;

import com.mis.user.model.User;

public interface UserService {
    /*public void delUser(String userId) {
        userMapper.delUser(userId);
        System.out.println("已经删除了用户: " + userId);
    }
    public User getUser(String userId) {
        System.out.println(userMapper.getUser(userId).toString());
        return userMapper.getUser(userId);
    }*/

    public boolean insertUser(User user);
}

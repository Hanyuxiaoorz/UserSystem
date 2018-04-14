package com.mis.test;

import com.mis.user.dao.UserMapper;
import com.mis.user.model.User;
import com.mis.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * CreatedBy: dengsiyuan
 * On: 2018/4/13.
 * you are the best! do more and more.
 * describle:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class TestDemo {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    private User user;
    @Before
    public void setUp() throws Exception {
        System.out.println(userMapper + "-----------------------------" + userService);
        user = new User();
        user.setUserName("dsy");
        user.setPassWord("123456");
        user.setAge(19);
        user.setBirth(19991027);
        user.setClass_number("03011702");
        user.setE_mail("2208864697@qq.com");
        user.setId(2017211005);
        user.setMajor("信息管理与信息系统");
        user.setPhone_number("13759758663");
        user.setSex("男");
        user.setHabit("打篮球");
        user.setStudy_direction("后台");
        user.setStatus(0);
    }

    @Test
    public void ins() {
        System.out.println(user.toString());
        boolean isOk = userService.insertUser(user);
        Assert.assertTrue(isOk);
    }
}
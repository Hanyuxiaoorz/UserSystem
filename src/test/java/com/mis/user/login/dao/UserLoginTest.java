package com.mis.user.login.dao;

import com.mis.user.login.model.UserLoginInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
public class UserLoginTest {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Test
    public void loginUserByUserName(){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserName("dsy");
        userLoginInfo.setPassword("123456");
        UserLoginInfo result = userLoginMapper.loginUserByUserName(userLoginInfo);
        Assert.assertTrue("2017211005".equals(result.getId()));
    }

    @Test
    public void loginUserByEmail(){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setE_mail("2208864697@qq.com");
        userLoginInfo.setPassword("123456");
        UserLoginInfo result = userLoginMapper.loginUserByEmail(userLoginInfo);
        Assert.assertTrue("2017211005".equals(result.getId()));
    }

    @Test
    public void loginUserById(){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setId("2017211005");
        userLoginInfo.setPassword("123456");
        UserLoginInfo result = userLoginMapper.loginUserById(userLoginInfo);
        Assert.assertTrue("dsy".equals(result.getUserName()));
    }

    @Test
    public void judgeUserName(){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserName("dsy");
        userLoginInfo.setPassword("123456");
        UserLoginInfo result = userLoginMapper.loginUserByUserName(userLoginInfo);
        Assert.assertTrue("2208864697@qq.com".equals(result.getE_mail()));
    }

    @Test
    public void judgeId(){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setId("2017211004");
        userLoginInfo.setPassword("123456");
        UserLoginInfo result = userLoginMapper.loginUserById(userLoginInfo);
        Assert.assertTrue("lbw".equals(result.getUserName()));
    }

    @Test
    public void judgeEmail(){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setE_mail("1123570657@qq.com");
        userLoginInfo.setPassword("123456");
        UserLoginInfo result = userLoginMapper.loginUserByEmail(userLoginInfo);
        Assert.assertTrue("2017211004".equals(result.getId()));
    }
}

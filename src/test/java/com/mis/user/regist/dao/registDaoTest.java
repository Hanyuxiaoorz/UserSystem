package com.mis.user.regist.dao;

import com.mis.user.regist.model.UserRegistInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-applicationContext.xml")
public class registDaoTest {

    @Autowired
    UserRegistMapper userRegistMapper;

    @Test
    public void registUserByUserName(){
        UserRegistInfo result = userRegistMapper.registUserByUserName("dsy");
        Assert.assertTrue("dsy".equals(result.getUserName()));
    }

    @Test
    public void registUserByUserId(){
        UserRegistInfo result = userRegistMapper.registUserByUserId("2017211005");
        Assert.assertTrue("2017211005".equals(result.getId()));
    }

    @Test
    public void registUserByUserEmail(){
        UserRegistInfo result = userRegistMapper.registUserByUserEmail("2208864697@qq.com");
        Assert.assertTrue("2208864697@qq.com".equals(result.getE_mail()));
    }

    @Test
    public void insertUser(){
        UserRegistInfo userRegistInfo = new UserRegistInfo();
        userRegistInfo.setUserName("zq");
        userRegistInfo.setPassword("123456");
        userRegistInfo.setId("2016211005");
        userRegistInfo.setE_mail("159753654@qq.com");
        userRegistInfo.setStudy_direction("前端");
        int result = userRegistMapper.insertUser(userRegistInfo);
        Assert.assertTrue(1 == result);
    }
}

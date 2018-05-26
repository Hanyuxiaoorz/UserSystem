package com.mis.user.backstagemanagement.dao;

import com.mis.user.backstagemanagement.model.UserShowInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
public class UserShowDaoTest {

    @Autowired
    UserShowMapper userShowMapper;

    @Test
    public void selectUserListTest(){
        List<UserShowInfo> result = userShowMapper.selectUserList();

        assertTrue(!result.isEmpty());
    }

    @Test
    public void selectByUserName(){
        UserShowInfo userShowInfo;
        userShowInfo = userShowMapper.selectByUserName("dsy");
        String name = userShowInfo.getUserName();
        Assert.assertTrue(name.equals("dsy"));
        Assert.assertFalse(name.equals("lbw"));
    }

    @Test
    public void selectByUserId(){
        UserShowInfo userShowInfo;
        userShowInfo = userShowMapper.selectByUserId("2017211005");
        String id = userShowInfo.getId();
        Assert.assertTrue(id.equals("2017211005"));
        Assert.assertFalse(id.equals("2017211000"));
    }

    @Test
    public void selectByUserEmail(){
        UserShowInfo userShowInfo;
        userShowInfo = userShowMapper.selectByUserEmail("2208864697@qq.com");
        String e_mail = userShowInfo.getE_mail();
        Assert.assertTrue(e_mail.equals("2208864697@qq.com"));
        Assert.assertFalse(e_mail.equals("4646464646@qq.com"));
    }

    @Test
    public void deleteUserByUserName(){
        int rows = userShowMapper.deleteUserByUserName("lbw");
        Assert.assertTrue(1 == rows);
    }

    @Test
    public void changePasswordByUserName(){
        int result = userShowMapper.changePasswordByUserName("hyx");
        Assert.assertTrue(1 == result);
    }

    @Test
    public void updateStateByUserName(){
        int result = userShowMapper.updateStateByUserName("hyx",1);
        int result1 = userShowMapper.updateStateByUserName("lbw",0);
        Assert.assertTrue(1 == result);
        Assert.assertTrue(1 == result1);
    }
}

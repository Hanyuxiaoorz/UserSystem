package com.mis.user.regist.dao;

import com.mis.user.regist.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @Test
    public void testSimpleMail() throws Exception {
        mailServiceImpl.sendVerifyMail("1123570657@qq.com","重庆邮电大学教务处","赶紧请邓思远吃饭！");
    }
}

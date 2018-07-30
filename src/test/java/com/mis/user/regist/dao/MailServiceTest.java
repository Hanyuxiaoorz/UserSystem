package com.mis.user.regist.dao;

import com.mis.user.Application;
import com.mis.user.regist.service.MailService;
import com.mis.user.regist.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailServiceImpl mailService;
    @Test
    public void testSimpleMail() throws Exception{
        mailService.sendVerifyMail("1123570657@qq.com","重庆邮电大学教务处","赶紧请邓思远吃饭！");
    }
}

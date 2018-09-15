package com.mis.user.regist.dao;

import com.mis.user.Application;
import com.mis.user.useremailverify.service.UserMailVerifyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class MailServiceImplTest {

    @Autowired
    private UserMailVerifyServiceImpl userMailVerifyServiceImpl;

    @Test
    public void testSimpleMail() throws Exception {
        userMailVerifyServiceImpl.sendVerifyMail("1123570657@qq.com","重庆邮电大学教务处","赶紧请邓思远吃饭！");
    }
}

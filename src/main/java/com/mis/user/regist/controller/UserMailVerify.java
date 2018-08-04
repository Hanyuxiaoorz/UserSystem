package com.mis.user.regist.controller;

import com.mis.user.regist.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
public class UserMailVerify {

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @GetMapping("/verifyMail")
    public void verifyMail(HttpSession session) throws Exception {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        mailServiceImpl.sendVerifyMail("247212689@qq.com","Mis-Lab Security",sb.toString());
    }
}

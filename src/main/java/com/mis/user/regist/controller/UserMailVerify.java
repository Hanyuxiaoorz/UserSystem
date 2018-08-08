package com.mis.user.regist.controller;

import com.mis.user.regist.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class UserMailVerify {

    @Autowired
    private MailServiceImpl mailServiceImpl;

    Map map = new HashMap<String,Object>();

    @PostMapping("/verifyMail")
    public void verifyMail(String e_mail) throws Exception {
        try {
            String base = "abcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 6; i++) {
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }
            mailServiceImpl.sendVerifyMail(e_mail,"Mis-Lab Security",sb.toString());
        }catch (Exception e){
            map.clear();
            map.put("verifyMail",e.getMessage());
        }
    }
}

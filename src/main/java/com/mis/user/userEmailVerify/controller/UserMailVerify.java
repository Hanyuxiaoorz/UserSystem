package com.mis.user.useremailverify.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.commom.canstants.Canstants;
import com.mis.user.useremailverify.service.UserMailVerifyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class UserMailVerify {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMailVerifyServiceImpl userMailVerifyServiceImpl;
    Map map = new HashMap<String,Object>();

    /**
     * @param e_mail
     * @param session
     *
     * 各种邮箱验证码的发送controller
     *
     **/

    @RequestMapping(value = "/verifyMail",method = RequestMethod.POST)
    public Object verifyMail(String e_mail, HttpSession session) throws Exception {
        try {
            String base = "abcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 5; i++) {
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }
            session.setAttribute("mailVerifyCode",sb.toString());
            if(userMailVerifyServiceImpl.sendVerifyMail(e_mail,"Mis-Lab Security",sb.toString()) != null){
                map.clear();
                map.put("verifyMail", Canstants.REGIST_VCODE_FAIL);//5,返回值不为null，即验证邮箱发送失败
            }
            else {
                map.clear();
                map.put("verifyMail", Canstants.SUCCESS);//1，返回值为null，即验证邮件发送成功
            }
        }catch (Exception e){
            logger.error(e.getClass()+"{}",e);
            map.clear();
            map.put("verifyMail",Canstants.FAIL);//0,存在异常
        }
        return JSON.toJSON(map);
    }
}

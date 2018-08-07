package com.mis.user.login.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.canstants.Canstants;
import com.mis.user.login.dao.UserLoginMapper;
import com.mis.user.login.model.UserLoginInfo;
import com.mis.user.login.service.iml.UserLoginServiceIml;
import com.mis.user.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author: Dengsiyuan
 * @Date:2018.5.15
 * this is class for login and logout
 * */
@RestController
public class UserLogin {

    @Autowired
    UserLoginServiceIml userLoginServiceIml;
    CookieUtil cookieUtil;
    UserLoginInfo userLoginInfo = new UserLoginInfo();
    Map map = new HashMap<String,String>();

    /**
     *普通成员登陆
     * @param input
     * @param password
     * @param vcode
     * @param request
     * @param response
     * */
    @PostMapping(value = "/login{input,password,vcode}")
    public Object loginVerify(String input, String password, String vcode, HttpServletRequest request, HttpServletResponse response) {
        map.clear();
//        if(vcode.equals(session.getAttribute("imageCode"))){
        if (request.getSession().getAttribute("user") != null) {
            map.put("login", Canstants.SUCCESS);
        }
//            else {
        userLoginInfo.setPassword(password);
        if (userLoginServiceIml.judgeUserName(input) != null) {
            userLoginInfo.setUserName(input);
            map.put("login", userLoginServiceIml.userNameLogin(userLoginInfo, request, response));
        } else if (userLoginServiceIml.judgeId(input) != null) {
            userLoginInfo.setId(input);
            map.put("login", userLoginServiceIml.userNameLogin(userLoginInfo, request, response));
        } else if (userLoginServiceIml.judgeEmail(input) != null) {
            userLoginInfo.setE_mail(input);
            map.put("login", userLoginServiceIml.userNameLogin(userLoginInfo, request, response));
        } else {
            map.put("login", Canstants.LOGIN_INFO_NULL);
        }
//            }
//        }else {
           /* map.put("login",Canstants.REGIST_VCODE_FAIL);
        }*/
        return JSON.toJSON(map);
    }
//    }
    @RequestMapping(value = "/clientUserName" , method = POST)
    public Object userNameSearch(HttpServletRequest request,HttpSession session){
        map.clear();
        map.put("clientUserName",session.getAttribute("user"));
        return JSON.toJSON(map);
    }

    /**
     * 退出登录
     * @Param: session
     * */
    @RequestMapping(value = "/loginOut" , method = POST)
    public Object loginOut(HttpServletRequest request){
        map.clear();
        String s = request.getHeader("user");
        request.getSession().invalidate();
        map.put("loginOut",Canstants.SUCCESS);
        return JSON.toJSON(map);
    }
}

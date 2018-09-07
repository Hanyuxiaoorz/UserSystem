package com.mis.user.login.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.commom.canstants.Canstants;
import com.mis.user.login.model.UserLoginInfo;
import com.mis.user.login.service.iml.UserLoginServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    UserLoginInfo userLoginInfo = new UserLoginInfo();
    Map map = new HashMap<String,String>();

    /**
     *普通成员登陆
     * @param input
     * @param password
     * @param vCode
     * @param request
     * @param response
     *
     * */
    @PostMapping(value = "/login{input,password,vCode}")
    public Object loginVerify(String input, String password, String vCode, HttpServletRequest request, HttpServletResponse response) {
        map.clear();
        //验证是否已经登陆过，登陆过不进入下一层if，直接放行
        if (request.getSession().getAttribute("user") != null) {
            map.put("login", Canstants.SUCCESS);
        }
        //判断登录凭证是否有效
        else {
            //验证验证码是否正确
            if(vCode.equalsIgnoreCase((String) request.getSession().getAttribute("imageCode"))){
                userLoginInfo.setPassword(password);
                //id
                if (userLoginServiceIml.judgeId(input) != null) {
                    userLoginInfo.setId(input);
                    map.put("login", userLoginServiceIml.userLogin(userLoginInfo, request, response));
                }
                //E-mail
                else if (userLoginServiceIml.judgeEmail(input) != null) {
                    userLoginInfo.setE_mail(input);
                    map.put("login", userLoginServiceIml.userLogin(userLoginInfo, request, response));
                }
                //无效的登录信息
                else {
                    map.put("login", Canstants.LOGIN_USER_NULL);//5,该用户不存在
                }
            }
            //验证码不正确
            else {
                map.put("login",Canstants.LOGIN_VCODE_FAIL);//4,验证码不正确
            }
        }
        return JSON.toJSON(map);
    }

    /**
     * @param session
     * 当前登陆用户名的获取
     * */
    @RequestMapping(value = "/clientUserName" , method = POST)
    public Object userNameSearch(HttpSession session){
        map.clear();
        map.put("clientUserName",session.getAttribute("user"));
        return JSON.toJSON(map);
    }

    /**
     * 退出登录
     * @param request
     * */
    @RequestMapping(value = "/loginOut" , method = POST)
    public Object loginOut(HttpServletRequest request){
        map.clear();
        request.getSession().invalidate();
        if(request.getSession().getAttribute("user") == null){
            map.put("loginOut", Canstants.SUCCESS);
        }
        else {
           map.put("loginOut",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }
}
package com.mis.user.login.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.canstants.Canstants;
import com.mis.user.login.dao.UserLoginMapper;
import com.mis.user.login.model.UserLoginInfo;
import com.mis.user.login.service.iml.UserLoginServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
* @author: Dengsiyuan
* this is class for login and logout
*
* */
@Controller
public class UserLogin {

    @Autowired
    UserLoginServiceIml userLoginServiceIml;
    UserLoginMapper userLoginMapper;
    UserLoginInfo userLoginInfo = new UserLoginInfo();
    Map map = new HashMap<String,String>();

    /*
    *
    * 验证是否已经登陆
    * */
    @ResponseBody
    @GetMapping(value = "/checkLogin")
    public String checkLogin(String redirectUrl , HttpSession session , Model model){
        //判断是否存在全局会话
        String token = (String) session.getAttribute("token");
        if(StringUtils.isEmpty(token)){
            //表示不存在全局会话，跳转至登陆界面
            model.addAttribute("redirectUrl",redirectUrl);
            return "login";
        }
        else{
            //存在全局会话
            //取出令牌信息，重定向到redirectURL
            model.addAttribute("token",token);
            return "redirect:"+redirectUrl;
        }
    }

    /*
    *
    * 普通成员登陆
    * */
    @PostMapping(value = "/login{input,password,vcode,httpSession}")
    public Object loginVerify(String input, String password, String vcode, HttpSession httpSession) {
        //判断当前是否存有会话session
        userLoginInfo.setPassword(password);
        if (userLoginServiceIml.judgeUserName(input) != null) {
            userLoginInfo.setUserName(input);
            map.put("login", userLoginServiceIml.userNameLogin(userLoginInfo,vcode,httpSession));
        } else if (userLoginServiceIml.judgeId(input) != null) {
            userLoginInfo.setId(input);
            map.put("login", userLoginServiceIml.idLogin(userLoginInfo, vcode, httpSession));
        } else if (userLoginServiceIml.judgeEmail(input) != null) {
            userLoginInfo.setE_mail(input);
            map.put("login", userLoginServiceIml.eMailLogin(userLoginInfo, vcode, httpSession));
        }else {
            map.put("login",Canstants.LOGIN_INFO_NULL);
        }
        return JSON.toJSON(map);
    }

    /*
    *
    * 管理员登陆
    * */
    @ResponseBody
    @PostMapping(value = "/managerLogin{input,password,vcode,httpSession}")
    public Object manageLoginVerify(String input, String password, String vcode, HttpSession httpSession){
        //判断是否存在会话session
        if(httpSession.getAttribute("user")!= null){
            map.put("VIPLogin",Canstants.SUCCESS);
            return JSON.toJSON(map);
        }
        else {
            userLoginInfo.setPassword(password);
            if (userLoginServiceIml.judgeUserName(input) != null) {
                userLoginInfo.setUserName(input);
                map.put("VIPLoginVerify", userLoginServiceIml.VIPUserNameLogin(userLoginInfo, vcode, httpSession));
            } else if (userLoginServiceIml.judgeId(input) != null) {
                userLoginInfo.setId(input);
                map.put("VIPLoginVerify", userLoginServiceIml.VIPIdLogin(userLoginInfo, vcode, httpSession));
            } else if (userLoginServiceIml.judgeEmail(input) != null) {
                userLoginInfo.setE_mail(input);
                map.put("VIPLoginVerify", userLoginServiceIml.VIPEmailLogin(userLoginInfo, vcode, httpSession));
            }else {
                map.put("VIPLoginVerify",Canstants.LOGIN_INFO_NULL);
            }
            return JSON.toJSON(map);
        }
    }

    /*
    * 退出登录
    *
    * */
    @PostMapping(value = "/loginOut")
    public Object loginOut(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return Canstants.SUCCESS;
    }
}

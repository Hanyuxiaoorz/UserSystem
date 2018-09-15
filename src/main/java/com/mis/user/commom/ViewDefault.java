package com.mis.user.commom;

import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.login.controller.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ViewDefault {

    @Autowired
    UserLogin userLogin;
    @Autowired
    UserPermissionService userPermissionService;

    @GetMapping("/back-stage_management.html")
    private String backStageManagement(HttpSession session){
        String user = (String) session.getAttribute("userId");
        if(StringUtils.isEmpty(user)){
            //表示不存在全局会话，跳转至登陆界面
            return "login";
        }
        else{
            //存在全局会话
            String hostUserName = (String) session.getAttribute("userId");
            if(userPermissionService.selectState(hostUserName) > 0){
                return "back-stage_management";
            }
            else {
                return "login";
            }
        }

    }

    @GetMapping("/viewUsers.html")
    private String viewUsers(HttpSession session){
        //判断是否存在全局会话
        String user = (String) session.getAttribute("userId");
        if(StringUtils.isEmpty(user)){
            //表示不存在全局会话，跳转至登陆界面
            return "login";
        }
        else {
            //存在全局会话
            String hostUserName = (String) session.getAttribute("userId");
            if(userPermissionService.selectState(hostUserName) > 0){
                return "viewUsers";
            }
            else {
                return "login";
            }
        }
    }

    @GetMapping("/login.html")
    private String login(HttpSession session){
        //判断是否存在全局会话
        String user = (String) session.getAttribute("userId");
        if(StringUtils.isEmpty(user)){
            //表示不存在全局会话，跳转至登陆界面
            return "login";
        }
        else {
            //存在全局会话
            return "personAge";
        }
    }

    @GetMapping("/404.html")
    private String white(){
        return "404";
    }

    @GetMapping("/register.html")
    private String register(){
        return "register";
    }

    @GetMapping("/showValue.html")
    private String showValue(HttpSession session) {
        //判断是否存在全局会话
        String user = (String) session.getAttribute("userId");
        if (StringUtils.isEmpty(user)) {
            //表示不存在全局会话，跳转至登陆界面
            return "login";
        } else {
            //存在全局会话
            String hostUserName = (String) session.getAttribute("userId");
            if(userPermissionService.selectState(hostUserName) > 0){
                return "showValue";
            }
            else {
                return "login";
            }
        }
    }

    @GetMapping("/personAge.html")
    private String personAge(HttpSession session) {
        //判断是否存在全局会话
        String user = (String) session.getAttribute("userId");
        if (StringUtils.isEmpty(user)) {
            //表示不存在全局会话，跳转至登陆界面
            return "login";
        } else {
            //存在全局会话
            return "personAge";
        }
    }
}

package com.mis.user.login.service;

import com.mis.user.login.model.UserLoginInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@Service
public interface UserLoginService {

    /*
    * 用户输入信息的判断
    *
    * */
    Object judgeId(String id);
    Object judgeEmail(String e_mail);

    /*
    * 登陆验证
    * */
    int userLogin(UserLoginInfo userLoginInfo, HttpServletRequest request, HttpServletResponse response);

}

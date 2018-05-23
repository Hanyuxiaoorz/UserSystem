package com.mis.user.login.service;

import com.mis.user.login.model.UserLoginInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface UserLoginService {

    /*
    * 用户输入信息的判断
    *
    * */

    String judgeUserName(String userName);
    String judgeId(String id);
    String judgeEmail(String e_mail);

    /*
    * 登陆验证
    * */
    String userNameLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession);

    String idLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession);

    String eMailLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession);

    //管理员登陆
    String VIPUserNameLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession);

    String VIPIdLogin(UserLoginInfo userLoginInfo , String vcode, HttpSession httpSession);

    String VIPEmailLogin(UserLoginInfo userLoginInfo , String vcode, HttpSession httpSession);
}

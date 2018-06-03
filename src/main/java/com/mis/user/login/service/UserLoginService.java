package com.mis.user.login.service;

import com.mis.user.login.model.UserLoginInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@Service
public interface UserLoginService {

    /*
    * 用户输入信息的判断
    *
    * */

    Object judgeUserName(String userName);
    Object judgeId(String id);
    Object judgeEmail(String e_mail);

    /*
    * 登陆验证
    * */
    int userNameLogin(UserLoginInfo userLoginInfo, HttpSession session, HttpServletResponse response);

    /*String idLogin(UserLoginInfo userLoginInfo,HttpSession session);

    String eMailLogin(UserLoginInfo userLoginInfo,HttpSession session);*/

/*    //管理员登陆
    int VIPUserNameLogin(UserLoginInfo userLoginInfo,HttpSession session);

    int VIPIdLogin(UserLoginInfo userLoginInfo,HttpSession session);

    int VIPEmailLogin(UserLoginInfo userLoginInfo,HttpSession session);*/
}

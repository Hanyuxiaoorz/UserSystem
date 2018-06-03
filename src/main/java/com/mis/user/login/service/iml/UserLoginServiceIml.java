package com.mis.user.login.service.iml;

import com.mis.user.canstants.Canstants;
import com.mis.user.login.dao.UserLoginMapper;
import com.mis.user.login.model.UserLoginInfo;
import com.mis.user.login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserLoginServiceIml implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;
    /*
    * 用户输入信息的判断
    * 为了防止有的用户名为其他用户的邮箱，从而致使用户登陆错误
    * */

    @Override
    public  Object judgeUserName(String userName){
        if(userLoginMapper.judgeUserName(userName) != null){
            return Canstants.SUCCESS;
        }
        else
            return null;
    }

    @Override
    public Object judgeId(String id){
        if(userLoginMapper.judgeId(id) != null){
            return Canstants.SUCCESS;
        }
        else
            return null;
    }

    @Override
    public Object judgeEmail(String e_mail){
        if(userLoginMapper.judgeEmail(e_mail) != null){
            return Canstants.SUCCESS;
        } else{
            return null;
        }
    }
    /**
      * 用户登陆的验证
      * 判断完成后，使用相关信息的相关方法进行登陆
      * @param userLoginInfo
      * @param session
      **/

    //用户名
    @Override
    public int userNameLogin(UserLoginInfo userLoginInfo, HttpSession session ,HttpServletResponse response) {
        if (userLoginMapper.loginUserByUserName(userLoginInfo) != null
                || userLoginMapper.loginUserById(userLoginInfo) != null
                || userLoginMapper.loginUserByEmail(userLoginInfo) != null) {
            session.setAttribute("user",userLoginInfo.getUserName());
            Cookie cookie = new Cookie("user",userLoginInfo.getUserName());
            response.addCookie(cookie);
            return Canstants.SUCCESS;
        } else{
            return Canstants.FAIL;
        }

    }
}

package com.mis.user.login.service.iml;

import com.mis.user.canstants.Canstants;
import com.mis.user.commom.dao.UserTokenMapper;
import com.mis.user.login.dao.UserLoginMapper;
import com.mis.user.login.model.UserLoginInfo;
import com.mis.user.login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserLoginServiceIml implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;
    UserTokenMapper userTokenMapper;
    UserLoginInfo userLoginInfo;
    /*
    * 用户输入信息的判断
    * 为了防止有的用户名为其他用户的邮箱，从而致使用户登陆错误
    * */

    @Override
    public  String judgeUserName(String userName){
        if(userLoginMapper.judgeUserName(userName) != null){
            return Canstants.SUCCESS;
        }
        else
            return null;
    }

    @Override
    public String judgeId(String id){
        if(userLoginMapper.judgeId(id) != null){
            return Canstants.SUCCESS;
        }
        else
            return null;
    }

    @Override
    public String judgeEmail(String e_mail){
        if(userLoginMapper.judgeEmail(e_mail) != null){
            return Canstants.SUCCESS;
        }
        else
            return null;
    }

    /*
    * 用户登陆的验证
    * 判断完成后，使用相关信息的相关方法进行登陆
    *
    * */

    //用户名
    @Override
    public String userNameLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession) {
        if (userLoginMapper.loginUserByUserName(userLoginInfo) != null) {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            httpSession.setAttribute("token",token);
            return Canstants.SUCCESS;
        }
        else{
            return Canstants.FAIL;
        }

    }

    //用户学号
    @Override
    public String idLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession) {
        if (userLoginMapper.loginUserById(userLoginInfo) != null) {
            httpSession.setAttribute("user",userLoginInfo);
            return Canstants.SUCCESS;
        } else {
            return Canstants.FAIL;
        }
    }

    //用户邮箱
    @Override
    public String eMailLogin(UserLoginInfo userLoginInfo, String vcode ,HttpSession httpSession) {
        if (userLoginMapper.loginUserByEmail(userLoginInfo) != null) {
            httpSession.setAttribute("user",userLoginInfo);
            return Canstants.SUCCESS;
        } else {
            return Canstants.FAIL;
        }
    }

    /*
    *
    * 管理员登陆验证
    * */
    //用户名登陆
    @Override
    public String VIPUserNameLogin(UserLoginInfo userLoginInfo, String vcode, HttpSession httpSession) {
        userLoginInfo.setState(userLoginMapper.stateVerifyByUserName(userLoginInfo.getUserName()));
            //用户是否有权登陆后台管理
        if(userLoginInfo.getState() > 0){
            //用户名密码是否匹配的判断
            if(userLoginMapper.loginUserByUserName(userLoginInfo) != null){
                return Canstants.SUCCESS;
            }
            else {
                    return Canstants.FAIL;
            }
        }
        else {
            return Canstants.LOGIN_PERMISSION_FAIL;
        }
    }

    //通过用户id登陆
    @Override
    public String VIPIdLogin(UserLoginInfo userLoginInfo , String vcode, HttpSession httpSession) {
        userLoginInfo.setState(userLoginMapper.stateVerifyById(userLoginInfo.getId()));
        //用户是否有权登陆后台管理
        if(userLoginInfo.getState() > 0){
            //用户名密码是否匹配的判断
            if(userLoginMapper.loginUserById(userLoginInfo) != null){
                String token = UUID.randomUUID().toString();
                httpSession.setAttribute("token",token);
                return Canstants.SUCCESS;
            }
            else {
                return Canstants.FAIL;
            }
        }
        else {
            return Canstants.LOGIN_PERMISSION_FAIL;
        }
    }

    //通过用户邮箱登陆
    @Override
    public String VIPEmailLogin(UserLoginInfo userLoginInfo , String vcode, HttpSession httpSession) {
        userLoginInfo.setState(userLoginMapper.stateVerifyByEmail(userLoginInfo.getE_mail()));
        //用户是否有权登陆后台管理
        if(userLoginInfo.getState() > 0){
            //用户名密码是否匹配的判断
            if(userLoginMapper.loginUserByEmail(userLoginInfo) != null){
                return Canstants.SUCCESS;
            }
            else {
                return Canstants.FAIL;
            }
        }
        else {
            return Canstants.LOGIN_PERMISSION_FAIL;
        }
    }
}

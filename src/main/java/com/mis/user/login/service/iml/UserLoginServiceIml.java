package com.mis.user.login.service.iml;

import com.mis.user.commom.canstants.Canstants;
import com.mis.user.login.dao.UserLoginMapper;
import com.mis.user.login.model.UserLoginInfo;
import com.mis.user.login.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class UserLoginServiceIml implements UserLoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserLoginMapper userLoginMapper;
    /*
     * 用户输入信息的判断
     * 为了防止有的用户名为其他用户的邮箱，从而致使用户登陆错误
     * */
    @Override
    public Object judgeId(String id){
        try {
            if(userLoginMapper.judgeId(id) != null){
                return Canstants.SUCCESS;
            }
            else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object judgeEmail(String e_mail){
        try{
            if(userLoginMapper.judgeEmail(e_mail) != null){
                return Canstants.SUCCESS;
            } else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 用户登陆的验证
     * 判断完成后，使用相关信息的相关方法进行登陆
     * @param userLoginInfo
     * @param request
     * @param response
     **/
    @Override
    public int userLogin(UserLoginInfo userLoginInfo, HttpServletRequest request, HttpServletResponse response) {
        try {
            //id登录
            if (userLoginMapper.loginUserById(userLoginInfo) != null){
                String userToken = UUID.randomUUID().toString();
                //前端页面当前登录用户的用户名所用
                request.getSession().setAttribute("user",userLoginMapper.userNameById(userLoginInfo.getId()));
                //查询各个用户信息等唯一性操作所用session
                request.getSession().setAttribute("userId",userLoginInfo.getId());
                Cookie cookie = new Cookie("user",userToken);
                response.addCookie(cookie);
                return Canstants.SUCCESS;
            }
            //邮箱登陆
            else if (userLoginMapper.loginUserById(userLoginInfo)!=null){
                String userToken = UUID.randomUUID().toString();
                //前端页面当前登录用户的用户名所用
                request.getSession().setAttribute("user",userLoginMapper.userNameByEmail(userLoginInfo.getE_mail()));
                //查询各个用户信息等唯一性操作所用session
                request.getSession().setAttribute("userId",userLoginMapper.userIdByEmail(userLoginInfo.getE_mail()));
                Cookie cookie = new Cookie("user",userToken);
                response.addCookie(cookie);
                return Canstants.SUCCESS;
            }
            else{
                return Canstants.FAIL;
            }
        }catch (Exception e){
            logger.error(e.getClass()+"{}",e);
            return Canstants.FAIL;
        }
    }
}
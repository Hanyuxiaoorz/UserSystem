package com.mis.user.personalmess.controller;

import com.mis.user.commom.canstants.Canstants;
import com.mis.user.personalmess.service.UserPersonalMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserMess {

    @Autowired
    UserPersonalMessService userPersonalMessService;
    Map map = new HashMap<String,String>();

    /**
     * @param session
     *
     * 个人页面信息展示
     * */
    @RequestMapping(value = "/userPersonalMessShow",method = POST)
    public Object userPersonalMessShow(HttpSession session){
        try{
            if(session.getAttribute("user") != null){
                map.clear();
                map.put("userPersonalMessShow",userPersonalMessService.searchUserPersonMess((String) session.getAttribute("userId")));
            }
            else {
                map.clear();
                map.put("userPersonalMessShow", Canstants.LOGIN_INFO_NULL);//2，未登录
            }
        }catch (Exception e){
            map.clear();
            map.put("userPersonalMessShow", Canstants.FAIL);//0,bug
        }
        return map;
    }
}

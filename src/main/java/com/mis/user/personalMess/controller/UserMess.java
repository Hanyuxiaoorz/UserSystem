package com.mis.user.personalMess.controller;

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

    /**
     * @param session
     *
     * 个人页面信息展示
     * */
    @RequestMapping(value = "/userPersonalMessShow",method = POST)
    public Object userPersonalMessShow(HttpSession session){
        Map map = new HashMap<String,String>(16);
        try{
            if(session.getAttribute("user") != null){
                map.clear();
                map.put("userPersonalMessShow",userPersonalMessService.searchUserPersonMess((String) session.getAttribute("userId")));
            }
            else {
                map.clear();
                //2，未登录
                map.put("userPersonalMessShow", Canstants.LOGIN_INFO_NULL);
            }
        }catch (Exception e){
            map.clear();
            //0,bug
            map.put("userPersonalMessShow", Canstants.FAIL);
        }
        return map;
    }
}

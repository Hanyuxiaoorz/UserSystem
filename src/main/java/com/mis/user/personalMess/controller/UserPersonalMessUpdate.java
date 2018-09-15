package com.mis.user.personalMess.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.commom.canstants.Canstants;
import com.mis.user.personalmess.model.UserPersonalMess;
import com.mis.user.personalmess.service.UserPersonalMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserPersonalMessUpdate {

    @Autowired
    UserPersonalMessService userPersonalMessService;

    /**
     * @param userPersonalMess
     * @param session
     *
     * UserPersonalMess信息的更改（除e-mail外，需要权限认定）
     *
     **/

    @RequestMapping(value = "/userPersonalMessUpdate",method = POST)
    public Object userPersonalMessUpdate(UserPersonalMess userPersonalMess, HttpSession session){
        Map map = new HashMap<String,String>(16);
        try{
            if(session.getAttribute("user") != null){
                if(userPersonalMessService.updateUserPersonMess(userPersonalMess)){
                    map.clear();
                    map.put("userPersonalMessUpdate", Canstants.SUCCESS);
                }else {
                    map.clear();
                    //2,更新未成功
                    map.put("userPersonalMessUpdate",Canstants.INFO_NULL);
                }
            }else {
                map.clear();
                //3,未登录，无权更改信息
                map.put("userPersonalMessUpdate",Canstants.LOGIN_PERMISSION_FAIL);
            }

        }catch (Exception e){
           map.clear();
           //0,bug
           map.put("userPersonalMessUpdate",Canstants.FAIL);
        }
        return JSON.toJSON(map);
    }
}

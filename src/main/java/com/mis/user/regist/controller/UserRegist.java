//获取前端数据，传送到Service中，在Service中实现验证，在通过该类传送到前端，实现对用户一系列的操作提示
package com.mis.user.regist.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.commom.canstants.Canstants;
import com.mis.user.regist.model.UserRegistInfo;
import com.mis.user.regist.service.impl.UserRegistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制层
 * @author:Genius
 * 2018.4.15
 *
 * */

@RestController
public class UserRegist {

    @Autowired
    UserRegistServiceImpl userRegistServiceimpl;

    /**
     * @param userRegistInfo
     * @param mailVerifyCode
     * @param session
     *
     * 用户注册信息的上传
     *
     * */
    @PostMapping(value = "/regist{userRegistInfo}")
    private Object regist(UserRegistInfo userRegistInfo,String mailVerifyCode,HttpSession session){
        Map map = new HashMap<String,Object>(16);
        try {
            //判断验证码是否正确
            if(mailVerifyCode.equalsIgnoreCase((String) session.getAttribute("mailVerifyCode"))){
                map.clear();
                map.put("regist",userRegistServiceimpl.regist(userRegistInfo));
            }else {
                map.clear();
                //5,邮箱验证码错误
                map.put("regist",Canstants.REGIST_VCODE_FAIL);
            }
            //以JSON形式返回给前端
            return JSON.toJSON(map);
        }catch (Exception e){
            map.clear();
            map.put("regist",Canstants.FAIL);
            return JSON.toJSON(map);
        }
    }

}



//获取前端数据，传送到Service中，在Service中实现验证，在通过该类传送到前端，实现对用户一系列的操作提示
package com.mis.user.regist.controller;

import com.alibaba.fastjson.JSON;
import com.mis.user.regist.model.UserRegistInfo;
import com.mis.user.regist.service.impl.UserRegistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 控制层
* @author:Genius
* 2018.4.15
*
* */

@RestController
public class UserRegist {

    @Autowired
    UserRegistServiceImpl userRegistServiceimpl;

    //使用POST方法获取前端请求
    @PostMapping(value = "/regist{userRegistInfo}")
    private Object regist(UserRegistInfo userRegistInfo){
        Map map = new HashMap<String,String>();
        map.put("regist",this.userRegistServiceimpl.regist(userRegistInfo));
        //以JSON形式返回给前端
        return JSON.toJSON(map);
    }
}



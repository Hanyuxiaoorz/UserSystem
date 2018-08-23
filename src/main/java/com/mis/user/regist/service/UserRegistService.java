//用户注册接口类，提提供注册验证的一些方法
package com.mis.user.regist.service;

import com.mis.user.regist.model.UserRegistInfo;
import org.springframework.stereotype.Service;

//注解为Service，使其可以Autowire自动注入
@Service
public interface UserRegistService {

    /*
    * 用户名是否已经被注册的验证
    *
    * */
    int userNameVerify(String userName);

    /*
    * 用户邮箱是否已经被注册的验证
    *
    * */
    int userEmailVerify(String eMail);

    /*
    * 用户学号是否已经被注册的验证
    *
    * */
    int userIdVerify(String id);

    /*
    * 用户验证成功后的注册
    *
    * */
    int regist(UserRegistInfo userRegistInfo);

}

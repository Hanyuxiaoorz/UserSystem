package com.mis.user.regist.service.impl;

import com.mis.user.commom.canstants.Canstants;
import com.mis.user.regist.dao.UserRegistMapper;
import com.mis.user.regist.model.UserRegistInfo;
import com.mis.user.regist.service.UserRegistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册时用户id和e-mail的唯一性验证
 *
 * 注册信息的上传
 *
 * */

@Service
public class UserRegistServiceImpl implements UserRegistService {

    private Logger logger = LoggerFactory.getLogger(UserRegistServiceImpl.class);

    @Autowired
    private UserRegistMapper userRegistMapper;

    //验证邮箱是否已经注册
    @Override
    public int userEmailVerify(String eMail){
        try {
            if ((userRegistMapper.registUserByUserEmail(eMail) != null)) {
                return Canstants.REGIST_EXIST;
            } else {
                return Canstants.SUCCESS;
            }
        }catch (Exception e){
            logger.error(e.getClass() + "{}", e);
            return Canstants.FAIL;
        }
    }

    //验证学生学号是否已经被注册
    @Override
    public int userIdVerify(String id) {
        try {
            if ((userRegistMapper.registUserByUserId(id) != null)) {
                return Canstants.REGIST_EXIST;
            } else {
                return Canstants.SUCCESS;
            }
        }catch (Exception e){
            return Canstants.FAIL;
        }
    }

    //注册用户
    @Override
    public int regist(UserRegistInfo userRegistInfo) {
        String regex = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        try {
            //注册合理性验证
            //验证是否输入是否完整
            if (userRegistInfo.getUserName() == null || userRegistInfo.getPassword() == null || userRegistInfo.getE_mail() == null
                    || userRegistInfo.getId() == null) {
                return Canstants.REGIST_NULL;//3,存在空值
                //验证用户唯一性信息是否已经存在
            } else if(userRegistMapper.registUserByUserId(userRegistInfo.getId()) != null
                    || userRegistMapper.registUserByUserEmail(userRegistInfo.getE_mail()) != null) {
                return Canstants.REGIST_EXIST;
            } else if (!userRegistInfo.getE_mail().matches(regex)){
                return Canstants.REGIST_STYLE_FAIL;//4,邮箱格式错误
            }else if (this.userRegistMapper.insertUser(userRegistInfo) == -1) {
                return Canstants.REGIST_EXIST;//2，注册失败
            } else {
                return Canstants.SUCCESS;//1，注册成功
            }
        }
        catch (Exception e){
            logger.error(e.getClass() + "{}", e);
            return Canstants.FAIL;//有异常
        }
    }
}

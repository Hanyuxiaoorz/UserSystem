package com.mis.user.personalMess.service.iml;

import com.mis.user.commom.canstants.Canstants;
import com.mis.user.personalMess.dao.UserPersonalMessMapper;
import com.mis.user.personalMess.model.UserPersonalMess;
import com.mis.user.personalMess.service.UserPersonalMessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersonalMessIml implements UserPersonalMessService {

    private static final Logger logger = LoggerFactory.getLogger(UserPersonalMessIml.class);

    @Autowired
    UserPersonalMessMapper userPersonalMessMapper;

    /**
     * @param id
     *
     * 个人信息页面所有信息的查询
     **/
    @Override
    public Object searchUserPersonMess(String id) {
        try {
            if(userPersonalMessMapper.searchUserPersonalMess(id) != null){
                return userPersonalMessMapper.searchUserPersonalMess(id);
            }
            else {
                return Canstants.BACK_NULL;
            }
        }catch (Exception e){
            logger.error(e.getClass()+"{}",e);
            return Canstants.FAIL;
        }
    }
    /**
     * @param userPersonalMess
     *
     * 个人信息页面信息的更改
     **/
    @Override
    public boolean updateUserPersonMess(UserPersonalMess userPersonalMess) {
        try {
            if(userPersonalMessMapper.updateUserPersonalMess(userPersonalMess)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            logger.error(e.getClass()+"{}",e);
            return false;
        }
    }


}

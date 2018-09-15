package com.mis.user.backstagemanagement.service.iml;

import com.mis.user.backstagemanagement.dao.UserShowMapper;
import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.commom.canstants.Canstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
*
* @author:Dengsiyuan
* 后台功能的服务层
* */
@Service
public class UserPermissionServiceImpl implements UserPermissionService{

    @Autowired
    UserShowMapper userShowMapper;

    /*
    *
    * 修改用户密码
    * */
    @Override
    public int changePasswordByUserId(String hostUserId,String byUserId){
        try{
            //若是有权限更改用户密码
            if(userShowMapper.selectStateByUserId(hostUserId) > userShowMapper.selectStateByUserId(byUserId)){
                //若更改成功，则返回true
                if(userShowMapper.changePasswordByUserId(byUserId)){
                  return Canstants.SUCCESS;
                } else{
                  return Canstants.BACK_PERMISSION_NULL;//3,若密码更改失败
                }
            } else{
                return Canstants.BACK_NULL; //4,若无权限更改用户密码
                }
        } catch (Exception e){
            return Canstants.FAIL;//0,此功能出现异常，请联系管理员
        }
    }

    /*
    *
    * 修改用户等级
    * */
    @Override
    public int updateUserStageByUserId(String hostUserId,String byUserId, int state) {
        try {
            //若权限允许更改
            if (userShowMapper.selectStateByUserId(hostUserId) > userShowMapper.selectStateByUserId(byUserId)) {
                //修改成功
                if (userShowMapper.updateStateByUserId(byUserId, state)) {
                    return Canstants.SUCCESS;//1
                }
                else {
                    return Canstants.BACK_NULL;//4,修改失败
                }
            } else {
                return Canstants.BACK_PERMISSION_FAIL;//2,权限不允许更改
            }
        }
        catch (Exception e){
            return Canstants.FAIL;//0,未查询到权限值，抛出空指针异常处理
        }
    }

    /*
    *
    * 删除用户
    * */
    @Override
    public int deleteUserByUserId(String hostUserId,String byUserId){
        //若有权限删除用户
        try {
            if (userShowMapper.selectStateByUserId(hostUserId) > userShowMapper.selectStateByUserId(byUserId)) {
                userShowMapper.deleteUserByUserId(byUserId);
                //删除成功
                if (userShowMapper.selectByUserId(byUserId) == null) {
                    return Canstants.SUCCESS;//1,删除成功
                }
                else {
                    return Canstants.BACK_PERMISSION_NULL;//3,删除失败
                }
            }
            else {
                return Canstants.BACK_PERMISSION_FAIL;//2,若无权限删除密码
            }
        }
        catch (Exception e){
            return Canstants.BACK_NULL;//未查询到权限值，抛出空指针异常处理
        }
    }

    /*
    * 查询用户权限值
    *
    * */
    @Override
    public int selectState(String hostUserId){
        try {
            if(userShowMapper.selectByUserId(hostUserId) != null){
                return userShowMapper.selectStateByUserId(hostUserId);
            }
            else if(userShowMapper.selectByUserEmail(hostUserId) != null){
                return userShowMapper.selectStateByE_mail(hostUserId);
            }
            else {
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
    }
}


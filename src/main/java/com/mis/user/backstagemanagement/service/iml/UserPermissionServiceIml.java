package com.mis.user.backstagemanagement.service.iml;

import com.mis.user.backstagemanagement.dao.UserShowMapper;
import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.canstants.Canstants;
import com.mis.user.regist.dao.UserRegistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
*
* @author:Dengsiyuan
* 后台功能的服务层
* */
@Service
public class UserPermissionServiceIml implements UserPermissionService{

    @Autowired
    UserShowMapper userShowMapper;
    UserRegistMapper userRegistMapper;

    /*
    *
    * 修改用户密码
    * */
    @Override
    public String changePasswordByUserName(String hostUserName,String byUserName){
        try{
            //若是有权限更改用户密码
            if(userShowMapper.selectStateByUserName(hostUserName) > userShowMapper.selectStateByUserName(byUserName)){
              userShowMapper.changePasswordByUserName(byUserName);
              String rePassword = "111111";
              if(userShowMapper.selectPassword(byUserName).equals(rePassword)){
                  return Canstants.SUCCESS;
              }
              //若密码更改失败
              else{
                  return Canstants.FAIL;
              }
            }
            //若无权限更改用户密码
            else{
                return Canstants.BACK_PERMISSION_FAIL;
          }
        }
        //未查询到权限值，抛出空指针异常处理
        catch (Exception e){
              return Canstants.BACK_PERMISSION_NULL;
        }
    }

    /*
    *
    * 修改用户等级
    * */
    @Override
    public String updateUserStageByuserName(String hostUserName, String byUserName,Integer state) {
        try {
            //若权限允许更改
            if (userShowMapper.selectStateByUserName(hostUserName) > userShowMapper.selectStateByUserName(byUserName)) {
                userShowMapper.updateStateByUserName(byUserName, state);
                //修改成功
                if (userShowMapper.selectByUserName(byUserName).getState() == state) {
                    return Canstants.SUCCESS;
                }
                //修改失败
                else {
                    return Canstants.FAIL;
                }
            }
            //权限不允许更改
            else {
                return Canstants.BACK_PERMISSION_FAIL;
            }
        }
        //未查询到权限值，抛出空指针异常处理
        catch (Exception e){
            return Canstants.BACK_PERMISSION_NULL;
        }
    }

    /*
    *
    * 删除用户
    * */
    @Override
    public String deleteUserByUserName(String hostUserName,String byUserName){
        //若有权限删除用户
        try {
            if (userShowMapper.selectStateByUserName(hostUserName) > userShowMapper.selectStateByUserName(byUserName)) {
                userShowMapper.deleteUserByUserName(byUserName);
                //删除成功
                if (userShowMapper.selectByUserName(byUserName) == null) {
                    return Canstants.SUCCESS;
                }
                //删除失败
                else {
                    return Canstants.FAIL;
                }
            }
            //若无权限删除密码
            else {
                return Canstants.BACK_PERMISSION_FAIL;
            }
        }
        //未查询到权限值，抛出空指针异常处理
        catch (Exception e){
            return Canstants.BACK_PERMISSION_NULL;
        }
    }
}


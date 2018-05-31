package com.mis.user.backstagemanagement.dao;

import com.mis.user.backstagemanagement.model.UserShowInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository(value = "userShowMapper")
public interface UserShowMapper {

    /*
    * 查询所有用户所有信息
    * @return
    * */
    List<UserShowInfo> selectUserList();

    /*
    * 通过主键查询一条用户数据
    * @param userName,id,e_mail
    * @return
    * */
    UserShowInfo selectByUserName(@Param("userName") String userName);//用户名
    UserShowInfo selectByUserId(@Param("id") String id);//用户学号
    UserShowInfo selectByUserEmail(@Param("e_mail") String e_mail);//用户邮箱

    /*
    * 查询用户记录总数
    * @return
    * */
    int userAmount();

    /*
    * 查询管理员数量
    * @return
    * */
    int managerAmount();

    /*
    *根据主键删除一条用户数据
    * @param userName
    * @return
    * */
    int deleteUserByUserName(@Param("userName") String byUserName);

    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    List<UserShowInfo> findByPage(HashMap<String, Object> map);

    /*
    * 通过用户名更改用户密码
    * @param userName
    * @return
    * */
    int changePasswordByUserName(@Param("userName") String byUserName);
    String selectPassword(@Param("userName") String byUserName);
    int selectStateByUserName(@Param("userName") String userName);
    int selectStateById(@Param("id") String id);
    int selectStateByE_mail(@Param("e_mail") String e_mail);

    /*
    * update user`s level
    * @param userName,state
    * */
    int updateStateByUserName(@Param("userName") String byUserName,@Param("state") int state);

    /*
    * select study_direction
    *
    * */
    int androidNum();
    int bgNum();
    int frontNum();
    int PyNum();
    int algNum();

}

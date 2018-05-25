package com.mis.user.backstagemanagement.service;

import com.mis.user.backstagemanagement.model.PageBean;
import com.mis.user.backstagemanagement.model.UserShowInfo;
import org.springframework.stereotype.Service;

/*
* UserShow的业务逻辑层接口
* @author:Dengsiyuan
* @Date:2018年04月25日
* */
@Service
public interface UserShowService {

    //列出所有用户数据
    Object selectUserList();

    //根据分页数据start 和size查询数据
    PageBean<UserShowInfo> findByPage(int currentPage);

    //查询用户记录总数
    int selectCount();

    //通过用户主键查询单个用户的信息
    UserShowInfo selectUserByInput(String input);//用户名

}

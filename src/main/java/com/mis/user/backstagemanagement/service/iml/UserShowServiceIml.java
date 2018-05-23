package com.mis.user.backstagemanagement.service.iml;

import com.mis.user.backstagemanagement.dao.UserShowMapper;
import com.mis.user.backstagemanagement.model.PageBean;
import com.mis.user.backstagemanagement.model.UserShowInfo;
import com.mis.user.backstagemanagement.service.UserShowService;
import com.mis.user.canstants.Canstants;
import com.mis.user.regist.dao.UserRegistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/*
* @author: Dengsiyuan
* 用户展示
* */
@Service
public class UserShowServiceIml implements UserShowService {

    @Autowired
    private UserShowMapper userShowMapper;
    private UserRegistMapper userRegistMapper;

    /*
    *
    * 查询所有
    * */
    @Override
    public Object selectUserList() {
        try{
            if (userShowMapper.selectUserList() != null) {
                return userShowMapper.selectUserList();
            }
            else{
                return Canstants.BACK_NULL;
            }
        }catch (Exception e){
            return Canstants.FAIL;
        }

    }

    @Override
    public PageBean<UserShowInfo> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<UserShowInfo> pageBean = new PageBean<UserShowInfo>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=2;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userShowMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<UserShowInfo> lists = userShowMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    //查询用户总数
    @Override
    public int selectCount() {
        return userShowMapper.selectCount();
    }

    //查询数据通过用户的输入
    @Override
    public UserShowInfo selectUserByInput(String input) {
        if(userShowMapper.selectByUserName(input) != null){
            return userShowMapper.selectByUserName(input);
        }
        else if(userShowMapper.selectByUserId(input) != null){
            return userShowMapper.selectByUserId(input);
        }
        else if(userShowMapper.selectByUserEmail(input) != null){
            return userShowMapper.selectByUserEmail(input);
        }
        else{
            return null;
        }
    }

}

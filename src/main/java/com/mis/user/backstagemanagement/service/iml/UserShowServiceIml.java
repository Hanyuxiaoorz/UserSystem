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
        int totalCount = userShowMapper.userAmount();
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
    public int userAmount() {
        return userShowMapper.userAmount();
    }

    //查询管理员的数量
    @Override
    public int managerAmount(){
        return userShowMapper.managerAmount();
    }

    //查询学习方向
    //安卓
    @Override
    public int androidNum(){
        return userShowMapper.androidNum();
    }

    //后台
    @Override
    public int bgNum(){
        return userShowMapper.bgNum();
    }

    //前端
    @Override
    public int frontNum(){
        return userShowMapper.frontNum();
    }

    //Python
    @Override
    public int PyNum(){
        return userShowMapper.PyNum();
    }

    //算法
    public int algNum(){
        return userShowMapper.algNum();
    }

    //查询数据通过用户的输入
    @Override
    public UserShowInfo selectUserByInput(String searchValue) {
        if(userShowMapper.selectByUserName(searchValue) != null){
            return userShowMapper.selectByUserName(searchValue);
        }
        else if(userShowMapper.selectByUserId(searchValue) != null){
            return userShowMapper.selectByUserId(searchValue);
        }
        else if(userShowMapper.selectByUserEmail(searchValue) != null){
            return userShowMapper.selectByUserEmail(searchValue);
        }
        else{
            return null;
        }
    }

}

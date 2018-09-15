package com.mis.user.commom.canstants;

public class Canstants {

    //此处定义一个成功和失败的返回值全定义
    // 操作失败
    public static final int FAIL = 0;
    //操作成功
    public static final int SUCCESS=1;

    //注册的其他状态值
    // 该信息已经被注册
    public static final int REGIST_EXIST = 2;
    //注册信息未填写完整
    public static final int REGIST_NULL = 3;
    //存在格式错误
    public static final int REGIST_STYLE_FAIL = 4;
    //验证码不正确
    public static final int REGIST_VCODE_FAIL = 5;

    //登陆的其他状态值
    // 登陆信息未填写完整
    public static final int LOGIN_INFO_NULL = 2;
    //无权登陆该系统
    public static final int LOGIN_PERMISSION_FAIL = 3;
    //验证码输入不正确
    public static final int LOGIN_VCODE_FAIL = 4;
    //该用户不存在
    public static final int LOGIN_USER_NULL = 5;

    //后台管理系统的其他状态值
    // 无权限操作返回值
    public static final int BACK_PERMISSION_FAIL=2;
    //未查询到权限值返回值
    public static final int BACK_PERMISSION_NULL=3;
    //未查询到任何值
    public static final int BACK_NULL=4;


    //个人信息页面其他状态值
    //必填项目存在空值
    public static final int INFO_NULL = 2;

}

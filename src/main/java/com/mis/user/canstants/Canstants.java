package com.mis.user.canstants;

public class Canstants {

    //此处定义一个成功和失败的返回值全定义
    public static final String FAIL = "0";//操作失败
    public static final String SUCCESS="1";//操作成功

    //注册的其他状态值
    public static final String REGIST_EXIST = "2";//该信息已经被注册
    public static final String REGIST_NULL = "3";//注册信息未填写完整
    public static final String REGIST_STYLE_FAIL = "4";//存在格式错误
    public static final String REGIST_VCODE_FAIL = "5";//验证码不正确

    //登陆的其他状态值
    public static final String LOGIN_INFO_NULL = "2";//登陆信息未填写完整
    public static final String LOGIN_PERMISSION_FAIL = "3";//无权登陆该系统
    public static final String LOGIN_VCODE_FAIL = "4";//验证码输入不正确
    //后台管理系统的其他状态值

    public static final String BACK_PERMISSION_FAIL="2";//无权限操作返回值
    public static final String BACK_PERMISSION_NULL="3";//未查询到权限值返回值
    public static final String BACK_NULL="4";//未查询到任何值

}

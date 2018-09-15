package com.mis.user.backstagemanagement.model;

/*
* 用户实体类
* @author:Dengsiyuan
* @Date:2018年04月25日
*
* */

public class UserShowInfo {

    private String userName;
    private String password;
    private String id;
    private String e_mail;
    private String sex;
    private String phone_number;
    private String major;
    private String class_number;
    private String study_direction;
    private int age;
    private String birth;
    private Integer state;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getStudy_direction() {
        return study_direction;
    }

    public void setStudy_direction(String study_direction) {
        this.study_direction = study_direction;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
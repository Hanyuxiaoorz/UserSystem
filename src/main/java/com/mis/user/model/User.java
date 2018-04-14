package com.mis.user.model;

import java.util.Date;

public class User {

    private String userName;
    private String passWord;
    private int id;
    private String e_mail;
    private String sex;
    private String phone_number;
    private String major;
    private String class_number;
    private String study_direction;
    private int age;
    private int birth;
    private String habit;
    private int status;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getHabit() {
        return habit;
    }

    public void setStudy_direction(String study_direction) {
        this.study_direction = study_direction;
    }

    public String getStudy_direction() {
        return study_direction;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", sex='" + sex + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", major='" + major + '\'' +
                ", class_number='" + class_number + '\'' +
                ", study_direction='" + study_direction + '\'' +
                ", age='" + age + '\'' +
                ", birth='" + birth + '\'' +
                ", habit='" + habit + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

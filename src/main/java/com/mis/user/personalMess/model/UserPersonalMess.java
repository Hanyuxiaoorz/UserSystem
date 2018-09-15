package com.mis.user.personalmess.model;

public class UserPersonalMess {

    private String userName;
    private String id;
    private String sex;
    private String phone_number;
    private String major;
    private String class_number;
    private String study_direction;
    private int age;
    private String birth;
    private String labelInfo;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }

    public String getPhone_number(){
        return phone_number;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setClass_number(String class_number){
        this.class_number = class_number;
    }

    public String getClass_number(){
        return class_number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirth() {
        return birth;
    }

    public void setLabelInfo(String labelInfo) {
        this.labelInfo = labelInfo;
    }

    public String getLabelInfo() {
        return labelInfo;
    }

    public void setStudy_direction(String study_direction) {
        this.study_direction = study_direction;
    }

    public String getStudy_direction() {
        return study_direction;
    }
}

package com.mis.user.regist.model;

public class UserRegistInfo {

    private String userName;
    private String password;
    private String id;
    private String e_mail;
    private String study_direction;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getE_mail() {
        return e_mail;
    }
    public void setStudy_direction(String study_direction) {
        this.study_direction = study_direction;
    }

    public String getStudy_direction() {
        return study_direction;
    }

}

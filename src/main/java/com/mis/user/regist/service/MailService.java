package com.mis.user.regist.service;

public interface MailService {

    public void sendVerifyMail(String to, String subject, String content);
}

# 邮箱验证码发送接口

### 1.发送邮箱验证码统一接口

##### 1.url

    POST /verifyMail
    
##### 2.请求参数

参数|类型
--|--
e_mail|用户邮箱

##### 3.响应

key：verifyMail

参数|含义
--|--|
0|该功能存在异常，请联系管理员
1|邮件发送成功
5|邮件发送失败，请重试
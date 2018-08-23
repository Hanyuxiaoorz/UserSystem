package com.mis.user.backstagemanagement.controller;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserShowControllerTest {

    @Test
    public void showUser(){
        UserShow mockResultSet =EasyMock.createMock(UserShow.class);
    }
}

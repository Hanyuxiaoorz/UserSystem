package com.mis.user.ticket.service;

import com.mis.user.ticket.model.LoginTicket;
import com.mis.user.ticket.dao.LoginTicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class UserService {

    @Autowired
    private LoginTicketDao loginTicketDao;

    public String addLoginTicket(String userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));

        loginTicketDao.insertLoginTicket(loginTicket);

        return loginTicket.getTicket();
    }

    public void logout(String ticket){
        loginTicketDao.updateStatus(ticket,1);
    }
}

package com.mis.user.ticket.dao;

import com.mis.user.ticket.model.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by tuzhenyu on 17-7-20.
 * @author tuzhenyu
 */
@Repository("loginTickert")
public interface LoginTicketDao {
    String TABLE_NAEM = " login_ticket ";
    String INSERT_FIELDS = " user_id, com.mis.user.ticket, expired, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAEM,"(",INSERT_FIELDS,") values (#{userId},#{com.mis.user.ticket},#{expired},#{status})"})
    void insertLoginTicket(LoginTicket loginTicket);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAEM,"where id=#{id}"})
    LoginTicket seletById(int id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAEM,"where com.mis.user.ticket=#{com.mis.user.ticket}"})
    LoginTicket seletByTicket(String ticket);

    @Update({"update",TABLE_NAEM,"set status = #{status} where com.mis.user.ticket = #{com.mis.user.ticket}"})
    void updateStatus(@Param("com/mis/userSystem/ticket") String ticket, @Param("status") int status);

    @Delete({"delete from",TABLE_NAEM,"where id=#{id}"})
    void deleteById(int id);
;
}

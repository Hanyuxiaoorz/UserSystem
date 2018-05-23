package com.mis.user.backstagemanagement.dao;

import com.mis.user.backstagemanagement.model.UserShowInfo;
import org.springframework.stereotype.Repository;

@Repository(value = "updateMapper")
public interface UpdateMapper {

    UserShowInfo save(UserShowInfo userShowInfo);
}

package com.mis.user.backstagemanagement.dao;

import com.mis.user.regist.model.UserRegistInfo;
import org.springframework.stereotype.Repository;

@Repository(value = "updateMapper")
public interface UpdateMapper {

    int insetUser(UserRegistInfo userRegistInfo);
}

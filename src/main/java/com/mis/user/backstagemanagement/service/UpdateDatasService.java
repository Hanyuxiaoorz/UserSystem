package com.mis.user.backstagemanagement.service;

import com.mis.user.backstagemanagement.model.UserShowInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UpdateDatasService {
    List<String[]> readExcel(String path);

    void save(UserShowInfo userShowInfo);
}

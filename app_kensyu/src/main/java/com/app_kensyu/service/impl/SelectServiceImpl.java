package com.app_kensyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.SelectDao;
import com.app_kensyu.entity.EmployeeListEntity;
import com.app_kensyu.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectDao selectDao;

    @Override
    public List<EmployeeListEntity> selectAll() {

        return selectDao.selectTemployeeTbl();
    }
}

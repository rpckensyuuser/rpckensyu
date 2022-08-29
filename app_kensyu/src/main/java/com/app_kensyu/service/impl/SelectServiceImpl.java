package com.app_kensyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.SelectDao;
import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectDao selectDao;

    @Override
    public List<TemployeeEntity> AllTemployee() {

        return selectDao.AllTemployeeTbl();
    }

    @Override
    public TemployeeEntity OneTemployee(long id) {
        // TODO 自動生成されたメソッド・スタブ
        return selectDao.OneTemployeeTbl(id);
    }

    @Override
    public List<TcareerEntity> OneTcareer(long id) {
        // TODO 自動生成されたメソッド・スタブ
        return selectDao.OneTcareerTbl(id);
    }
}

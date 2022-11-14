package com.app_kensyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.SelectDao;
import com.app_kensyu.entity.McodeEntity;
import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.EmployeeListForm;
import com.app_kensyu.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectDao selectDao;

    @Override
    public List<McodeEntity> mcode() {
        return selectDao.mcodeTbl();
    }

    @Override
    public List<TemployeeEntity> AllTemployee() {
        return selectDao.AllTemployeeTbl();
    }

    @Override
    public List<TemployeeEntity> SearchTemployee(EmployeeListForm employeeListForm) {

        return selectDao.SearchTemployeeTbl(employeeListForm.getName(), employeeListForm.getDivision(),
                employeeListForm.getFreeWord());
    }

    @Override
    public TemployeeEntity OneTemployee(long id) {
        return selectDao.OneTemployeeTbl(id);
    }

    @Override
    public List<TcareerEntity> OneTcareer(long id) {
        return selectDao.OneTcareerTbl(id);
    }

}

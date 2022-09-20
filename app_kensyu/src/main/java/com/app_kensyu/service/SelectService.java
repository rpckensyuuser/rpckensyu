package com.app_kensyu.service;

import java.util.List;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.EmployeeListForm;

public interface SelectService {

    public List<TemployeeEntity> AllTemployee();

    public List<TemployeeEntity> SearchTemployee(EmployeeListForm employeeListForm);

    public TemployeeEntity OneTemployee(long id);

    public List<TcareerEntity> OneTcareer(long id);
}

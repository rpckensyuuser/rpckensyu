package com.app_kensyu.service;

import java.util.List;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;

public interface SelectService {

    public List<TemployeeEntity> AllTemployee();

    public TemployeeEntity OneTemployee(long id);

    public List<TcareerEntity> OneTcareer(long id);

}

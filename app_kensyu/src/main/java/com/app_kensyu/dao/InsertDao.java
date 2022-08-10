package com.app_kensyu.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;

@Mapper
public interface InsertDao {

    public void insertTemployeeTbl(TemployeeEntity temployeeEntity);

    public void insertTcarerrTbl(TcareerEntity tcareerEntity);

}

package com.app_kensyu.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;

@Mapper
public interface UpdatetDao {

    public void updatetTemployeeTbl(TemployeeEntity temployeeEntity);

    public void updatetTcarerrTbl(TcareerEntity tcareerEntity);

}

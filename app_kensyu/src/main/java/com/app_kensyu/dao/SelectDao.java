package com.app_kensyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;

@Mapper
public interface SelectDao {

    List<TemployeeEntity> AllTemployeeTbl();

    TemployeeEntity OneTemployeeTbl(long id);

    List<TcareerEntity> OneTcareerTbl(long id);

}

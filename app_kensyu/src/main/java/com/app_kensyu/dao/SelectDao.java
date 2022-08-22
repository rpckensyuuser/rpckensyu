package com.app_kensyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app_kensyu.entity.EmployeeListEntity;

@Mapper
public interface SelectDao {

    List<EmployeeListEntity> selectTemployeeTbl();

}

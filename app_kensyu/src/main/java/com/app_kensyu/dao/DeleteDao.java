package com.app_kensyu.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteDao {

    public void deleteTemployeeTbl(long id);

    public void deleteTcarerrTbl(long id);

}

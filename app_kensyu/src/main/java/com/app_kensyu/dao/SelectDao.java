package com.app_kensyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app_kensyu.entity.McodeEntity;
import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;

@Mapper
public interface SelectDao {

    // MCODE_TBLの値を取得
    List<McodeEntity> mcodeTbl();

    // 全ての社員情報テーブルの値を取得
    List<TemployeeEntity> AllTemployeeTbl();

    // 検索条件と一致する社員情報テーブルの値を取得
    List<TemployeeEntity> SearchTemployeeTbl(String name, String division, String freeWord);

    // idが一致した社員情報テーブルの値を取得
    TemployeeEntity OneTemployeeTbl(long id);

    // idが一致した職歴情報テーブルの値を取得
    List<TcareerEntity> OneTcareerTbl(long id);

}

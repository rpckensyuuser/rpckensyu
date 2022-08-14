package com.app_kensyu.service;

import java.util.List;

import com.app_kensyu.dto.CareerDto;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;

public interface InsertService {

//    void insertTemployee(InsertFormParam insertFormParam);

//    void insertTcarerr(InsertFormParam insertFormParam);

    // 登録画面フォームデータから社員情報テーブルエンティティにデータを詰め替える
    TemployeeEntity getEmployeeFormData(InsertForm insertForm);

    /*
     * 粕谷コメント
     * 職歴情報は一回の保存で複数行保存が発生するので直接テーブルエンティティに詰め替えず
     * DTO(Data Transfer Object)という変数クラスの配列型に詰めて
     * その配列をループで呼び出しながらエンティティ詰め替え→保存という手順を取ります
     */
    // 登録画面フォームデータから職務経歴テーブルエンティティにデータを詰め替える
    List<CareerDto> getCareerFormDatas(InsertForm insertForm);
}

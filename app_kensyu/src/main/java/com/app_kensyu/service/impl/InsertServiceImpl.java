package com.app_kensyu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.InsertDao;
import com.app_kensyu.dto.CareerDto;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

    @Autowired
    private InsertDao insertDao;

    /**
     * 社員情報をFormデータからEntityに詰めなおす処理
     */
    public TemployeeEntity getEmployeeFormData(InsertForm insertForm) {
        // 返却用オブジェクト
        TemployeeEntity returnEntity = new TemployeeEntity();

        /*
         * 粕谷コメント
         * そのままgetすることができる値はもとからあった通り値を取得します
         */
        returnEntity.setName(insertForm.getName());
        returnEntity.setSex(insertForm.getSex());
        returnEntity.setBirthday(insertForm.getBirthday());
        returnEntity.setZip(insertForm.getZip());
        returnEntity.setAdress1(insertForm.getAdress1());
        returnEntity.setAdress2(insertForm.getAdress2());
        returnEntity.setNyushaym(insertForm.getNyushaym());
        returnEntity.setDivision(insertForm.getDivision());
        returnEntity.setSelf_intro(insertForm.getSelf_intro());

        /*
         * 粕谷コメント
         * hobbyの値については固定で3つのキーを取得してしまうと存在しないキーを参照してしまうので
         * 配列の要素数にあわせて取得する内容を取得する必要があります。
         * ※今回エラーとなった原因
         */
        /*
         * 粕谷コメント
         * ここはやり方が複数あると思います。
         * switch文でパターンごとに分ける方法や
         * lengthの値ごとに取得処理を完全に書き分けてしまう方法等
         * 僕はset文を何回も書くのが嫌なので以下の方法にしています
         * ※ただしここについてはそもそも設計が微妙なところもありますが…
         */
        if(insertForm.getHobby().length > 0) {
            returnEntity.setHobby1(insertForm.getHobby()[0]);
        }
        if(insertForm.getHobby().length > 1) {
            returnEntity.setHobby2(insertForm.getHobby()[1]);
        }
        if(insertForm.getHobby().length > 2) {
            returnEntity.setHobby3(insertForm.getHobby()[2]);
        }

        return returnEntity;
    }

//    TemployeeEntity temployeeEntity = new TemployeeEntity();
//
//    @Override
//    public void insertTemployee(InsertFormParam insertFormParam) {
//
//        for (InsertForm data : insertFormParam.getFormDataList()) {
//            temployeeEntity.setName(data.getName());
//            temployeeEntity.setSex(data.getSex());
//            temployeeEntity.setBirthday(data.getBirthday());
//            temployeeEntity.setZip(data.getZip());
//            temployeeEntity.setAdress1(data.getAdress1());
//            temployeeEntity.setAdress2(data.getAdress2());
//            temployeeEntity.setNyushaym(data.getNyushaym());
//            temployeeEntity.setDivision(data.getDivision());
//            temployeeEntity.setHobby1(data.getHobby()[0]);
//            temployeeEntity.setHobby2(data.getHobby()[1]);
//            temployeeEntity.setHobby3(data.getHobby()[2]);
//            temployeeEntity.setSelf_intro(data.getSelf_intro());
//        }
//
//        insertDao.insertTemployeeTbl(temployeeEntity);
//    }

    /**
     * 職歴情報をFormデータからDtoに詰めなおす処理
     */
    public List<CareerDto> getCareerFormDatas(InsertForm insertForm) {
        List<CareerDto> returnArr = new ArrayList<CareerDto>();

        /*
         * 粕谷コメント
         * 3つの要素で共通したindexを利用するため
         * foreachではなくfor文で参照しているindexを明確にしながらループします。
         */
        for(int i = 0; i < insertForm.getCareerStartDate().length; i++) {
            CareerDto singleRowData = new CareerDto(); // セットする用の一行分のオブジェクト
            //TODO idのセットを実施する
            //TODO シーケンスナンバーを実施する
            singleRowData.setStart_date(insertForm.getCareerStartDate()[i]);
            singleRowData.setEnd_date(insertForm.getCarreerEndDate()[i]);
            singleRowData.setProposition(insertForm.getCarreerProposition()[i]);
            returnArr.add(singleRowData);
        }

        return returnArr;
    }
//    @Override
//    public void insertTcarerr(InsertFormParam insertFormParam) {
//
//        TcareerEntity tcareerEntity = new TcareerEntity();
//
//        for (InsertForm data : insertFormParam.getFormDataList()) {
//
//            int n = 0;
//
//            tcareerEntity.setId(temployeeEntity.getId());
//            //tcareerEntity.setSeq();
//            tcareerEntity.setStart_date(data.getStart_date()[n]);
//            tcareerEntity.setEnd_date(data.getEnd_date()[n]);
//            tcareerEntity.setProposition(data.getProposition()[n]);
//
//            n += 1;
//
//            insertDao.insertTcarerrTbl(tcareerEntity);
//        }
//    }

}

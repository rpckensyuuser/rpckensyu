package com.app_kensyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.InsertDao;
import com.app_kensyu.dto.TcareerDTO;
import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

    @Autowired
    private InsertDao insertDao;

    @Override
    public TemployeeEntity insertTemployee(InsertForm insertForm) {

        //void関数からTemployeeEntity型の変数をリターンする処理に変更する
        //コントローラーでTemployeeEntity型の変数からIDを取得してinsertTcarerr引数として渡す。
        //insertTcarerrには引数IDを追加する

        TemployeeEntity temployeeEntity = new TemployeeEntity();

        temployeeEntity.setName(insertForm.getName());
        temployeeEntity.setSex(insertForm.getSex());
        temployeeEntity.setBirthday(insertForm.getBirthday());
        temployeeEntity.setZip(insertForm.getZip().replace("-", ""));
        temployeeEntity.setAddress1(insertForm.getAddress1());
        temployeeEntity.setAddress2(insertForm.getAddress2());
        temployeeEntity.setNyushaym(insertForm.getNyushaym());
        temployeeEntity.setDivision(insertForm.getDivision());
        for (int i = 0; i < insertForm.getHobby().length; i++) {
            if (i == 0) {
                temployeeEntity.setHobby1(insertForm.getHobby()[i]);
            } else if (i == 1) {
                temployeeEntity.setHobby2(insertForm.getHobby()[i]);
            } else if (i == 2) {
                temployeeEntity.setHobby3(insertForm.getHobby()[i]);
            }
        }
        temployeeEntity.setSelfIntro(insertForm.getSelfIntro());

        insertDao.insertTemployeeTbl(temployeeEntity);

        return temployeeEntity;
    }

    @Override
    public void insertTcarerr(InsertForm insertForm, TemployeeEntity temployeeEntity) {

        TcareerEntity tcareerEntity = new TcareerEntity();

        if (insertForm.getTcareerList().size() > 0) {
            for (TcareerDTO Tcareer : insertForm.getTcareerList()) {
                tcareerEntity.setId(temployeeEntity.getId());
                tcareerEntity.setStartDate(Tcareer.getStartDate());
                tcareerEntity.setEndDate(Tcareer.getEndDate());
                tcareerEntity.setProposition(Tcareer.getProposition());

                insertDao.insertTcarerrTbl(tcareerEntity);
            }
        }
    }
}

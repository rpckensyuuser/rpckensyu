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

        TemployeeEntity temployeeEntity = new TemployeeEntity();

        temployeeEntity.setName(insertForm.getName());
        temployeeEntity.setSex(insertForm.getSex());
        temployeeEntity.setBirthday(insertForm.getBirthday());
        temployeeEntity.setZip(insertForm.getZip().replace("-", ""));
        temployeeEntity.setAddress1(insertForm.getAddress1());
        temployeeEntity.setAddress2(insertForm.getAddress2());
        temployeeEntity.setNyushaym(insertForm.getNyushaym());
        temployeeEntity.setDivision(insertForm.getDivision());
        if (insertForm.getHobby() != null) {
            for (int i = 0; i < insertForm.getHobby().length; i++) {
                if (i == 0) {
                    temployeeEntity.setHobby1(insertForm.getHobby()[i]);
                } else if (i == 1) {
                    temployeeEntity.setHobby2(insertForm.getHobby()[i]);
                } else if (i == 2) {
                    temployeeEntity.setHobby3(insertForm.getHobby()[i]);
                }
            }
        }
        temployeeEntity.setSelfIntro(insertForm.getSelfIntro());

        insertDao.insertTemployeeTbl(temployeeEntity);

        return temployeeEntity;
    }

    @Override
    public void insertTcarerr(InsertForm insertForm, long id) {

        TcareerEntity tcareerEntity = new TcareerEntity();

        if (insertForm.getTcareerList().size() > 0) {
            for (TcareerDTO tcareer : insertForm.getTcareerList()) {
                tcareerEntity.setId(id);
                tcareerEntity.setStartDate(tcareer.getStartDate());
                tcareerEntity.setEndDate(tcareer.getEndDate());
                tcareerEntity.setProposition(tcareer.getProposition());
                //        if (insertForm.getTcareerList().length > 0) {
                //            for (TcareerDTO Tcareer : insertForm.getTcareerList()) {
                //                // int n = 0;
                //                tcareerEntity.setId(id);
                //                tcareerEntity.setStartDate(Tcareer.getTcareerDate().get(0));
                //                tcareerEntity.setEndDate(Tcareer.getTcareerDate().get(1));
                //                tcareerEntity.setProposition(Tcareer.getTcareerDate().get(2));
                //
                insertDao.insertTcarerrTbl(tcareerEntity);

            }
        }
    }
}

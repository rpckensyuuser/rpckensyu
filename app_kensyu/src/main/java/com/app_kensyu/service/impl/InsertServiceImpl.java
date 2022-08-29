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

    TemployeeEntity temployeeEntity = new TemployeeEntity();

    @Override
    public void insertTemployee(InsertForm insertForm) {

        temployeeEntity.setName(insertForm.getName());
        temployeeEntity.setSex(insertForm.getSex());
        temployeeEntity.setBirthday(insertForm.getBirthday());
        temployeeEntity.setZip(insertForm.getZip());
        temployeeEntity.setAdress1(insertForm.getAdress1());
        temployeeEntity.setAdress2(insertForm.getAdress2());
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
        temployeeEntity.setSelf_intro(insertForm.getSelf_intro());

        insertDao.insertTemployeeTbl(temployeeEntity);
    }

    @Override
    public void insertTcarerr(InsertForm insertForm) {

        TcareerEntity tcareerEntity = new TcareerEntity();

        if (insertForm.getTcareerList().size() > 0) {
            for (TcareerDTO Tcareer : insertForm.getTcareerList()) {
                tcareerEntity.setId(temployeeEntity.getId());
                tcareerEntity.setStart_date(Tcareer.getStart_date());
                tcareerEntity.setEnd_date(Tcareer.getEnd_date());
                tcareerEntity.setProposition(Tcareer.getProposition());

                insertDao.insertTcarerrTbl(tcareerEntity);
            }
        }
    }
}

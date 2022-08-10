package com.app_kensyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.InsertDao;
import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.form.InsertFormParam;
import com.app_kensyu.service.InsertService;

@Service
public class InsertServiceImpl implements InsertService {

    @Autowired
    private InsertDao insertDao;

    TemployeeEntity temployeeEntity = new TemployeeEntity();

    @Override
    public void insertTemployee(InsertFormParam insertFormParam) {

        for (InsertForm data : insertFormParam.getFormDataList()) {
            temployeeEntity.setName(data.getName());
            temployeeEntity.setSex(data.getSex());
            temployeeEntity.setBirthday(data.getBirthday());
            temployeeEntity.setZip(data.getZip());
            temployeeEntity.setAdress1(data.getAdress1());
            temployeeEntity.setAdress2(data.getAdress2());
            temployeeEntity.setNyushaym(data.getNyushaym());
            temployeeEntity.setDivision(data.getDivision());
            temployeeEntity.setHobby1(data.getHobby()[0]);
            temployeeEntity.setHobby2(data.getHobby()[1]);
            temployeeEntity.setHobby3(data.getHobby()[2]);
            temployeeEntity.setSelf_intro(data.getSelf_intro());
        }

        insertDao.insertTemployeeTbl(temployeeEntity);
    }

    @Override
    public void insertTcarerr(InsertFormParam insertFormParam) {

        TcareerEntity tcareerEntity = new TcareerEntity();

        for (InsertForm data : insertFormParam.getFormDataList()) {

            int n = 0;

            tcareerEntity.setId(temployeeEntity.getId());
            //tcareerEntity.setSeq();
            tcareerEntity.setStart_date(data.getStart_date()[n]);
            tcareerEntity.setEnd_date(data.getEnd_date()[n]);
            tcareerEntity.setProposition(data.getProposition()[n]);

            n += 1;

            insertDao.insertTcarerrTbl(tcareerEntity);
        }
    }

}

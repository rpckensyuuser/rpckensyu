package com.app_kensyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_kensyu.dao.DeleteDao;
import com.app_kensyu.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {

    @Autowired
    private DeleteDao deleteDao;

    @Override
    public void Temployee(long id) {
        deleteDao.deleteTemployeeTbl(id);

    }

    @Override
    public void Tcareer(long id) {
        deleteDao.deleteTcarerrTbl(id);
    }

}

package com.app_kensyu.service;

import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;

public interface InsertService {

    TemployeeEntity insertTemployee(InsertForm insertForm);

    void insertTcarerr(InsertForm insertForm, TemployeeEntity temployeeEntity);

}

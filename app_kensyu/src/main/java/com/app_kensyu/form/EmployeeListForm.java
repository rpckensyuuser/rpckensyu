package com.app_kensyu.form;

import lombok.Data;

@Data
public class EmployeeListForm {

    //社員名
    private String name;

    //所属部署
    private String division;

    //フリーワード
    private String freeWord;

}

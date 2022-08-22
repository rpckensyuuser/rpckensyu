package com.app_kensyu.entity;

import lombok.Data;

@Data
public class EmployeeListEntity {

    //ID
    private long id;

    //社員名
    private String name;

    //性別
    private String sex;

    //生年月日
    private String birthday;

    //入社年月
    private String nyushaym;

    //所属部署
    private String division;

    //自己紹介
    private String self_intro;

}

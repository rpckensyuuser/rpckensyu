package com.app_kensyu.entity;

import lombok.Data;

@Data
public class TemployeeEntity {

    //ID
    private long id;

    //社員名
    private String name;

    //性別
    private String sex;

    //生年月日
    private String birthday;

    //郵便番号
    private String zip;

    //住所１
    private String adress1;

    //住所２
    private String adress2;

    //入社年月
    private String nyushaym;

    //所属部署
    private String division;

    //趣味１
    private String hobby1;

    //趣味２
    private String hobby2;

    //趣味３
    private String hobby3;

    //自己紹介
    private String self_intro;

}
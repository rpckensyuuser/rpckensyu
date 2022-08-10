package com.app_kensyu.form;

import java.sql.Date;

import lombok.Data;

@Data
public class InsertForm {
    //ID
    //@NotNull
    private long id;

    //社員名
    //@NotNull
    //@Length(min = 1, max = 50)
    private String name;

    //性別
    //@NotNull
    private String sex;

    //生年月日
    //@NotNull
    //@DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    //郵便番号
    //@Length(min = 1, max = 7)
    //@Pattern(regexp = "\\d{7}")
    private String zip;

    //住所１
    //@Length(min = 1, max = 100)
    private String adress1;

    //住所２
    //@Length(min = 1, max = 100)
    private String adress2;

    //入社年月
    //@DateTimeFormat(pattern = "yyyyMM")
    private String nyushaym;

    //所属部署
    private String division;

    //趣味
    //@Size(min = 0, max = 3)
    private String[] hobby;

    //自己紹介
    //@Length(min = 0, max = 200)
    private String self_intro;

    //開始期間
    //@NotNull
    private Date[] start_date;

    //終了期間
    //Fs@NotNull
    private Date[] end_date;

    //案件名
    private String[] proposition;

}

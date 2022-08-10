package com.app_kensyu.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class TcareerEntity {

    //ID
    private long id;

    //SEQ
    private long seq;

    //開始期間
    private Date start_date;

    //終了期間
    private Date end_date;

    //案件名
    private String proposition;

}

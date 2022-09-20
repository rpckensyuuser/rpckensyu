package com.app_kensyu.entity;

import lombok.Data;

@Data
public class TcareerEntity {

    //ID
    private long id;

    //SEQ
    private long seq;

    //開始期間
    private String startDate;

    //終了期間
    private String endDate;

    //案件名
    private String proposition;

}

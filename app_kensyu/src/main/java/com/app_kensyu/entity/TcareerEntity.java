package com.app_kensyu.entity;

import lombok.Data;

@Data
public class TcareerEntity {

    //ID
    private long id;

    //SEQ
    private long seq;


    /*
     * 粕谷コメント
     * Formの時もそうでしたが、日付型の指定はMySQLに格納する形として妥当ではないので
     * String型に変更します
     */
    //開始期間
    private String start_date;

    //終了期間
    private String end_date;

    //案件名
    private String proposition;

}

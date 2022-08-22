package com.app_kensyu.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TcareerDTO {

    //開始期間
    @NotNull
    private String start_date;

    //終了期間
    @NotNull
    private String end_date;

    //案件名
    @NotNull
    private String proposition;

}

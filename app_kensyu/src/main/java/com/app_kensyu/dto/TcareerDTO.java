package com.app_kensyu.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TcareerDTO {

    //ID
    private long id;

    //SEQ
    private long seq;

    //開始期間
    @NotEmpty(message = "開始期間を選択してください")
    private String startDate;

    //終了期間
    @NotEmpty(message = "終了期間を選択してください")
    private String endDate;

    //案件名
    @NotBlank(message = "案件名を入力してください")
    private String proposition;

}

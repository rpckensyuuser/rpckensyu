package com.app_kensyu.form;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.app_kensyu.dto.TcareerDTO;

import lombok.Data;

@Data
public class InsertForm {

    //ID
    private long id;

    //社員名
    @NotNull
    @Length(min = 1, max = 50)
    private String name;

    //性別
    @NotNull
    private String sex;

    //生年月日
    @NotNull
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
    private String birthday;

    //郵便番号
    @Length(min = 1, max = 7)
    @Pattern(regexp = "\\d{7}")
    private String zip;

    //住所１
    @Length(max = 100)
    private String adress1;

    //住所２
    @Length(max = 100)
    private String adress2;

    //入社年月
    @Pattern(regexp = "\\d{6}")
    private String nyushaym;

    //所属部署
    private String division;

    //趣味
    @Size(max = 3)
    private String hobby[];

    //自己紹介
    @Length(max = 200)
    private String self_intro;

    //職歴情報リスト
    @Valid
    private ArrayList<@NotNull TcareerDTO> TcareerList;

}

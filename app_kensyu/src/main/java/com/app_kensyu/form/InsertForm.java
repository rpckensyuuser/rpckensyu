package com.app_kensyu.form;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
    @NotBlank(message = "社員名を入力してください")
    @Length(max = 50, message = "氏名を50文字以内で入力してください")
    private String name;

    //性別
    @NotNull(message = "性別を選択してください")
    private String sex;

    //生年月日
    @NotEmpty(message = "生年月日を選択してください")
    private String birthday;

    //郵便番号
    @Pattern(regexp = "[0-9]{7}|[0-9]{3}-[0-9]{4}", message = "郵便番号を[半角数字7桁]で入力してください")
    private String zip;

    //住所１
    @Length(max = 100, message = "住所１は100文字以内で入力してください")
    private String address1;

    //住所２
    @Length(max = 100, message = "住所２は100文字以内で入力してください")
    private String address2;

    //入社年月
    @Pattern(regexp = "\\d{6}", message = "入社年月を[YYYYMM]形式で入力してください")
    private String nyushaym;

    //所属部署
    private String division;

    //趣味1（出力用）
    private String hobby1;

    //趣味2（出力用）
    private String hobby2;

    //趣味3（出力用）
    private String hobby3;

    //趣味
    @Size(max = 3, message = "趣味は3つ以内で選択してください")
    private String hobby[];

    //自己紹介
    @Length(max = 200, message = "自己紹介は200文字以内で入力してください")
    private String selfIntro;

    //職歴情報リスト
    @NotEmpty
    @Valid
    private List<TcareerDTO> tcareerList;

}

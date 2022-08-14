package com.app_kensyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.dto.CareerDto;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.InsertService;

@Controller
@RequestMapping("/*")
public class InsertController {

    @Autowired
    private InsertService insertService;
    //private InsertEntity insertEntity;

    @PostMapping("insert")
    // InsertFormParam → InsertForm
    public String insert(@ModelAttribute @Validated InsertForm insertForm, Model model) {

        // エラーチェックとメッセージ返却を実施してください。


        /*
         * 粕谷コメント
         * FormからEntityの詰め替えとinsert処理を一気に一つの関数で実施してしまっていますが
         * もしかするとそれぞれの処理を分けた方がよいかもしれません
         * 理由としては
         * 　そもそも処理単位は小さめに切った方が可読性が高いということ
         * 　処理単位が大きくなりすぎると関数の専用性が高くなりすぎる
         * 　(登録、編集画面で共通して使える箇所があった場合などに切り分けしづらくなる)
         * 　Entityに詰めなおす→DBに登録する作業の間に別の処理が発生した場合に
         * 　追加した処理を関数として書き加えるだけではなく、既存の関数中に処理を足さなければいけなくなる
         * 　(テストしなければいけない場合、確認する範囲が増えてしまいます)
         * 等があります。
         */
        // 基本的な社員情報の取得
//        insertService.insertTemployee(insertForm);
        TemployeeEntity enployee = insertService.getEmployeeFormData(insertForm);

        // 職歴情報の取得
//        insertService.insertTcarerr(insertForm);
        List<CareerDto> careers = insertService.getCareerFormDatas(insertForm);

        return "Insert";

    }
}

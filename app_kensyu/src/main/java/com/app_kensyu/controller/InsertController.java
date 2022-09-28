package com.app_kensyu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.InsertService;
import com.app_kensyu.service.UpdateService;

/**
 * 社員情報登録完了画面のコントローラー
 */
@Controller
@RequestMapping("/*")
public class InsertController {

    @Autowired
    private InsertService insertService;

    @Autowired
    private UpdateService updateService;

    /**
     * 初期表示
     * ＠param insertForm フォームに入力された値, bindingResult バリデーションチェック結果, model 画面のモデル
     * @return 社員情報登録完了画面
     */
    @PostMapping("insert")
    public String insert(@Valid @ModelAttribute InsertForm insertForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("screen_name", "社員情報登録画面 (SEMPM02)");
            model.addAttribute("id", "※システムで自動採番されます");
            model.addAttribute("validationError", errorList);
            return "Register";
        }

        if (insertForm.getId() > 0) {
            //社員情報テーブル追加
            insertService.insertTemployee(insertForm);
            //職歴情報テーブル追加
            insertService.insertTcarerr(insertForm);
        } else {
            //社員情報テーブル追加
            updateService.updateTemployee(insertForm);
            //職歴情報テーブル追加
            updateService.updateTcarerr(insertForm);
        }

        return "Insert";

    }
}

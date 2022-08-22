package com.app_kensyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.form.InsertForm;

@RequestMapping("/*")
@Controller
public class RegisterController {

    /**
     * 社員情報登録画面
     * @param model 画面のモデル
     * @return 社員情報登録画面
     */
    @GetMapping("Register")
    public String Register(Model model) {
        //ページ名を設定
        model.addAttribute("screen_name", "社員情報登録画面 (SEMPM02)");
        model.addAttribute("register_id", "※システムで自動採番されます");

        model.addAttribute("insertForm", new InsertForm());

        return "Register";
    }
}

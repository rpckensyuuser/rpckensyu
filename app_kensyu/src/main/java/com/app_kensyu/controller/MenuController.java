package com.app_kensyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * メニュー画面のコントローラー
 */

@RequestMapping("/*")
@Controller
public class MenuController {

    /**
     * 初期表示
     * ＠param model 画面のモデル
     * @return メニュー画面
     */
    @GetMapping("top")
    public String top(Model model) {

        // valueに出力する文字列を設定
        model.addAttribute("value1", "（研修用）社員管理システム");
        model.addAttribute("value2", "メニュー画面（EMPM01）");

        return "menu";
    }

    /**
     * 社員情報登録画面
     * @param model 画面のモデル
     * @return 社員情報登録画面
     */
    @GetMapping("Register")
    public String Register(Model model) {
        return "Register";
    }

    /**
     * 社員情報一覧画面
     * @param model 画面のモデル
     * @return 社員情報一覧画面
     */
    @GetMapping("EmployeeList")
    public String EmployeeList(Model model) {
        return "EmployeeList";
    }

}

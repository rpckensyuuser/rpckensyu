package com.app_kensyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * メニュー画面のコントローラー
 */
@Controller
@RequestMapping("/*")
public class MenuController {

    /**
     * 初期表示
     * ＠param model 画面のモデル
     * @return メニュー画面
     */
    @GetMapping("top")
    public String top(Model model) {
        return "menu";
    }

}

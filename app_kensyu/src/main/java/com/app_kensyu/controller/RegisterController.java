package com.app_kensyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "Register";
    }

}

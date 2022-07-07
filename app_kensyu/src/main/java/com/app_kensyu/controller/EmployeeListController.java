package com.app_kensyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/*")
@Controller
public class EmployeeListController {

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

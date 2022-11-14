package com.app_kensyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.service.SelectService;

/**
 * 社員情報明細画面のコントローラ
 */
@Controller
public class EmployeeDetailController {

    @Autowired
    private SelectService selectService;

    /**
     * 社員情報明細画面
     * @param id 社員ID, model 画面のモデル
     * @return 社員情報明細画面
     */
    @GetMapping("employeeDetail")
    public String EmployeeDetail(@RequestParam long id, Model model) {

        // 社員情報を取得
        TemployeeEntity temployee = selectService.OneTemployee(id);
        model.addAttribute("temployee", temployee);

        // 職歴情報を取得
        List<TcareerEntity> tcareerList = selectService.OneTcareer(id);
        model.addAttribute("tcareerList", tcareerList);

        return "EmployeeDetail";
    }
}

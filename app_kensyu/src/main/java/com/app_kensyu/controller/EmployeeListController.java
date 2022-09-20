package com.app_kensyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.EmployeeListForm;
import com.app_kensyu.service.SelectService;

/**
 * 社員情報一覧画面のコントローラ
 */
@Controller
public class EmployeeListController {

    @Autowired
    private SelectService selectService;

    /**
     * 社員情報一覧画面
     * @param model 画面のモデル
     * @return 社員情報一覧画面
     */
    @GetMapping("EmployeeList")
    public String EmployeeList(Model model) {

        // すべての社員情報データを取得
        List<TemployeeEntity> temployeeEntityList = selectService.AllTemployee();
        model.addAttribute("employeeListForm", new EmployeeListForm());
        model.addAttribute("temployeeList", temployeeEntityList);

        return "EmployeeList";
    }

    /**
     * 社員情報一覧画面
     * @param model 画面のモデル
     * @return 社員情報一覧画面
     */
    @PostMapping("EmployeeList")
    public String SearchEmployeeList(@ModelAttribute EmployeeListForm searchCriteria, Model model) {

        // 検索した社員情報データを取得
        List<TemployeeEntity> temployeeEntityList = selectService.SearchTemployee(searchCriteria);
        model.addAttribute("employeeListForm", new EmployeeListForm());
        model.addAttribute("temployeeList", temployeeEntityList);

        return "EmployeeList";
    }
}

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
//@RequestMapping("/*")
public class EmployeeListController {

    @Autowired
    private SelectService selectService;

    /**
     * 社員情報一覧画面
     * @param model 画面のモデル
     * @return 社員情報一覧画面
     */
    @GetMapping("employeeList")
    public String employeeList(Model model) {

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
    @PostMapping("employeeList/search")
    public String searchEmployeeList(@ModelAttribute EmployeeListForm searchCriteria, Model model) {

        // フリーワードに”男”または”女”か入力された場合、それぞれ”M”、”F”に置換
        if (searchCriteria.getFreeWord() != null) {
            if (searchCriteria.getFreeWord().equals("男")) {
                searchCriteria.setFreeWord("M");
            } else if (searchCriteria.getFreeWord().equals("女")) {
                searchCriteria.setFreeWord("F");
            }
        }

        // 検索した社員情報データを取得
        List<TemployeeEntity> temployeeEntityList = selectService.SearchTemployee(searchCriteria);
        model.addAttribute("employeeListForm", new EmployeeListForm());
        model.addAttribute("temployeeList", temployeeEntityList);

        return "EmployeeList";
    }
}

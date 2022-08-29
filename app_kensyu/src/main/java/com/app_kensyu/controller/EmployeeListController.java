package com.app_kensyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.service.SelectService;

@Controller
@RequestMapping("/*")
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

        List<TemployeeEntity> EmployeeList = selectService.AllTemployee();
        model.addAttribute("employeeList", EmployeeList);

        return "EmployeeList";
    }
}

package com.app_kensyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.service.SelectService;

@Controller
@RequestMapping("/*")
public class EmployeeDetailController {

    @Autowired
    private SelectService selectService;

    /**
     * 社員情報一覧画面
     * @param id 社員ID, model 画面のモデル
     * @return 社員情報明細画面
     */
    @GetMapping("EmployeeDetail")
    public String EmployeeDetail(@RequestParam("id") long id, Model model) {

        TemployeeEntity temployee = selectService.OneTemployee(id);
        List<TcareerEntity> tcareerList = selectService.OneTcareer(id);
        model.addAttribute("temployee", temployee);
        model.addAttribute("tcareerList", tcareerList);

        return "EmployeeDetail";
    }

}

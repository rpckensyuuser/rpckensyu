package com.app_kensyu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.InsertService;

@Controller
@RequestMapping("/*")
public class InsertController {

    @Autowired
    private InsertService insertService;
    //private InsertEntity insertEntity;

    @PostMapping("insert")
    public String insert(@Valid @ModelAttribute InsertForm insertForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("screen_name", "社員情報登録画面 (SEMPM02)");
            model.addAttribute("register_id", "※システムで自動採番されます");
            model.addAttribute("validationError", errorList);
            return "Register";
        }

        //社員情報テーブル更新
        insertService.insertTemployee(insertForm);
        //職歴情報テーブル更新
        insertService.insertTcarerr(insertForm);

        return "Insert";

    }
}

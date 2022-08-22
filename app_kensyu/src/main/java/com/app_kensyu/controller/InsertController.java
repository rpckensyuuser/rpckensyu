package com.app_kensyu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
            model.addAttribute("error_msg", "入力情報に誤りがあります");
            return "Register";
        }

        //社員情報テーブル更新
        insertService.insertTemployee(insertForm);
        //職歴情報テーブル更新
        insertService.insertTcarerr(insertForm);

        return "Insert";

    }
}

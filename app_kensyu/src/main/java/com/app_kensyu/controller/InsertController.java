package com.app_kensyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.form.InsertFormParam;
import com.app_kensyu.service.InsertService;

@Controller
@RequestMapping("/*")
public class InsertController {

    @Autowired
    private InsertService insertService;
    //private InsertEntity insertEntity;

    @PostMapping("insert")
    public String insert(@ModelAttribute @Validated InsertFormParam insertFormParam, Model model) {
        insertService.insertTemployee(insertFormParam);
        insertService.insertTcarerr(insertFormParam);

        return "Insert";

    }
}

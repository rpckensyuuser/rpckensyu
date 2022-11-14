package com.app_kensyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app_kensyu.entity.TcareerEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.SelectService;

/**
 * 社員情報訂正画面のコントローラー
 */
@Controller
public class CorrectionController {
    //    @Autowired
    //    private UpdateService updateService;
    @Autowired
    private SelectService selectService;

    /**
     * 社員情報訂正画面
     * ＠param model 画面のモデル
     * @return 社員情報訂正画面
     */
    @GetMapping("correction")
    public String correction(@RequestParam long id, InsertForm insertForm, Model model) {

        // 社員情報を取得
        TemployeeEntity temployee = selectService.OneTemployee(id);
        // 職歴情報を取得
        List<TcareerEntity> tcareerList = selectService.OneTcareer(id);

        insertForm.setId(temployee.getId());
        insertForm.setName(temployee.getName());
        insertForm.setSex(temployee.getSex());
        insertForm.setBirthday(temployee.getBirthday());
        insertForm.setZip(temployee.getZip());

        ///model.addAttribute("screen_name", "社員情報訂正画面 (SEMPM02)");
        //model.addAttribute("id", temployee.getId());
        model.addAttribute("name", temployee.getName());
        model.addAttribute("sex", temployee.getSex());
        model.addAttribute("birthday", temployee.getBirthday());
        model.addAttribute("zip", temployee.getZip());
        model.addAttribute("address1", temployee.getAddress1());
        model.addAttribute("address2", temployee.getAddress2());
        model.addAttribute("nyushaym", temployee.getNyushaym());
        model.addAttribute("division", temployee.getDivision());
        model.addAttribute("hobby1", temployee.getHobby1());
        model.addAttribute("hobby2", temployee.getHobby2());
        model.addAttribute("hobby3", temployee.getHobby3());
        model.addAttribute("selfIntro", temployee.getSelfIntro());
        model.addAttribute("tcareerList", tcareerList);

        model.addAttribute("insertForm", insertForm);

        return "Register";
    }

}

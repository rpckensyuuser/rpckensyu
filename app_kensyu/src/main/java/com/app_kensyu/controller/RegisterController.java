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
 * 社員情報登録画面のコントローラー
 */
@Controller
public class RegisterController {

    @Autowired
    private SelectService selectService;

    /**
     * 社員情報登録画面
     * @param model 画面のモデル
     * @return 社員情報登録画面
     */
    @GetMapping("register1")
    public String register1(Model model) {
        //ページ名を設定
        model.addAttribute("screen_name", "社員情報登録画面 (SEMPM02)");
        model.addAttribute("id", "※システムで自動採番されます");

        model.addAttribute("insertForm", new InsertForm());

        return "Register";
    }

    /**
     * 社員情報訂正画面
     * ＠param model 画面のモデル
     * @return 社員情報訂正画面
     */
    @GetMapping("register2")
    public String register2(@RequestParam long id, Model model) {

        // 社員情報を取得
        TemployeeEntity temployee = selectService.OneTemployee(id);
        // 職歴情報を取得
        List<TcareerEntity> tcareerList = selectService.OneTcareer(id);

        model.addAttribute("screen_name", "社員情報訂正画面 (SEMPM02)");
        model.addAttribute("id", temployee.getId());
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

        model.addAttribute("insertForm", new InsertForm());

        return "Register";

    }
}

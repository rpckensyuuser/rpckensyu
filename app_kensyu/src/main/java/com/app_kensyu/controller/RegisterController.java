package com.app_kensyu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.entity.McodeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.SelectService;

/**
 * 社員情報登録画面のコントローラー
 */
@Controller
@RequestMapping("/*")
public class RegisterController {

    @Autowired
    private SelectService selectService;

    /**
     * 社員情報登録画面
     * @param model 画面のモデル
     * @return 社員情報登録画面
     */
    @GetMapping("register")
    public String register(Model model) {

        // 画面に表示する情報（性別、所属部署、趣味）をDBから取得し、リストに代入。
        List<McodeEntity> mcodeList = selectService.mcode();

        // 性別、所属部署、趣味それぞれの情報を代入する変数
        Map<String, String> sexMap = new HashMap<String, String>();
        Map<String, String> divisionMap = new HashMap<String, String>();
        Map<String, String> hobbyMap = new HashMap<String, String>();

        for (McodeEntity mcode : mcodeList) {
            if (mcode.getCLASSTYPE().equals("C0001")) {
                sexMap.put(mcode.getCODE(), mcode.getCODENAME());
            } else if (mcode.getCLASSTYPE().equals("C0002")) {
                divisionMap.put(mcode.getCODE(), mcode.getCODENAME());
            } else if (mcode.getCLASSTYPE().equals("C0003")) {
                hobbyMap.put(mcode.getCODE(), mcode.getCODENAME());
            }
        }

        model.addAttribute("sexMap", sexMap);
        model.addAttribute("divisionMap", divisionMap);
        model.addAttribute("hobbyMap", hobbyMap);

        model.addAttribute("insertForm", new InsertForm());

        return "Register";
    }
}

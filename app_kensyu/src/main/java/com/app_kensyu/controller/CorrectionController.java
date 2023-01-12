package com.app_kensyu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app_kensyu.entity.McodeEntity;
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

        // 社員情報を取得
        TemployeeEntity temployee = selectService.OneTemployee(id);
        // 職歴情報を取得
        List<TcareerEntity> tcareerList = selectService.OneTcareer(id);

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

        return "Register";
    }

}

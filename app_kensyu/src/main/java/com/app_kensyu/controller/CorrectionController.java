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
    public String correction(@RequestParam long id, Model model) {

        // 性別、所属部署、趣味それぞれの情報を代入する変数
        Map<String, String> sexMap = new HashMap<String, String>();
        Map<String, String> divisionMap = new HashMap<String, String>();
        Map<String, String> hobbyMap = new HashMap<String, String>();

        // 画面に表示する情報（性別、所属部署、趣味）をDBから取得し、リストに代入
        List<McodeEntity> mcodeList = selectService.mcode();

        // [性別、所属部署、趣味]それぞれの変数（Map）に、データベースから取得した情報を代入
        for (McodeEntity mcode : mcodeList) {
            if (mcode.getCLASSTYPE().equals("C0001")) {
                sexMap.put(mcode.getCODE(), mcode.getCODENAME());
            } else if (mcode.getCLASSTYPE().equals("C0002")) {
                divisionMap.put(mcode.getCODE(), mcode.getCODENAME());
            } else if (mcode.getCLASSTYPE().equals("C0003")) {
                hobbyMap.put(mcode.getCODE(), mcode.getCODENAME());
            }
        }

        // データベースから社員情報を取得
        TemployeeEntity temployee = selectService.OneTemployee(id);
        // データベースから職歴情報を取得
        List<TcareerEntity> tcareerEntityList = selectService.OneTcareer(id);

        InsertForm insertForm = new InsertForm();
        insertForm.setId(temployee.getId());
        insertForm.setName(temployee.getName());
        insertForm.setSex(temployee.getSex());
        insertForm.setBirthday(temployee.getBirthday());
        insertForm.setZip(temployee.getZip());
        insertForm.setAddress1(temployee.getAddress1());
        insertForm.setAddress2(temployee.getAddress2());
        insertForm.setNyushaym(temployee.getNyushaym());
        insertForm.setDivision(temployee.getDivision());
        insertForm.setHobby1(temployee.getHobby1());
        insertForm.setHobby2(temployee.getHobby2());
        insertForm.setHobby3(temployee.getHobby3());
        insertForm.setSelfIntro(temployee.getSelfIntro());
        insertForm.setTcareerEntityList(tcareerEntityList);

        model.addAttribute("sexMap", sexMap);
        model.addAttribute("divisionMap", divisionMap);
        model.addAttribute("hobbyMap", hobbyMap);

        model.addAttribute("insertForm", insertForm);

        return "Register";
    }

}

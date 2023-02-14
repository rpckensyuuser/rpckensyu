package com.app_kensyu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.entity.McodeEntity;
import com.app_kensyu.entity.TemployeeEntity;
import com.app_kensyu.form.InsertForm;
import com.app_kensyu.service.DeleteService;
import com.app_kensyu.service.InsertService;
import com.app_kensyu.service.SelectService;
import com.app_kensyu.service.UpdateService;

/**
 * 社員情報登録完了画面のコントローラー
 */
@Controller
@RequestMapping("/*")
public class InsertController {

    @Autowired
    private SelectService selectService;

    @Autowired
    private InsertService insertService;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private DeleteService deleteService;

    /**
     * 初期表示
     * ＠param insertForm フォームに入力された値, bindingResult バリデーションチェック結果, model 画面のモデル
     * @return 社員情報登録完了画面
     */
    @PostMapping("insert")
    public String insert(@Valid @ModelAttribute InsertForm insertForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }

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
            model.addAttribute("insertForm", insertForm);
            model.addAttribute("tcareerList", insertForm.getTcareerList());

            model.addAttribute("validationError", errorList);

            return "Register";
        }

        if (insertForm.getId() == 0) {
            //社員情報テーブル追加
            TemployeeEntity temployeeEntity = insertService.insertTemployee(insertForm);
            //職歴情報テーブル追加
            insertService.insertTcarerr(insertForm, temployeeEntity.getId());
        } else {
            //社員情報テーブル更新
            updateService.updateTemployee(insertForm);

            // 職歴情報を全削除し、新規登録
            deleteService.Tcareer(insertForm.getId());
            insertService.insertTcarerr(insertForm, insertForm.getId());
        }

        return "Insert";

    }
}

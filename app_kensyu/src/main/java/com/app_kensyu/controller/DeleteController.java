package com.app_kensyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app_kensyu.service.DeleteService;

/**
 * 社員情報削除のコントローラー
 */
@Controller
public class DeleteController {

    @Autowired
    private DeleteService deleteService;

    /**
     * 社員情報削除画面
     * ＠param model 画面のモデル
     * @return 社員情報完了画面
     */
    @GetMapping("delete")
    public String delete(@RequestParam long id, Model model) {

        // 社員情報を削除
        deleteService.Temployee(id);
        // 職歴情報を削除
        deleteService.Tcareer(id);

        return "Insert";

    }
}

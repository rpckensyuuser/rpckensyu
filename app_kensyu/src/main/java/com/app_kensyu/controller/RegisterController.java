package com.app_kensyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_kensyu.form.InsertForm;

@RequestMapping("/*")
@Controller
public class RegisterController {

    /**
     * 社員情報登録画面
     * @param model 画面のモデル
     * @return 社員情報登録画面
     */
    @GetMapping("Register")
    public String Register(Model model) {
        //ページ名を設定
        model.addAttribute("screen_name", "社員情報登録画面 (SEMPM02)");
        model.addAttribute("register_id", "※システムで自動採番されます");

        /*
         * 粕谷コメント
         * 必ず1ユーザーの登録・編集を1画面にて行うのでinsertFormを配列化する必要はありません
         * addAttributeするのはinsertFormクラスのみでよいでしょう。
         */
        model.addAttribute("insertForm", new InsertForm());

        /*
         * 粕谷コメント
         * insertForm内に設定する性別/所属部署/趣味の項目については
         * DB上のマスタテーブルから取得して動的に画面上(insertForm上)に設定するようにしましょう。
         */

        return "Register";
    }
}

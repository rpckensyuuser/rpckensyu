package com.app_kensyu.form;

import lombok.Data;

@Data
public class InsertForm {
    //ID
    //@NotNull
    private long id;

    //社員名
    //@NotNull
    //@Length(min = 1, max = 50)
    private String name;

    //性別
    //@NotNull
    private String sex;

    /*
     * 粕谷コメント
     * 下の職歴情報の日付もそうですがDate型の指定をやめています。
     * 理由としてはHTMLでのtype="Date"は『入力欄のタイプ指定』なのですが
     * ここでのDate指定は『変数の型』を指定するものだからです
     * プログラミング言語の型におけるDateというのは結構厄介で
     * 単純な『yyyy-MM-dd HH:ii:ss』のようになっていないものがほとんどです。
     * なので画面のような単純な情報と行き来させる際は
     * String型で定義、取得して、サーバーサイドに来てからそれぞれのプログラミング言語の日付型に変更する
     * という方法をとります
     *
     * 実際、Springでも画面から格納した際はString型となっているため
     * Field error in object 'insertForm' on field 'birthday': rejected value []; codes [typeMismatch.insertForm.birthday,typeMismatch.birthday,typeMismatch.java.util.Date,typeMismatch];
     * というエラーが出てしまっていました。
     */
    //生年月日
    //@NotNull
    //@DateTimeFormat(pattern = "yyyy/MM/dd")
    private String birthday;

    //郵便番号
    //@Length(min = 1, max = 7)
    //@Pattern(regexp = "\\d{7}")
    private String zip;

    //住所１
    //@Length(min = 1, max = 100)
    private String adress1;

    //住所２
    //@Length(min = 1, max = 100)
    private String adress2;

    //入社年月
    //@DateTimeFormat(pattern = "yyyyMM")
    private String nyushaym;

    //所属部署
    private String division;

    /*
     * 粕谷コメント
     * 画面のチェックボックスを取得する用の変数と
     * マスタテーブルから趣味のコードを取得するようにした場合は
     * 別途コード情報を引き渡すための配列を用意してください。
     */
    //趣味
    //@Size(min = 0, max = 3)
    private String[] hobby;

    //自己紹介
    //@Length(min = 0, max = 200)
    private String self_intro;

    /*
     * 粕谷コメント
     * Formは画面との変数やり取りのために使用するクラスなので
     * 職歴情報についてはForm上では以下の書き方で問題ありません
     * DTOまたはEntityに詰める際にテーブルごとに分ければよいです。
     * ※わかりやすく重複を避けるために変数名を少し変えています。
     */
    //開始期間
    //@NotNull
    private String[] careerStartDate;

    //終了期間
    //Fs@NotNull
    private String[] carreerEndDate;

    //案件名
    private String[] carreerProposition;

}

/**
 * 社員登録 / 編集画面で使用するJavaScript
 */

$(function(){

	/*
	 * 趣味チェックボックスの表示制御
	 */
	$("input[name='hobby']").on('change', function() {
		if($('.hobbyChk:checked').length >= 3) {
			// 3つ以上チェックが入った場合未チェックの要素を非活性にする
			$('.hobbyChk:not(:checked)').prop('disabled', true);
		} else {
			// チェック数がそれ以下の場合、未チェックの要素を活性にする
			$('.hobbyChk:not(:checked)').prop('disabled', false);
		}
	});
});

/*
 * 職歴情報追加ボタン押下時の処理
 */
function coladd() {
	// var table = document.getElementById("tablevalue12"); ←jQueryではなくJavaScriptのセレクタ記載になってしまっています

	// 追加できるのは10行までなので、現在のtrの個数を数えて行数制限をかける
	if($('.career_row').length < 10) { // 入力行が10行未満の時
		// tbodyの最終行をそのままコピーする
		$('#tablevalue12 tbody tr:last-child').clone(true).appendTo('#tablevalue12 tbody');
		// コピーした行の項目を全て空にする
		$('#tablevalue12 tbody tr:last-child input').val('');

	} else { // 10個以上の場合
		// エラーメッセージ
		alert('入力できる職歴情報は10個までです。');
	}

/*
		// 行を行末に追加
		var row = table.insertRow(-1);
		//td分追加
		var cell1 = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		var cell4 = row.insertCell(-1);

		var index = tablevalue12.rows.length - 2;

		// セルの内容入力
		cell1.innerHTML = '<td><input type="date" name="formDataList[' + index + '].start_date" id="formDataList' + index + '.start_date" value=""></td>';
		cell2.innerHTML = '<td><input type="date" name="formDataList[' + index + '].end_date" id="formDataList' + index + '.end_date" value=""></td>';
		cell3.innerHTML = '<td><input type="text" name="formDataList[' + index + '].proposition" id="formDataList' + index + '.proposition" value=""></td>';
		cell4.innerHTML = '<td><input type="button" value=削除 id="coldel_btn" onclick="coldel(this)"></td>	';
*/
}

/*
 * 職歴情報削除ボタン押下時の処理
 */
function coldel(obj) {
	// 全ての要素を削除してしまわないように、現在のtrの個数を数えて行数制限をかける
	if($('.career_row').length > 1) { // 入力行が2行以上の時
		// 削除ボタンを押下された行を取得
		tr = obj.parentNode.parentNode;
		// trのインデックスを取得して行を削除する
		tr.parentNode.deleteRow(tr.sectionRowIndex);

	} else { // 1行以下の場合
		// エラーメッセージ
		alert('職歴情報をすべて削除することはできません。');
	}
}
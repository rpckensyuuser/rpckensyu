
$(function() {
	$('#btn').on('click', () => {
		$.ajax({
			url: "http://zipcloud.ibsnet.co.jp/api/search?zipcode=" + $('#postcode').val(),
			dataType: 'jsonp',
		}).done((data) => {
			if (data.results) {
				getData(data.results[0]);
			} else {
				alert('該当データが見つかりません');
			}
		}).fail((data) => {
			alert('通信に失敗しました');
		});
	});
	function getData(data) {
		$('#address1').val(data.address1 + data.address2);
	}

})


$("input[type=checkbox]").click(function() {
	var $count = $("input[type=checkbox]:checked").length;
	var $not = $('input[type=checkbox]').not(':checked')
	if ($count >= 3) {
		$not.attr("disabled", true);
	} else {
		$not.attr("disabled", false);
	}
})


function coladd() {
	if (tablevalue12.rows.length <= 10) {

		var table = document.getElementById("tablevalue12");
		// 行を行末に追加
		var row = table.insertRow(-1);
		row.setAttribute('class', 'tcareerDataRow');
		//td分追加
		var cell1 = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);
		var cell4 = row.insertCell(-1);
		var index = tablevalue12.rows.length - 2;
		// セルの内容入力
		cell1.innerHTML = '<td><input type="date" class="startDate" id="tcareerList' + index + '.startDate" name="tcareerList[' + index + '].startDate"></td>';
		cell2.innerHTML = '<td><input type="date" class="endDate" id="tcareerList' + index + '.endDate" name="tcareerList[' + index + '].endDate"></td>';
		cell3.innerHTML = '<td><input type="text" class="proposition" id="tcareerList' + index + '.proposition" name="tcareerList[' + index + '].proposition"></td>';
		cell4.innerHTML = '<td><input type="button" value=削除 id="coldel_btn" onclick="coldel(this)"></td>	';
	}

};


function coldel(obj) {

	// 削除ボタンを押下された行を取得
	tr = obj.parentNode.parentNode;
	// trのインデックスを取得して行を削除する
	tr.parentNode.deleteRow(tr.sectionRowIndex);

	$("#tablevalue12 .tcareerDataRow").each(function(index, element) {
		// 開始日のid,nameの書き換え。
		$(this).find('.startDate').attr('id', 'careerList' + index + '.startDate');
		$(this).find('.startDate').attr('name', 'tcareerList[' + index + '].startDate');
		// 終了日のid,nameの書き換え。
		$(this).find('.endDate').attr('id', 'careerList' + index + '.endDate');
		$(this).find('.endDate').attr('name', 'tcareerList[' + index + '].endDate');
		// 案件名のid,nameの書き換え。
		$(this).find('.proposition').attr('id', 'careerList' + index + '.proposition');
		$(this).find('.proposition').attr('name', 'tcareerList[' + index + '].proposition');
	})

};

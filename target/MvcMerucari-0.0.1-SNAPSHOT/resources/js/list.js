var path = location.pathname;
var totalPageNum = 0;
var flag = false;
var counter = 1;

/** topページを表示する際にItemを取ってきてappend */
$(function () {

	$.ajax({
		type: "get",
		url: path + "get_item_list_for_top",
		dataType: "json"
	}).then(function (data) {
		console.log(data);

		for (var value of data) {
			if (value.brand == null) {
				$(".appendClass").append(

					"<tr>"
					+ "<td class='item-name'><a href='detail?id=" + value.id + "'>"
					+ value.name
					+ "</a></td>"
					+ "<td class='item-price'>"
					+ value.price
					+ "</td>"
					+ "<td class='item-category'>"
					+ value.category
					+ "</td>"
					+ "<td class='item-brand'>"
					+ ""
					+ "</td>"
					+ "<td class='item-condition'>"
					+ value.condition
					+ "</td>"
					+ "</tr>"
				)

			} else {

				$(".appendClass").append(

					"<tr>"
					+ "<td class='item-name'><a href='detail?id=" + value.id + "'>"
					+ value.name
					+ "</a></td>"
					+ "<td class='item-price'>"
					+ value.price
					+ "</td>"
					+ "<td class='item-category'>"
					+ value.category
					+ "</td>"
					+ "<td class='item-brand'>"
					+ value.brand
					+ "</td>"
					+ "<td class='item-condition'>"
					+ value.condition
					+ "</td>"
					+ "</tr>"
				)
			}
		}
	}, function () {
	});
});

/** ページネーション機能 - 初めてアクセスされた際に総ページ数を算出 - */
$(function () {

	var totalDataNum = 0;

	// 商品の総数を取得
	$.ajax({
		type: "get",
		url: path + "getTotalItem",
		dataType: "json"
	}).then(function (data) {

		totalDataNum = data;
		totalPageNum = Math.ceil(totalDataNum / 30);
		$(".input-group-addon").html(
			"/" + totalPageNum
		)

	}, function () {
	});

	var selectVal = $("#select_test").val();
});

/** ページネーション機能  - next or prev が押された時に発生 - */
$(function () {

	$(select_page_form).val(counter);

	// next が押されたら +1
	$(".nextA").click(function () {

		// ページ総数処理 -------------------
		if (flag) {
			$(".input-group-addon").html(
				"/" + totalPageNum
			)
			flag = false;
		}
		//----------------------------------

		if (counter >= totalPageNum) {
			counter = totalPageNum;
			$(select_page_form).val(counter);
		} else {

			counter += 1;
			console.log(counter);
			$(select_page_form).val(counter);

			$.ajax({
				type: "get",
				url: "/MvcMerucari/paging",
				dataType: "json",
				data: { "counter": counter },
			}).then(function (data) {

				$(".appendClass").empty();

				for (var value of data) {

					if (value.brand == null) {
						$(".appendClass").append(

							"<tr>"
							+ "<td class='item-name'><a href='detail?id=" + value.id + "'>"
							+ value.name
							+ "</a></td>"
							+ "<td class='item-price'>"
							+ value.price
							+ "</td>"
							+ "<td class='item-category'>"
							+ value.category
							+ "</td>"
							+ "<td class='item-brand'>"
							+ ""
							+ "</td>"
							+ "<td class='item-condition'>"
							+ value.condition
							+ "</td>"
							+ "</tr>"
						)

					} else {


						$(".appendClass").append(

							"<tr>"
							+ "<td class='item-name'><a href='detail?id=" + value.id + "'>"
							+ value.name
							+ "</a></td>"
							+ "<td class='item-price'>"
							+ value.price
							+ "</td>"
							+ "<td class='item-category'>"
							+ value.category
							+ "</td>"
							+ "<td class='item-brand'>"
							+ value.brand
							+ "</td>"
							+ "<td class='item-condition'>"
							+ value.condition
							+ "</td>"
							+ "</tr>"
						)
					}
				}
			}, function () {
			});
		}
	});


	// prev が押されたら -1
	$(".prevA").click(function () {

		// ページ総数処理 -------------------
		if (flag) {
			$(".input-group-addon").html(
				"/" + totalPageNum
			)
			flag = false;
		}
		//----------------------------------


		if (counter < 1 || counter == 1) {
			counter = 1;
			$(select_page_form).val(counter);
		} else {
			counter -= 1;
			console.log(counter);
			$(select_page_form).val(counter);

			$.ajax({
				type: "get",
				url: "/MvcMerucari/paging",
				dataType: "json",
				data: { "counter": counter },
			}).then(function (data) {

				$(".appendClass").empty();

				for (var value of data) {

					if (value.brand == null) {
						$(".appendClass").append(

							"<tr>"
							+ "<td class='item-name'><a href='detail?id=" + value.id + "'>"
							+ value.name
							+ "</a></td>"
							+ "<td class='item-price'>"
							+ value.price
							+ "</td>"
							+ "<td class='item-category'>"
							+ value.category
							+ "</td>"
							+ "<td class='item-brand'>"
							+ ""
							+ "</td>"
							+ "<td class='item-condition'>"
							+ value.condition
							+ "</td>"
							+ "</tr>"
						)

					} else {

						$(".appendClass").append(

							"<tr>"
							+ "<td class='item-name'><a href='detail?id=" + value.id + "'>"
							+ value.name
							+ "</a></td>"
							+ "<td class='item-price'>"
							+ value.price
							+ "</td>"
							+ "<td class='item-category'>"
							+ value.category
							+ "</td>"
							+ "<td class='item-brand'>"
							+ value.brand
							+ "</td>"
							+ "<td class='item-condition'>"
							+ value.condition
							+ "</td>"
							+ "</tr>"
						)
					}
				}
			}, function () {
			});

		}

	});

});





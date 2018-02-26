package jp.co.rakus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.rakus.domain.Item;
import jp.co.rakus.service.ItemService;

@RestController
public class AjaxController {

	@Autowired
	private ItemService itemService;

	/** topページ用. 30件データ送信 */
	@RequestMapping(value = "/get_item_list_for_top")
	public List<Item> getItemListForTop() {
		return itemService.findLimit30();
	}

	/** 【ajax】ページネーション機能 - DBのItem総数を返す */
	@RequestMapping(value = "/getTotalItem")
	public Integer getTotalItem() {
		return itemService.getNumOfTotalData();
	}

	/** 【ajax】ページネーション機能 - ブラウザからクリックされたページを受け取り、そこで表示するItemListを返す */
	@RequestMapping(value = "/paging")
	public List<Item> clickPagingNum(@RequestParam String counter) {

		int offset = 0;

		try {
			offset = 30 * (Integer.parseInt(counter) - 1);
		} catch (Exception e) {
			offset = 0;
		}

		List<Item> itemList = itemService.findByLimitAndOffset(30, offset);
		return itemList;
	}



}

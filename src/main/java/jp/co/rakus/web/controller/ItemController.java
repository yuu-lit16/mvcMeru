package jp.co.rakus.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.service.ItemService;

@Controller
public class ItemController {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
	private ItemService itemService;

	/** list(top page)を表示する */
	@RequestMapping(value= "/")
	public String index() {
		return "list";
	}

	/** Database確認用 */
	@RequestMapping(value= "/test_DB")
	public String testConnectiongDB() {
	    List<Map<String, Object>> itemList = jdbcTemplate.queryForList("select * from items limit 10");
		return "list";
	}



}

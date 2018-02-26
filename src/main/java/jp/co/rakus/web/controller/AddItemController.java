package jp.co.rakus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddItemController {

	@RequestMapping(value = "/add")
	public String displayAddPage() {
		return "add";
	}

}

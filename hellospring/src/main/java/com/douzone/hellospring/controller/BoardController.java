package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RequestMapping 메소드 단독 매핑
@Controller
public class BoardController {
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}
	
	@ResponseBody
	@RequestMapping("/board/view/{no}")
	// 값을 파라미터가 아니라 Path로 받을 수 있다.
	public String view(@PathVariable("no") Long no) {
		return "BoardController.view(" + no +")";
	}
}

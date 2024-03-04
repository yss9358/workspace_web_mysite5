package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 리스트 가져오기
	@RequestMapping(value="/board/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(HttpSession session) {
		System.out.println("list");
		boardService.exeList();
		return "board/list";
	}
}

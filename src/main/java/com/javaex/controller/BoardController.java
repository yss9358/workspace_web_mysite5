package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 리스트 가져오기
	@RequestMapping(value="/board/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<BoardVo> userList = boardService.exeList();
		model.addAttribute("userList", userList);
		return "board/list";
	}
	
	// 글쓰기 폼 
	@RequestMapping(value="/board/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("writeForm");
		return "board/writeForm";
	}
	
	// 글쓰기
	@RequestMapping(value="/board/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo) {
		int count = boardService.exeWrite(boardVo);
		System.out.println(count);
		return "redirect:/board/list";
	}
	
	
}

package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService gbService;
	
	// 게시판리스트
	@RequestMapping(value="/gb/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(HttpSession session) {
		session.setAttribute("gbList", gbService.exeList());
		return "guestbook/addlist";
	}
	
	// 등록
	@RequestMapping(value="/gb/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		int count = gbService.exeAdd(guestbookVo);
		System.out.println(count);
		return "redirect:/gb/list";
	}
	
	// 삭제폼
	@RequestMapping(value="/gb/deleteform", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam int no) {
		return "guestbook/deleteForm";
	}
	
	// 삭제
	@RequestMapping(value="/gb/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		int count = gbService.exeDelete(guestbookVo);
		if(count==1) {
			return "redirect:/gb/list";
		} else {
			return "guestbook/deleteForm";
		}
	}
}

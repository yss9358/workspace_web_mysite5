package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인폼
	@RequestMapping(value="/user/loginform" ,method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "user/loginForm";
	}
	
	// 로그인
	@RequestMapping(value="/user/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		UserVo authUser = userService.exeLogin(userVo);
		session.setAttribute("authUser", authUser);
		
		if(authUser != null) {
			return "redirect:/main";
		} else {
			return "redirect:/user/loginform";
		}
	}
	
	// 로그아웃
	@RequestMapping(value="/user/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	// 회원가입폼
	@RequestMapping(value="/user/joinform", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		return "user/joinForm";
	}
	
	// 회원가입
	@RequestMapping(value="/user/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		int count = userService.exeJoin(userVo);
		System.out.println(count);
		return "user/joinOk";
	}
	
	// 회원정보수정폼
	@RequestMapping(value="/user/modifyform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam int no, HttpSession session) {
		session.setAttribute("selectVo", userService.exeSelectOne(no));
		return "user/modifyForm";
	}
	
	// 회원정보수정
	@RequestMapping(value="/user/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		userService.exeModify(userVo);
		session.removeAttribute("authUser");
		UserVo authUser = userService.exeSelectOne(userVo.getNo());
		session.setAttribute("authUser", authUser);
		return "redirect:/main";
	}
	
	
}

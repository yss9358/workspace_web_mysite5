package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {

	@RequestMapping(value="/gall/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		return "gallery/list";
	}
}

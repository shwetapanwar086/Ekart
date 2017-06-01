package com.MobiShop.MobiShopBackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String getIndexPage()
	{
		return"index";
	}

	@RequestMapping("aboutus")
	public String aboutUs()
	{
		return "aboutus";
	}
	@RequestMapping("Register")
	public String showRegister()
	{
		return "Register";
	}
}


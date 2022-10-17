package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model)
	{
		return "index";
	}
	
	@RequestMapping("/aboutus")
	public String aboutus(Model model)
	{
		return "aboutus";
	}
	
	@RequestMapping("/header")
	public String header(Model model)
	{
		return "header";
	}
	
	@RequestMapping("/footer")
	public String footer(Model model)
	{
		return "footer";
	}
	
	@RequestMapping("/menu1")
	public String menu1(Model model)
	{
		return "menu1";
	}
	
	@RequestMapping("/menu2")
	public String menu2(Model model)
	{
		return "menu2";
	}
}


package com.ossms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	@GetMapping(value = "/products")
	public String proAdminPg() {
		return "ProManage/Padmin";
	}
	
}

package com.ossms.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
	@GetMapping(value = "/supplier")
	public String supAdminPg() {
		return "SuppManage/Sadmin";
	}

}

package com.ossms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.Customer;
import com.ossms.service.CustomerService;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/AdminDashbord")
	public String viewAdminDashbord() {
		
		return "CusManage/AdminDashbord";
	}
	
	@RequestMapping(value="/Ranking")
	public String viewRanking() {
		
		return "CusManage/Ranking";
	}
	
	@RequestMapping(value="/AdminProfile")
	public String viewAdminProfile() {
		
		return "CusManage/AdminProfile";
	}
	
	
	@RequestMapping(value="/CustomerProfile")
	public String viewCustomerProfile() {
		
		return "CusManage/CustomerProfile";
	}
	
	@RequestMapping(value="/Register")
	public String viewRegisterpage() {
		
		return "CusManage/Register";
	}
	
	@RequestMapping(value="/loginpage")
	public String viewLoginpage() {
		
		return "CusManage/login";
	}
	

	@RequestMapping(value="/addcustomer" , method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer")  Customer customer) {
	
		ModelAndView model = new ModelAndView();
		System.out.println(customer);
		customerService.addCustomer(customer);
		model.setViewName("CusManage/CustomerProfile");
		
		return model;
	}
		

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		
		customerService.deleteCustomer(id);
		return "CusManage/login";		
	}
	
}

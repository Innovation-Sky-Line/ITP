package com.ossms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.Customer;
import com.ossms.model.Order;
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
	
	
	@RequestMapping(value="/CustomerProfile" , method=RequestMethod.GET)
	public ModelAndView viewCustomerProfile(@RequestParam("id") int id) {
		
		Customer customer = customerService.getCustomer(id); 
		
		ModelAndView model = new ModelAndView();	
		
		model.setViewName("CusManage/CustomerProfile");
		
		model.addObject("customer", customer);
		
		return model;
	}
	@RequestMapping(value="/CustomerDashbord", method=RequestMethod.GET)
	public ModelAndView viewCustomerDashbord(@RequestParam("id") int id) {
		
		Customer customer = customerService.getCustomer(id); 
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("CusManage/CustomerDashbord");
		
		model.addObject("customer", customer);
		
		return model;
	}
	
	@RequestMapping(value="/Register")
	public String viewRegisterpage() {
		
		return "CusManage/Register";
	}
	
	@RequestMapping(value="/loginpage")
	public String viewLoginpage() {
		
		return "CusManage/login";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "id") int id) {
		ModelAndView model = new ModelAndView("CusManage/CustomerDashbord");
		List<Order> orderList = customerService.getIncompleteOrders(id);
		model.addObject("orderList", orderList);

		return model;
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password) {
		
		ModelAndView model = new ModelAndView();	
		
		Customer customer = customerService.findCustomerByEmail(email);	
		
		String dbpassword = customer.getPassword();
		
	
		if(dbpassword.equals(password)) {
			
			model.setViewName("CusManage/CustomerProfile");
			
			model.addObject("customer", customer);
	
			return model;
		}
		else {
			model.setViewName("CusManage/login");
			return model;
		}
		
		
		
	}

	@RequestMapping(value="/addcustomer" , method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer")  Customer customer, @RequestParam(value="address") String address) {
	
		ModelAndView model = new ModelAndView();		
		
		customer.setCity(address);
		
		customerService.addCustomer(customer);
		
		model.setViewName("CusManage/CustomerProfile");
		model.addObject("customer", customer);
		
		return model;
	}
	
	@RequestMapping(value="/invalidate", method=RequestMethod.GET)
	public String invalidate(HttpSession session, Model model) {
			
	  session.invalidate();
	  if(model.containsAttribute("customer")) model.asMap().clear();
	  
	  return "CusManage/login";
	}
		

	@RequestMapping(value="/delete" , method=RequestMethod.POST)
	public String deleteCustomer(@RequestParam(value = "cusid") int id) {
		
		customerService.deleteCustomer(customerService.getCustomer(id));
		return "CusManage/login";		
	}
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public String updateCustomer(@RequestParam(value = "idCustomer") int id) {
		
		Customer customer = customerService.getCustomer(id);
		
		customerService.update(customer,id);
		return "CusManage/login";		
	}
	
}

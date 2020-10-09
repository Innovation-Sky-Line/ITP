package com.ossms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.Customer;
import com.ossms.model.Order;
import com.ossms.model.PastOrder;
import com.ossms.service.CustomerService;
import com.ossms.service.OrderService;
import com.ossms.service.PaymentServices;


@Controller
@RequestMapping(value="/customer")
@SessionAttributes({"customer"})
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PaymentServices paymentService;
	

	
	@RequestMapping(value="/checkpassAndUname", method=RequestMethod.POST)
	public ModelAndView checkUsernameAndEmail(@RequestParam(value="email") String email,
											  @RequestParam(value="username") String userName) {
		
		ModelAndView model = new ModelAndView();
		
		Customer customer = customerService.findCustomerByEmail(email);
		
		String dbusername = customer.getUsername();
		
		if(dbusername.equals(userName))
		{
			
			model.setViewName("CusManage/confirmpass");
			
			model.addObject("customer", customer);
			
			model.addObject("email", customer.getEmail() );
			
			return model;
		}
		else {
			
			model.setViewName("CusManage/forgotpass");
			model.addObject("invalid", "Warning!");
			model.addObject("details", " Please enter a valid Username in all the required fields");
			return model;
			
		}
		
		
		
		
	}
	@RequestMapping(value="/resetpassword", method=RequestMethod.POST)
	public ModelAndView resetpasss(@RequestParam(value="pass1") String pass1,
								   @RequestParam(value="pass2") String pass2, 
								   @RequestParam(value="email")  String email ){
		
		ModelAndView model = new ModelAndView();
		
		if(pass1.equals(pass2)) {
			
			Customer customer = customerService.findCustomerByEmail(email);
			
			int id = customer.getIdCustomer();
			
			customer.setPassword(pass1);
			
			System.out.println(customer);
			
			customerService.update(customer, id );
			
			model.setViewName("CusManage/login");
			
			model.addObject("notequal","password reset complete!");
			
			return model ;
			
		}
		else {
			
			model.setViewName("CusManage/confirmpass");
			
			model.addObject("notequal","password missmatch");
			
			return model ;

		}
		
		
		
	}
	
	@RequestMapping(value="/forgotpassword")
	public String forgotpasss() {
		
		return "CusManage/forgotpass";
	}
	
	
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
	public ModelAndView viewCustomerProfile(
			HttpSession session
			) {
		ModelAndView model = new ModelAndView();
		
		Customer customer = (Customer) session.getAttribute("customer");
		
		model.setViewName("CusManage/CustomerProfile");
		
		session.setAttribute("customer", customer  );
		
		session.setAttribute("customerId", customer.getIdCustomer()  );
		
		
		return model;
	}
	@RequestMapping(value="/CustomerDashbord", method=RequestMethod.GET)
	public ModelAndView viewCustomerDashbord(HttpSession session) {
		
		Customer customer = (Customer) session.getAttribute("customer"); 
		
		ModelAndView model = new ModelAndView();
		
		session.setAttribute("customer", customer  );
		
		session.setAttribute("customerId", customer.getIdCustomer());
		
		model.setViewName("CusManage/CustomerDashbord");
		
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
	public ModelAndView list(HttpSession session) {
		
		ModelAndView model = new ModelAndView("CusManage/CustomerDashbord");
		
		float total = 0;
			
		int id = (int) session.getAttribute("customerId");
		
		session.setAttribute("customerId", id );
		
		session.setAttribute("customer", customerService.getCustomer(id) );
		
		List<Order> orders = orderService.getPendingOrders(id);	//pass session cusId
		
		List<PastOrder> preOrders = new ArrayList<PastOrder>();
		
		for(Order porders : orders) {
			
			total = paymentService.findPaymentByOrderId(porders.getOrderId()).getAmount();
			PastOrder paOrd = new PastOrder(porders, total);
			preOrders.add(paOrd);
			
		}
		
		
		model.addObject("customer",customerService.getCustomer(id));
		model.addObject("pending", preOrders);
		
		return model;
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "email") String email
							,@RequestParam(value = "password") String password,
							HttpSession session) {
		
		ModelAndView model = new ModelAndView();	
	
		if(email.equals("admin@gmail.com") && password.equals("admin") ){
			
			model.setViewName("CusManage/AdminProfile");
			
			return model;		
		
		}
		else {
			
			Customer customer = customerService.findCustomerByEmail(email);	
			
			String dbpassword = customer.getPassword();
			
				if(dbpassword.equals(password)) {
					
					session.setAttribute("customerId", customer.getIdCustomer());

					session.setAttribute("customer", customer);
					
					model.setViewName("CusManage/CustomerProfile");
					
			
					return model;
				}
				else {
					
					model.setViewName("CusManage/login");
					model.addObject("incorrect", "incorrect email or password");
					return model;
					
				}
				
		}
		
		
	}
	

	@RequestMapping(value="/addcustomer" , method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("newcustomer")  Customer newcustomer, 
									@RequestParam(value="city") String address ,
									@RequestParam(value = "password") String pass1,
									@RequestParam(value = "pass2") String pass2,
									@RequestParam(value = "email") String email,
									Model m,
									HttpSession session) {
							
		ModelAndView model = new ModelAndView();		

		if(pass1.equals(pass2))
		{

			int len = pass1.length();
			
			Customer iscustomer = customerService.findCustomerByEmail(email);	
			
			if(iscustomer==null) {
				
				customerService.addCustomer(newcustomer);
				
				session.setAttribute("customer", newcustomer);
				
				session.setAttribute("customerId", newcustomer.getIdCustomer());

				model.setViewName("CusManage/CustomerProfile");
				
				System.out.println(newcustomer);
			}
			else {
				
				if(len<8)
				{
					
					model.setViewName("CusManage/Register");
					model.addObject("len","please enter 8 character or more");
					
				}
				else {
					model.setViewName("CusManage/Register");
					model.addObject("exist","this email is alerdy exist please enter new one");
				}
			}
		
		
		return model;
		}
		else {
			
			model.setViewName("CusManage/Register");
			model.addObject("missmatch","password missmatch");
			return model;
		}
	}
	

	@RequestMapping(value="/invalidate", method=RequestMethod.GET)
	public String invalidate(HttpSession session, Model model) {
			
	  session.invalidate();
	  if(model.containsAttribute("customer")) model.asMap().clear();
	  model.addAttribute("sucess","logged out");
	  
	  return "CusManage/login";
	}
		

	@RequestMapping(value="/delete" , method=RequestMethod.POST)
	public String deleteCustomer(@RequestParam(value = "cusid") int id) {
		
		customerService.deleteCustomer(customerService.getCustomer(id));
		return "CusManage/login";		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public ModelAndView updateCustomer(@RequestParam(value = "idCustomer") int id,@RequestParam(value = "email") String email,@RequestParam(value = "password") String password,
			@RequestParam(value = "userName") String userName,@RequestParam(value = "contactNo") String contactNo,@RequestParam(value = "firstName") String firstName
			,@RequestParam(value = "lastName") String lastName,@RequestParam(value = "city") String city,
			HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		int cid = (int) session.getAttribute("customerId");
		
		Customer customer = customerService.getCustomer(cid);
		
		customer.setUsername(userName);
		customer.setPassword(password);
		customer.setCity(city);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setContactNo(contactNo);
		
		System.out.println(customer);
		
		customerService.update(customer,cid);
		
		Customer newcustomer = customerService.getCustomer(cid);
		
		session.setAttribute("customer", newcustomer );
		
		session.setAttribute("customerId", newcustomer.getIdCustomer() );
		
		model.setViewName("CusManage/CustomerProfile");
		
		model.addObject("customer", customer );
		
		
		return model;	
	}

	
}

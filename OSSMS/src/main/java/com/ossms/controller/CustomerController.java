package com.ossms.controller;

import java.time.LocalDate;
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
import com.ossms.model.CustomerOrder;
import com.ossms.model.Employee;
import com.ossms.model.Order;
import com.ossms.model.PastOrder;
import com.ossms.model.Payment;

import com.ossms.model.Product;
import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;
import com.ossms.model.ShoppingCart;
import com.ossms.model.Supplier;
import com.ossms.service.CartServiceImpl;
import com.ossms.service.CustomerService;
import com.ossms.service.OrderService;
import com.ossms.service.PaymentServices;
import com.ossms.service.ProductService;
import com.ossms.service.ProductsServiceImp;


@Controller
@RequestMapping(value="/customer")
@SessionAttributes({"customer"})
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartServiceImpl cs = new CartServiceImpl();
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PaymentServices paymentService;
	
	@Autowired
	ProductService ps = new ProductsServiceImp();
	
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
			
			model.setViewName("CusManage/forgotpassword");
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
			
			model.setViewName("CusManage/login-page");
			
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
		
		return "CusManage/forgotpassword";
	}
	
	
	@RequestMapping(value="/CustomerAdminDashbord")
	public String viewAdminDashbord() {
		
		return "CusManage/CustomerAdminDashbord";
	}
	
	@RequestMapping(value="/Ranking")
	public String viewRanking() {
		
		return "CusManage/Ranking";
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
	
	@RequestMapping(value="/login-page")
	public String viewNewLoginpage() {
		
		return "CusManage/login-page";
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
	@RequestMapping(value = "/customerreport", method = RequestMethod.POST)
	public ModelAndView getReport(@RequestParam(value = "customerId") int customerId) {
		
		ModelAndView model = new ModelAndView("CusManage/CustomerAdminDashbord");
		
		
		List<Order> orders = orderService.getOrderDetailsForList(customerId);

		
		float total = 0 ;
		
		List<Payment> payments = new ArrayList<Payment>();
		
		for(Order ordpayment : orders) {
			

			
			float amount = paymentService.findPaymentByOrderId(ordpayment.getOrderId()).getAmount();
			
			LocalDate date = paymentService.findPaymentByOrderId(ordpayment.getOrderId()).getDate();
			
			String type = paymentService.findPaymentByOrderId(ordpayment.getOrderId()).getType();
			
			total += amount;
			
			Payment pay = new Payment(ordpayment.getOrderId(),ordpayment.getCustomerId(),amount,date,type);
			
			payments.add(pay);
			
		}
		
		model.addObject("report", "success");	
		model.addObject("payments", payments);
		model.addObject("total", total);
		
		return model;
	}
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public ModelAndView customerList(@RequestParam(value = "fname") String name) {
		
		ModelAndView model = new ModelAndView("CusManage/CustomerAdminDashbord");
		
		List<Customer> customers = customerService.searchResult(name);
				
		model.addObject("sucess", "success");
		model.addObject("list", customers);
		
		return model;
		
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "email") String email
							,@RequestParam(value = "password") String password,
							HttpSession session) {
		
		ModelAndView model = new ModelAndView();	
	
		if(email.equals("cusadmin@gmail.com") && password.equals("cusadmin") ){
			
			model.setViewName("CusManage/CustomerAdminDashbord");
			
			return model;		
		
		}
		else if(email.equals("proadmin@gmail.com") && password.equals("proadmin")) {
			model.setViewName("ProManage/Padmin");
			
			ProductModel product = new ProductModel();
			model.addObject("productForm", product);
			List<Supplier> allSuppliers = ps.allSupplierNames();
			model.addObject("allSuppliers", allSuppliers);
			List<ProductCategoryModel> allCategories = ps.subCategoryNames();
			model.addObject("allCategories", allCategories);
			List<ProductCategoryModel> mainCategories = ps.mainCategoryNames();
			model.addObject("mainCategories", mainCategories);
			List<ProductCategoryModel> allCategories2 = ps.allCategoryNames();
			model.addObject("allCategories2", allCategories2);
			
			return model;
		}
		else if(email.equals("empadmin@gmail.com") && password.equals("empadmin")) {
			model.setViewName("EmpManage/EmpAdmin");
			
			Employee employee = new Employee();
			model.addObject("employee", employee);
			
			return model;
		}
		else if(email.equals("supadmin@gmail.com") && password.equals("supadmin")) {
			Supplier supplier = new Supplier();
			model.addObject("supplier", supplier);
			model.setViewName("SuppManage/supplier_form");
			
			return model;
		}
		else if(email.equals("ordadmin@gmail.com") && password.equals("ordadmin")) {
			//model.setViewName("OrderManage/ShowOrder");
			
			return list();
		}
		else if(email.equals("deladmin@gmail.com") && password.equals("deladmin")) {
			model.setViewName("EmpManage/EmpAdmin");
			
			return model;
		}
		else {
			
			Customer customer = customerService.findCustomerByEmail(email);	
			
			String dbpassword = customer.getPassword();
			
				if(dbpassword.equals(password)) {
					
					Order newOrder = orderService.getNewOrder(customer.getIdCustomer());

					session.setAttribute("orderId", newOrder.getOrderId());
					
					session.setAttribute("customerId", customer.getIdCustomer());

					session.setAttribute("customer", customer);		
			
					return productHome(session);
				}
				else {
					
					model.setViewName("CusManage/login-page");
					model.addObject("incorrect", "incorrect email or password");
					return model;
					
				}
				
		}
		
		
	}
	//--from Some
	@RequestMapping(value = "/completeOrderList", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("OrderManage/ShowOrder");
        List<Order> orderList = orderService.getAllCompletedOrders();
        List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
        for(Order o : orderList) {
        	int orderId = o.getOrderId();
        	LocalDate date = o.getDate();
        	Customer cus = orderService.getCusName(o.getCustomerId());
        	String name = cus.getFirstName() + " " + cus.getLastName();
        	
        	CustomerOrder order = new CustomerOrder(orderId, date, name);
        	orders.add(order);
        }
        model.addObject("orderList", orders);


        return model;
    }
	
	//--from Nadun
	@RequestMapping(value = "/cphp")
	public ModelAndView productHome(HttpSession session) {
		ModelAndView model = new ModelAndView("ProManage/CusProductHome");
		ProductModel product = new ProductModel();
		model.addObject("productForm", product);
		List<Supplier> allSuppliers = ps.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = ps.allCategoryNames();
		model.addObject("allCategories", allCategories);
		List<ProductCategoryModel> subCategories = ps.subCategoryNames();
		model.addObject("subCategories", subCategories);
		List<ProductCategoryModel> mainCategories = ps.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);
		List<ProductModel> p = ps.getDiscountProducts();
		model.addObject("discounted", p);
		List<ProductModel> topList= ps.topTwentyProducts();
		model.addObject("topList", topList);
		List<ShoppingCart> cart = cs.getItemsInCart((int) session.getAttribute("orderId"));
		model.addObject("itemsInCart", cart.size());
		return model;
	}

	@RequestMapping(value="/addcustomer" , method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("newcustomer")  Customer newcustomer, 
									@RequestParam(value="address") String address ,
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
				
				Order newOrder = new Order(newcustomer.getIdCustomer());
				newOrder.setStatus("Not Filled");
				newOrder.setDeliveryStatus("Not Delivered");
				orderService.saveOrder(newOrder);	
				session.setAttribute("orderId", newOrder.getOrderId());
				
				session.setAttribute("customer", newcustomer);
				
				session.setAttribute("customerId", newcustomer.getIdCustomer());

				model.setViewName("CusManage/CustomerProfile");
				
				System.out.println(newcustomer);
			}
			else {
				
				if(len<6)
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
	  
	  return "CusManage/login-page";
	}
		

	@RequestMapping(value="/delete" , method=RequestMethod.POST)
	public String deleteCustomer(@RequestParam(value = "cusid") int id) {
		
		customerService.deleteCustomer(customerService.getCustomer(id));
		return "CusManage/login";		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public ModelAndView updateCustomer(@RequestParam(value = "idCustomer") int id,@RequestParam(value = "email") String email,@RequestParam(value = "password") String password,
			@RequestParam(value = "userName") String userName,@RequestParam(value = "contactNo") String contactNo,@RequestParam(value = "firstName") String firstName
			,@RequestParam(value = "lastName") String lastName,@RequestParam(value = "address") String address,
			HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		
		int cid = (int) session.getAttribute("customerId");
		
		Customer customer = customerService.getCustomer(cid);
		
		customer.setUsername(userName);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setAddress(address);
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

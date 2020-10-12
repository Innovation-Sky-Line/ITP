package com.ossms.controller;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.CartItems;
import com.ossms.model.Customer;
import com.ossms.model.CustomerOrder;
import com.ossms.model.Order;
import com.ossms.model.PastOrder;
import com.ossms.model.Product;
import com.ossms.model.ProductModel;
import com.ossms.model.ShoppingCart;
import com.ossms.service.CartService;
import com.ossms.service.CustomerServiceImplementation;
import com.ossms.service.OrderService;
import com.ossms.service.PaymentServices;
import com.ossms.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PaymentServices pay;
	
	@Autowired
	CartService cs;
	
	@Autowired
	CustomerServiceImplementation csi = new CustomerServiceImplementation();	

	
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
	
	@RequestMapping(value="/bill")
	public ModelAndView bill(@RequestParam(value="orderId")int id) {
		 ModelAndView model = new ModelAndView("OrderManage/Bill");
		 float total = 0;
		 Order order =  orderService.getOrderById(id);
		 PastOrder pOrder;
		 total = pay.findPaymentByOrderId(id).getAmount();
		 pOrder = new PastOrder(order, total);
		 List<CartItems> cart = getCartItems(id);
		 System.out.println(id);
		 System.out.println(order);
		 System.out.println(cart);
		 model.addObject("cart",cart);
	
		 return model;
	}
	
	public List<CartItems> getCartItems(int orderId) {
		ModelAndView model = new ModelAndView();
		List<ShoppingCart> carts = cs.getItemsInCart(orderId);
		List<Product> prods = new ArrayList<Product>();
		List<CartItems> userCart = new ArrayList<CartItems>();
		for(ShoppingCart cart: carts) {
			int prodId = cart.getProductId();
			int qty = cart.getQty();
			ProductModel prod = productService.getProductById(prodId);
			String name = prod.getProductName();
			float disc = prod.getDiscount();
			float finalPrice = ((100 - disc) * prod.getPrice()) / 100;
			float total = finalPrice * qty;
			CartItems cartItem = new CartItems(prodId, orderId, name, qty, total);
			userCart.add(cartItem);			
		}	
		System.out.println(carts);
		return userCart;
	}
	
	
	
	
	@RequestMapping(value="/incomplete")
	public ModelAndView incompleteorder() {
		 ModelAndView model = new ModelAndView("OrderManage/Incomplete");
		 List<Order> inorderList = orderService.getAllIncompletedOrders();
		 model.addObject("inorderList", inorderList);
		 return model;
	}
	

	
	@RequestMapping(value="/changeStatus/" , method=RequestMethod.POST)
		public ModelAndView changeStatus(@RequestParam(value="order")int idOrder) {
			ModelAndView model = new ModelAndView("OrderManage/Incomplete");
			Order order = orderService.getOrderById(idOrder);
			System.out.println(order);
			order.setStatus("Complete");
			orderService.saveOrder(order);
		return list();
	}
	
	
	@RequestMapping(value="/report" )
	public ModelAndView report() {
		 ModelAndView model = new ModelAndView("OrderManage/Report");
		 List<Order> inorderList = orderService.getAllCompletedOrders();
		 model.addObject("inorderList", inorderList);
		 int monthVAl = getMonthInt("jan");
			System.out.println(monthVAl);
		 return model;
	}
	
	@RequestMapping(value="/ordermonth")
	public ModelAndView orderResults(@RequestParam (value="month")String month) {
		ModelAndView model = new ModelAndView("OrderManage/CreateReport");
		int monthVAl = getMonthInt(month);
		System.out.println(monthVAl);
		List<Order> orders = orderService.getOrdersForMonth(monthVAl);
		
		for(Order o : orders) {
			System.out.println(o.getOrderId());
		}
		
		model.addObject("orders1", orders);
		
		return model;
	}
	
	public int getMonthInt(String month) {
		switch(month) {
		case "jan":return 1;
		case "feb":return 2;
		case "mar":return 3;
		case "apr":return 4;
		case "may":return 5;
		case "jun":return 6;
		case "jul":return 7;
		case "aug":return 8;
		case "sep":return 9;
		case "oct":return 10;
		case "nov":return 11;
		case "dec":return 12;
		default:return 0;
		}			
	}
	
	@RequestMapping(value = "/searchCompleteOrders", method=RequestMethod.POST)
	public ModelAndView searchStatus(@RequestParam("status") int orderId, Model model) {
		ModelAndView mv = new ModelAndView("OrderManage/SearchedResults");
		Order ord = orderService.getOrderById(orderId);
		Customer cus = csi.getCustomer(ord.getCustomerId());
		mv.addObject("order", ord);
		mv.addObject("customer", cus);
		return mv;
	}
	
}

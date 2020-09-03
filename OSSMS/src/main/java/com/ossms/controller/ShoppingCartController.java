package com.ossms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.ShoppingCart;
import com.ossms.service.CartService;
import com.ossms.service.CartServiceImpl;

@Controller
public class ShoppingCartController {
	
	CartService cs = new CartServiceImpl();
	
	@RequestMapping(value = "/cart")
	public ModelAndView shoppingCartPage() {
		ModelAndView mv = new ModelAndView();
		//List<ShoppingCart> userCart = cs.getAll();
		mv.setViewName("ShoppingCart/ShoppingCart");
		//mv.addObject("userCart", userCart);
		
		return mv;
	}
	
	@GetMapping(value = "/userpay")
	public String userPaymentPage() {
		return "ShoppingCart/UserPayment";
	}
	
	@GetMapping(value = "/changeAddress")
	public String changeAddressPage() {
		return "ShoppingCart/ChangeUserAddress";
	}
	
	@GetMapping(value = "/pastOrders")
	public String previousOrdersPage() {
		return "ShoppingCart/PreviousOrders";
	}
	
	@GetMapping(value = "/detailedBill")
	public String BillDetailsPage() {
		return "ShoppingCart/DetailedBill";
	}

	
}


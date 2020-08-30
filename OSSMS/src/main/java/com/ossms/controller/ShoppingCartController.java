package com.ossms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {
	@GetMapping(value = "/cart")
	public String shoppingCartPage() {
		return "ShoppingCart/ShoppingCart";
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


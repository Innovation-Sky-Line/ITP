package com.ossms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.CartItems;
import com.ossms.model.Product;
import com.ossms.model.ShoppingCart;
import com.ossms.repository.ProductRepository;
import com.ossms.service.CartService;
import com.ossms.service.CartServiceImpl;
import com.ossms.service.ProductService;

@Controller
public class ShoppingCartController {
	@Autowired
	ProductService ps = new ProductService();
	@Autowired
	CartServiceImpl cs = new CartServiceImpl();
	
	@GetMapping(value = "/cart")
	public ModelAndView shoppingCartPage() {
		ModelAndView mv = new ModelAndView();
		float cartTotal = 0;
		//getting orderId from session
		int orderId = 1;
		List<ShoppingCart> carts = cs.getItemsInCart(orderId);
		List<Product> prods = new ArrayList<Product>();
		List<CartItems> userCart = new ArrayList<CartItems>();
		for(ShoppingCart cart: carts) {
			int prodId = cart.getProductId();
			int qty = cart.getQty();
			Optional<Product> prod = ps.getProdById(prodId);
			String name = prod.get().getProductName();
			float disc = prod.get().getDiscount();
			float finalPrice = ((100 - disc) * prod.get().getPrice()) / 100;
			float total = finalPrice * qty;
			
			CartItems cartItem = new CartItems(orderId, prodId, name, qty, total);
			userCart.add(cartItem);			
		}
		for(CartItems items: userCart) {
			cartTotal += items.getPrice();
		}
		mv.setViewName("ShoppingCart/ShoppingCart");
		mv.addObject("cartId", carts);	//adding the actual cart
		mv.addObject("userCart", userCart);	//adding products in cart
		mv.addObject("total", cartTotal);	//adding the total
		
		return mv;
	}
	
	@RequestMapping(value = "/increment")
	public ModelAndView incrementProduct(@RequestParam int orderId, @RequestParam int prodId) {
		ShoppingCart newCart = cs.getCartItem(orderId, prodId);
		newCart.setQty(newCart.getQty() + 1);
		cs.saveOrUpdate(newCart);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cart");
		
		return mv;
	}
	
	@RequestMapping(value = "/userpay")
	public ModelAndView userPaymentPage(@RequestParam(value = "total", required = false) float total) {
		ModelAndView mv = new ModelAndView("ShoppingCart/UserPayment");
		mv.addObject("totalPrice", total);
		return mv;
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


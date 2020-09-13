package com.ossms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.CartItems;
import com.ossms.model.Order;
import com.ossms.model.PastOrder;
import com.ossms.model.Payment;
import com.ossms.model.Product;
import com.ossms.model.ShoppingCart;
import com.ossms.repository.ProductRepository;
import com.ossms.service.CartService;
import com.ossms.service.CartServiceImpl;
import com.ossms.service.CustomerServiceImpl;
import com.ossms.service.OrderServiceImpl;
import com.ossms.service.PaymentServiceImpl;
import com.ossms.service.ProductService;

@Controller
public class ShoppingCartController {
	@Autowired
	ProductService ps = new ProductService();
	@Autowired
	CartServiceImpl cs = new CartServiceImpl();
	@Autowired
	OrderServiceImpl ods = new OrderServiceImpl();
	@Autowired
	PaymentServiceImpl pm = new PaymentServiceImpl();
	@Autowired
	CustomerServiceImpl csi = new CustomerServiceImpl();
	
	@RequestMapping(value = "/cart")
	public ModelAndView shoppingCartPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("ShoppingCart/ShoppingCart");
		List<CartItems> userCart = getCartItems((int) session.getAttribute("orderId"));
		mv.addObject("userCart", userCart);
		return mv;
	}
	
	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public ModelAndView addToCart(/*@RequestParam(value = "orderId")int orderId,*/ @RequestParam(value = "prodId")int prodId, 
			@RequestParam(value = "qty")int qty, HttpSession session) {
		ShoppingCart cart = new ShoppingCart(prodId, (int)session.getAttribute("orderId"), qty);
		
		System.out.println(cart);
		List<ShoppingCart> userCart = cs.getItemsInCart((int)session.getAttribute("orderId"));
		if(!userCart.isEmpty()) {
			for(ShoppingCart c: userCart) {
				if(cart.getProductId() == c.getProductId()) 
					incrementProduct(prodId, session);
				else {
					cs.addToCart(cart);
				}
			}
		}
		else {
			cs.addToCart(cart);
			System.out.println("added");
		}	
		return shoppingCartPage(session);
	}
	
	public List<CartItems> getCartItems(int orderId) {
		ModelAndView model = new ModelAndView();
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
			CartItems cartItem = new CartItems(prodId, orderId, name, qty, total);
			userCart.add(cartItem);			
		}				
		return userCart;
	}
	
	@RequestMapping(value = "/incrementCart")
	public ModelAndView incrementProduct(/*@RequestParam(value="orderId") int orderId,*/
			@RequestParam(value="prodId") int prodId, HttpSession session) {
		ShoppingCart newCart = cs.getCartItem((int)session.getAttribute("orderId"), prodId);
		newCart.setQty(newCart.getQty() + 1);
		cs.saveOrUpdate(newCart);
		System.out.println(newCart);		
		
		return shoppingCartPage(session);
	}
	
	@RequestMapping(value = "/decrementCart")
	public ModelAndView decrementProduct(/*@RequestParam(value="orderId") int orderId,*/
			@RequestParam(value="prodId") int prodId, HttpSession session) {
		ShoppingCart newCart = cs.getCartItem((int)session.getAttribute("orderId"), prodId);
		if(newCart.getQty() > 1) {
			newCart.setQty(newCart.getQty() - 1);
			cs.saveOrUpdate(newCart);
			return shoppingCartPage(session);
		}
		else 
			return deleteCartItem(prodId, session);
	}
	
	@RequestMapping(value = "/userpay")
	public ModelAndView userPaymentPage(@RequestParam(value = "total", required = false) float total,
			@RequestParam(value = "orderId", required = false) int orderId) {
		int userId = 1;
		String address = csi.getAddressById(userId);
		LocalDate currentDate = LocalDate.now();
		ModelAndView mv = new ModelAndView("ShoppingCart/UserPayment");
		mv.addObject("totalPrice", total);
		mv.addObject("orderId", orderId);
		mv.addObject("address", address);
		return mv;
	}
	@RequestMapping(value = "/cusPayment")
	public ModelAndView cusPayment(@RequestParam(value = "total", required = false) float total,
			@RequestParam(value = "orderId") int orderId, @RequestParam(value = "address", required = false) String address) {
		
		LocalDate currentDate = LocalDate.now();
		Payment payment = new Payment(currentDate, total, "Credit", orderId);
		pm.makePayment(payment);
		Order order = ods.getOrderById(orderId).get();
		
		if(address == null) 
			address = csi.getAddressById(1);	//change to get userId from session
		
		order.setStatus("Processing");
		order.setDeliveryAddress(address);
		ods.saveOrder(order);
		
		//create new order then set it into session
		
		return previousOrdersPage();
	}
	
	@RequestMapping(value = "/deleteCartItem")
	public ModelAndView deleteCartItem(/*@RequestParam(value="orderId") int orderId,*/
			@RequestParam(value="prodId") int prodId,  HttpSession session) {
		ShoppingCart newCart = cs.getCartItem((int)session.getAttribute("orderId"), prodId);
		cs.deleteItemFromCart(newCart);
		
		return shoppingCartPage(session);
	}
	
	@RequestMapping(value = "/changeAddress")
	public String changeAddressPage() {
		return "ShoppingCart/ChangeUserAddress";
	}
	
	@RequestMapping(value = "/pastOrders")
	public ModelAndView previousOrdersPage() {
		ModelAndView mv = new ModelAndView("ShoppingCart/PreviousOrders");
		float total = 0;
		List<Order> orders = ods.getPreviousOrders(1);
		List<PastOrder> preOrders = new ArrayList<PastOrder>();
		for(Order porders : orders) {
			total = pm.findPaymentByOrderId(porders.getOrderId()).getAmount();
			PastOrder paOrd = new PastOrder(porders, total);
			preOrders.add(paOrd);
		}
		mv.addObject("pastOrders", preOrders);
		return mv;
	}
	
	@RequestMapping(value = "/detailedBill", method = RequestMethod.POST)
	public ModelAndView billDetailsPage(@RequestParam(value = "orderId") int id, ModelAndView model) {
		model.setViewName("ShoppingCart/DetailedBill");
		List<CartItems> userCart = getCartItems(id);
		model.addObject("userCart", userCart);
		return model;
	}
	
	@RequestMapping(value="/home")
	public ModelAndView allProds(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ShoppingCart/ProdsPage");
		session.setAttribute("orderId", 1);
		List<Product> allProds = ps.getProd();
		mv.addObject("prods", allProds);
		//mv.addObject("order", 2);
		return mv; 	
	}
	
	@RequestMapping(value="/search")
	public ModelAndView searchResults(@RequestParam(value = "search")String prodName) {
		ModelAndView mv = new ModelAndView("ShoppingCart/ProductSearchResults");
		List<Product> allProds = ps.findProductsByName(prodName);
		
		if(!allProds.isEmpty()) {
			mv.addObject("prods", allProds);			
			return mv;
		}
		else {
			mv.setViewName("ShoppingCart/Error");
			return mv;
		}
		
	}

	
}


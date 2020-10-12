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
import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;
import com.ossms.model.ShoppingCart;
import com.ossms.model.Supplier;
import com.ossms.repository.ProductRepository;
import com.ossms.service.CartService;
import com.ossms.service.CartServiceImpl;
import com.ossms.service.CustomerServiceImplementation;
import com.ossms.service.OrderServiceImpl;
import com.ossms.service.PaymentServiceImpl;
import com.ossms.service.ProductService;
import com.ossms.service.ProductsServiceImp;

@Controller
public class ShoppingCartController {
	@Autowired
	ProductService ps = new ProductsServiceImp();
	@Autowired
	CartServiceImpl cs = new CartServiceImpl();
	@Autowired
	OrderServiceImpl ods = new OrderServiceImpl();
	@Autowired
	PaymentServiceImpl pm = new PaymentServiceImpl();
	@Autowired
	CustomerServiceImplementation csi = new CustomerServiceImplementation();
	
	@RequestMapping(value = "/cart")
	public ModelAndView shoppingCartPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("ShoppingCart/ShoppingCart");
		List<CartItems> userCart = getCartItems((int) session.getAttribute("orderId"));
		mv.addObject("userCart", userCart);

		return mv;
	}
	
	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public ModelAndView addToCart(/*@RequestParam(value = "orderId")int orderId,*/ @RequestParam(value = "prodId")int prodId, 
			HttpSession session) {
		ShoppingCart cart = new ShoppingCart(prodId, (int)session.getAttribute("orderId"), 1);
		
		System.out.println(cart);
		List<ShoppingCart> userCart = cs.getItemsInCart((int)session.getAttribute("orderId"));
		if(!userCart.isEmpty()) {
			for(ShoppingCart c: userCart) {
				if(c.getProductId() == prodId) {
					incrementProduct(prodId, session);
					return productHome(session);
				}
				cs.addToCart(cart);
			}
		}
		else {
			cs.addToCart(cart);
			System.out.println("added");
		}	
		return productHome(session);
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
		if(session.getAttribute("orderId") != null) {
			List<ShoppingCart> cart = cs.getItemsInCart((int) session.getAttribute("orderId"));
			model.addObject("itemsInCart", cart.size());
		}
		
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
			ProductModel prod = ps.getProductById(prodId);
			String name = prod.getProductName();
			float disc = prod.getDiscount();
			float finalPrice = ((100 - disc) * prod.getPrice()) / 100;
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
		@RequestParam(value = "address", required = false) String address, HttpSession session) {
		
		int orderId = (int) session.getAttribute("orderId");
		int customerId = (int) session.getAttribute("customerId");
		LocalDate currentDate = LocalDate.now();
		Payment payment = new Payment(currentDate, total, "Credit", orderId);
		pm.makePayment(payment);
		Order order = ods.getOrderById(orderId);
		
		if(address == null) 
			address = csi.getAddressById(customerId);	//change to get userId from session
		
		order.setStatus("Processing");
		order.setDate(currentDate);
		order.setDeliveryAddress(address);
		ods.saveOrder(order);
		
		List<CartItems> cartItems = this.getCartItems(orderId);	//to update the stocks of products
		for(CartItems c : cartItems) {
			ProductModel product = ps.getProductById(c.getProdId());
			product.setCurrentStock(product.getCurrentStock() - c.getQty());
		}
		
		//create new order then set it into session
		Order newOrder = new Order(customerId);
		newOrder.setStatus("Not Filled");
		newOrder.setDeliveryStatus("Not Delivered");
		ods.saveOrder(newOrder);	
		session.setAttribute("orderId", newOrder.getOrderId());
		
		return list(session);	//change to pending orders page
	}
	//--from Asanka
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpSession session) {
		
		ModelAndView model = new ModelAndView("CusManage/CustomerDashbord");
		
		float total = 0;
			
		int id = (int) session.getAttribute("customerId");
		
		session.setAttribute("customerId", id );
		
		session.setAttribute("customer", csi.getCustomer(id) );
		
		List<Order> orders = ods.getPendingOrders(id);	//pass session cusId
		
		List<PastOrder> preOrders = new ArrayList<PastOrder>();
		
		for(Order porders : orders) {
			
			total = pm.findPaymentByOrderId(porders.getOrderId()).getAmount();
			PastOrder paOrd = new PastOrder(porders, total);
			preOrders.add(paOrd);
			
		}
		
		
		model.addObject("customer",csi.getCustomer(id));
		model.addObject("pending", preOrders);
		
		return model;
	}
	//--	
	
	//test method
	@RequestMapping(value="/checkNewOrder")
	public ModelAndView testNewOrder() {
		ModelAndView mv = new ModelAndView("ShoppingCart/ProdsPage");
		Order newOrder = ods.getNewOrder(1);		
		System.out.println(newOrder.getOrderId());
		return mv;
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
	public ModelAndView previousOrdersPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("ShoppingCart/PreviousOrders");
		float total = 0;
		int customerId = (int) session.getAttribute("customerId");
		List<Order> orders = ods.getPreviousOrders(customerId);	//pass session cusId
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
	
	/*@RequestMapping(value="/home")
	public ModelAndView allProds(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ShoppingCart/ProdsPage");
		List<Product> allProds = ps.getProd();
		mv.addObject("prods", allProds);
		//mv.addObject("order", 2);
		return mv; 	
	}*/
	
	@RequestMapping(value="/search")
	public ModelAndView searchResults(@RequestParam(value = "search")String prodName, HttpSession session) {
		ModelAndView mv = new ModelAndView("ShoppingCart/ProductSearchResults");
		List<ProductModel> allProds = ps.findProductsByName(prodName);
		List<ProductCategoryModel> allCategories = ps.allCategoryNames();
		mv.addObject("allCategories", allCategories);
		List<ShoppingCart> cart = cs.getItemsInCart((int) session.getAttribute("orderId"));
		mv.addObject("itemsInCart", cart.size());
		
		if(!allProds.isEmpty()) {
			mv.addObject("prods", allProds);			
		}
		else {
			mv.addObject("searchError", "Looks like we don't have what you're looking for!");
			System.out.println("Fail");
		}
		return mv;
		
	}
	
}


package com.ossms.service;

import java.util.List;

import com.ossms.model.Product;
import com.ossms.model.ShoppingCart;

public interface CartService {

	public List<ShoppingCart> getItemsInCart(int orderId);
	
	public void saveOrUpdate(ShoppingCart shoppingcart);
	
	public void deleteItemFromCart(ShoppingCart shoppingcart);
	
	public List<ShoppingCart> getAll();
	
	public ShoppingCart getCartItem(int orderId, int prodId);
	
	public void addToCart(ShoppingCart shoppingcart);
	
}

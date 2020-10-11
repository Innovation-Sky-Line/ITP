package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.ShoppingCart;
import com.ossms.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public List<ShoppingCart> getItemsInCart(int orderId) {
		return cartRepo.findItemsInCart(orderId);
	}

	@Override
	public void saveOrUpdate(ShoppingCart shoppingcart) {
		cartRepo.save(shoppingcart);
	}

	@Override
	public void deleteItemFromCart(ShoppingCart shoppingcart) {
		cartRepo.delete(shoppingcart);
	}

	@Override
	public List<ShoppingCart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getCartItem(int orderId, int prodId) {
		return cartRepo.getSpecificItem(orderId, prodId);
	}

	@Override
	public void addToCart(ShoppingCart shoppingcart) {
		cartRepo.save(shoppingcart);	
	}

}

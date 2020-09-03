package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ossms.model.ShoppingCart;
import com.ossms.repository.CartRepository;

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
	
	public List<ShoppingCart> getAll(){
		return (List<ShoppingCart>) cartRepo.findAll();
	}

}

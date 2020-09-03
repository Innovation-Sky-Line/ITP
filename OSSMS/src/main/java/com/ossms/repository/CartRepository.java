package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.CartId;
import com.ossms.model.ShoppingCart;

public interface CartRepository extends CrudRepository<ShoppingCart, CartId>{

	@Query(value="SELECT * FROM ShoppingCart WHERE cusOrderId = :orderId", nativeQuery = true)
	List<ShoppingCart> findItemsInCart(@Param("orderId") int cartId);
}

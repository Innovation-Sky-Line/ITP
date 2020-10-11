package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ossms.model.CartId;
import com.ossms.model.ShoppingCart;
@Repository
public interface CartRepository extends CrudRepository<ShoppingCart, CartId>{

	@Query(value="SELECT * FROM shoppingcart WHERE cusOrderId = :orderId", nativeQuery = true)
	List<ShoppingCart> findItemsInCart(@Param("orderId") int cartId);
	
	@Query(value="SELECT * FROM shoppingcart WHERE cusOrderId = :orderId and productId = :prodId", nativeQuery = true)
	ShoppingCart getSpecificItem(@Param("orderId") int orderId, @Param("prodId") int productId);
}

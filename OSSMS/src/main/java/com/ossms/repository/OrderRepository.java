package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query(value="SELECT * FROM orders WHERE customerId = 1 AND deliveryStatus LIKE 'Delivered'", nativeQuery = true)
	List<Order> getPreviousOrders(@Param("cusId") int cusId);
}

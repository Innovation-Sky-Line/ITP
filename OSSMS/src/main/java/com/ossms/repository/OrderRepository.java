package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ossms.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	@Query(value="SELECT * FROM orders WHERE deliveryStatus = 'Delivered'", nativeQuery = true)
	List<Order> findCompletedDeliveries();
	
	@Query(value ="select * from orders where status like %?1%", nativeQuery = true)
    List<Order> searchStatus(String status);
	
	@Query(value ="SELECT customerId FROM `orders` where idOrder = :id ", nativeQuery = true)
    int getCustomerId(int id);
	
	@Query(value ="SELECT idOrder FROM `orders` where customerId = :? ", nativeQuery = true)
    int getOrderId(int id);
	
	@Query(value="SELECT * FROM orders WHERE status = 'Filled' AND "
			+ "deliveryStatus='Incomplete'", nativeQuery = true)
	List<Order> findIncompletedDeliveries();
	
	List<Order> findOrderByDeliveryStatusContaining(String status); 
}

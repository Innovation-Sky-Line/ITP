package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query(value="SELECT * FROM orders WHERE customerId = :cusId AND deliveryStatus LIKE 'Delivered'", nativeQuery = true)
	List<Order> getPreviousOrders(@Param("cusId") int cusId);
	
	@Query(value="SELECT * FROM orders WHERE MONTH(date) = :orderMonth", nativeQuery = true)
	List<Order> findOrdersForMonth(@Param("orderMonth")int month);
	
	@Query(value="SELECT * FROM orders WHERE status = 'Not Filled' AND customerId = :cusId", nativeQuery = true)
	Order getNewOrder(@Param("cusId") int customerId);
	
	@Query(value="SELECT * FROM orders WHERE customerId=:idCustomer AND status IN ('Processing', 'Filled') "
			+ "AND deliveryStatus = 'Not Delivered'", nativeQuery = true)
	List <Order> getPendingOrders(@Param("idCustomer") int idCustomer);	

	@Query(value="SELECT * FROM orders WHERE status = 'Complete'", nativeQuery = true)
	List<Order> findCompletedOrders();
	
	@Query(value="SELECT * FROM orders WHERE status = 'Processing'", nativeQuery = true)
	List<Order> findIncompletedOrders();	
	
	@Query(value ="select * from orders where status like %?1%", nativeQuery = true)
    List<Order> searchStatus(String status);	
	
}

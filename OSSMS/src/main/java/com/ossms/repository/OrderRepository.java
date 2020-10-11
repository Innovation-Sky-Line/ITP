package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ossms.model.Order;
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
	@Query(value="SELECT * FROM orders WHERE status = 'Complete'", nativeQuery = true)
	List<Order> findCompletedOrders();
	
	@Query(value="SELECT * FROM orders WHERE status = 'Processing'", nativeQuery = true)
	List<Order> findIncompletedOrders();

	@Query(value="SELECT * FROM orders WHERE MONTH(date) = :orderMonth", nativeQuery = true)
	List<Order> findOrdersForMonth(@Param("orderMonth")int month);
	
	
	@Query(value ="select * from orders where status like %?1%", nativeQuery = true)
    List<Order> searchStatus(String status);
	
	
	
	
}

package com.ossms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ossms.model.Delivery;
import com.ossms.model.OrderDeliveryId;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, OrderDeliveryId>{

	@Query(value="SELECT * FROM orderdelivery WHERE orderId = :orderId", nativeQuery = true)
	Delivery findDelivery(int orderId);
}

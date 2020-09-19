package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ossms.model.ProductCategoryModel;
import com.ossms.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer>{
	@Query(value = "SELECT * FROM supplier order by supplierName ASC", nativeQuery = true)
	List<Supplier> allSupplierNames();
	
	@Query(value = "SELECT idSupplier FROM supplier order by supplierName ASC", nativeQuery = true)
	List<Integer> allSupplierIds();
	
	@Query(value = "SELECT supplierName FROM supplier", nativeQuery = true)
	List<String> getSupName();

}
package com.ossms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ossms.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
	@Query(value ="select * from supplier where supplierName like %?1%", nativeQuery = true)
    List<Supplier> searchSupplier(String name);
}

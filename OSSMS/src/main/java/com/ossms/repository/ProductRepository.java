package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer>{

//	@Query(value = "select p.idProduct, p.productName, p.price, p.discount, p.currentStock, p.supplierId, s.supplierName, p.categoryId, c.categoryName, p.buyingLimit from category c, supplier s, product p where p.supplierId = s.idSupplier and p.categoryId = c.idCategory", nativeQuery = true) 
//	List<String> listProductInfo();
	 @Query(value ="select * from product where productName like %?1%", nativeQuery = true)
	    List<ProductModel> searchProduct(String name);
}

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
	 
	 @Query(value ="select * from product where currentStock < 51", nativeQuery = true)
	    List<ProductModel> getInsufficientProducts();
	 
	 @Query(value ="select * from product where discount > 0", nativeQuery = true)
	    List<ProductModel> getDiscountProducts();
	 
	 @Query(value ="SELECT * FROM product WHERE idProduct=(SELECT max(idProduct) FROM product)", nativeQuery = true)
	    List<ProductModel> getLastProduct();
	 @Query(value ="select * from product order by idProduct DESC", nativeQuery = true)
	 List<ProductModel> productList();
	 
	 @Query(value ="select productImage from product where idProduct = :id", nativeQuery = true)
	 String getImage(int id);
	 
	 
}

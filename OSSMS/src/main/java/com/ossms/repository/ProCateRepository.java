package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.ProductCategoryModel;

public interface ProCateRepository extends CrudRepository<ProductCategoryModel, Integer> {
	@Query(value = "SELECT categoryName FROM category order by categoryName ASC", nativeQuery = true)
	List<String> allCategoryNames();
	
	@Query(value = "SELECT categoryName FROM category WHERE mainCategoryId IS NULL order by categoryName ASC", nativeQuery = true)
	List<String> mainCategoryNames();
	
	@Query(value =  "SELECT categoryName FROM category WHERE mainCategoryId IS NOT NULL ORDER BY categoryName ASC", nativeQuery = true)
	List<String> subCategoryNames();
	
	@Query(value = "SELECT idCategory FROM category WHERE categoryName LIKE :firstName", nativeQuery = true)
	Integer getCategoryIdBy(@Param("firstName") String firstName);
	
	
	
}

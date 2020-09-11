package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ossms.model.ProductCategoryModel;

public interface ProCateRepository extends CrudRepository<ProductCategoryModel, Integer> {
//	@Query(value = "SELECT categoryName FROM category order by categoryName ASC")
//	List<ProductCategoryModel> allCategoryNames();
	
//	@Query(value = "SELECT categoryName FROM category WHERE mainCategoryId IS NULL order by categoryName ASC")
//	List<ProductCategoryModel> mainCategoryNames();
//	
//	@Query(value =  "SELECT categoryName FROM category WHERE mainCategoryId IS NOT NULL order by categoryName ASC")
//	List<ProductCategoryModel> subCategoryNames();
	
}

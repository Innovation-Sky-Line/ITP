package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ossms.model.ProductCategoryModel;

public interface ProCateRepository extends JpaRepository<ProductCategoryModel, Integer> {
	@Query(value = "SELECT categoryName FROM category order by categoryName ASC", nativeQuery = true)
	List<String> allCategoryNames();
	
	@Query(value = "SELECT * FROM category WHERE mainCategoryId IS NULL order by categoryName ASC", nativeQuery = true)
	List<ProductCategoryModel> mainCategoryNames();
	
	@Query(value =  "SELECT categoryName FROM category WHERE mainCategoryId IS NOT NULL ORDER BY categoryName ASC", nativeQuery = true)
	List<String> subCategoryNames();
	
	@Query(value = "SELECT idCategory FROM category WHERE categoryName LIKE :firstName", nativeQuery = true)
	Integer getCategoryIdBy(@Param("firstName") String firstName);
	
//	@Query(value = "SELECT categoryName FROM category WHERE idCategory :id AND  ", nativeQuery = true)
//	String getCname(@Param("id") int id);
	
}

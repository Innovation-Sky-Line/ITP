package com.ossms.dao;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.ProductCategoryModel;


public interface ProCategoryDao extends CrudRepository<ProductCategoryModel, Integer>{
	
}

package com.ossms.dao;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.ProductModel;

public interface ProductDao extends CrudRepository<ProductModel, Integer> {

}

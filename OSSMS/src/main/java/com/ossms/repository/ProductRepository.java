package com.ossms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer>{

}

package com.ossms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ossms.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findProductByProductNameContaining(String name);

}

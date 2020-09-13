package com.ossms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ossms.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findProductByProductNameContaining(String name);
}

package com.ossms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ossms.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

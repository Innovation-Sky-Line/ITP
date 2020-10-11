package com.ossms.service;

import java.util.Optional;

import com.ossms.model.Product;

public interface ProductService {
	public Optional<Product> getProdById(int id);
	

}

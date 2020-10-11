package com.ossms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ossms.model.Product;
import com.ossms.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository pr;
	
	public List<Product> getProd(){
		return (List<Product>) pr.findAll();
	}
	
	public Optional<Product> getProdById(int id) {
		return pr.findById(id);
	}
	
	public List<Product> findProductsByName(String prodName){
		return pr.findProductByProductNameContaining(prodName);
	}



}

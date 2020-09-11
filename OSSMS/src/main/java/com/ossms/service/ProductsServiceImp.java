package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossms.dao.ProCategoryDao;
import com.ossms.dao.ProductDao;
import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;
import com.ossms.repository.ProCateRepository;
import com.ossms.repository.ProductRepository;



@Service
@Transactional
public class ProductsServiceImp implements ProductService{

	@Autowired
	ProductRepository repository;
	@Autowired
	ProCateRepository proCateRepository;

	@Override
	public List<ProductModel> getAllproducts() {
		return (List<ProductModel>) repository.findAll();
	}
	@Override
	public List<ProductCategoryModel> getAllcategories() {
		return (List<ProductCategoryModel>) proCateRepository.findAll();
	}


	@Override
	public ProductModel getProductById(int id) {
		return repository.findById(id).get();
	}
	@Override
	public ProductCategoryModel getCategoryById(int id) {
		return proCateRepository.findById(id).get();
	}
	

	@Override
	public void saveOrUpdate(ProductModel products) {
		repository.save(products);
		
	}

	@Override
	public void saveOrUpdate(ProductCategoryModel category) {
		proCateRepository.save(category);
		
	}

	@Override
	public void deleteProduct(int id) {
		repository.deleteById(id);
		
	}
	@Override
	public void deleteCategory(int id) {
		proCateRepository.deleteById(id);
		
	}
	
	
	
//	@Override
//	public List<ProductCategoryModel> allCategoryNames() {
//		
//		return (List<ProductCategoryModel>) proCateRepository.allCategoryNames();
//	}

	


}

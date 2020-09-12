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
import com.ossms.repository.SupplierRepository;



@Service
@Transactional
public class ProductsServiceImp implements ProductService{

	@Autowired
	ProductRepository repository;
	@Autowired
	ProCateRepository proCateRepository;
	@Autowired
	SupplierRepository supplierRepository;

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
	
	
	
	@Override
	public List<String> allCategoryNames() {
		
		return (List<String>) proCateRepository.allCategoryNames();
	}
	@Override
	public List<String> subCategoryNames() {
		return (List<String>) proCateRepository.subCategoryNames();
	}
	@Override
	public List<String> mainCategoryNames() {
		return (List<String>) proCateRepository.mainCategoryNames();
	}
	@Override
	public Integer getCategoryIdBy(String firstName) {
		return proCateRepository.getCategoryIdBy(firstName);
		
	}

	
	
	
	
	
	@Override
	public List<String> allSupplierNames() {
		return (List<String>) supplierRepository.allSupplierNames();
	}
	@Override
	public List<Integer> allSupplierIds() {
		return (List<Integer>) supplierRepository.allSupplierIds();
	}
	
	


}

package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductList;
import com.ossms.model.ProductModel;
import com.ossms.model.Supplier;
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
	
	
//	public List<String> listProductInfo(){
//		return pListRepo.listProductInfo();
//	}
	

	@Override
	public List<ProductModel> getAllproducts() {
		return (List<ProductModel>) repository.findAll();
	}
	@Override
	public List<ProductModel> getLastProduct() {
		return repository.getLastProduct();
	}
	@Override
	public List<ProductModel> productList() {
		return repository.productList();
	}
	@Override
	public List<ProductCategoryModel> mainCategories() {
		return proCateRepository.mainCategories();
	}
	@Override
	public String getImage(int id) {
		return repository.getImage(id);
	}
	
	
	@Override
	public List<ProductCategoryModel> getAllcategories() {
		return (List<ProductCategoryModel>) proCateRepository.findAll();
	}
	@Override
	public List<ProductCategoryModel> getLastCate() {
		return proCateRepository.getLastCate();
	}
	public List <ProductCategoryModel> cateList() {
		return proCateRepository.cateList();
	}
	
	
	
	public List<Supplier> getAllSuppliers(){
		return (List<Supplier>) supplierRepository.findAll();
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
	public List<ProductCategoryModel> allCategoryNames() {
		
		return proCateRepository.allCategoryNames();
	}
	@Override
	public List<ProductCategoryModel> subCategoryNames() {
		return proCateRepository.subCategoryNames();
	}
	@Override
	public List<ProductCategoryModel> mainCategoryNames() {
		return proCateRepository.mainCategoryNames();
	}
	@Override
	public Integer getCategoryIdBy(String firstName) {
		return proCateRepository.getCategoryIdBy(firstName);
		
	}

	
	
	
	
	
	@Override
	public List<Supplier> allSupplierNames() {
		return supplierRepository.allSupplierNames();
	}
	@Override
	public List<Integer> allSupplierIds() {
		return (List<Integer>) supplierRepository.allSupplierIds();
	}
	
	

	public List<ProductModel> searchProduct(String name){
		return repository.searchProduct(name);
	}
	 public List<ProductCategoryModel> searchCategory(String name){
		 return proCateRepository.searchCategory(name);
	 }
	 
	 
	@Override
	public List<String> getCategoryName() {
		return proCateRepository.getCategoryName();
	}
	@Override
	public List<String> getSupName() {
		return supplierRepository.getSupName();
	}
	@Override
	public Supplier getSupplierById(int id) {
		return supplierRepository.findById(id).get();
	}
	
	
	
	@Override
	public List<ProductModel> getInsufficientProducts() {
		return repository.getInsufficientProducts();
	}
	@Override
	public List<ProductModel> getDiscountProducts() {
		return repository.getDiscountProducts();
	}
	
	
	
	
	


}

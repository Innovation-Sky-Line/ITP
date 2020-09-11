package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossms.dao.ProCategoryDao;
import com.ossms.dao.ProductDao;
import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;



@Service
@Transactional
public class ProductsServiceImp implements ProductService{

	@Autowired
	ProductDao productDao;
	@Autowired
	ProCategoryDao proCategoryDao;

	@Override
	public List<ProductModel> getAllproducts() {
		return (List<ProductModel>) productDao.findAll();
	}
	@Override
	public List<ProductCategoryModel> getAllcategories() {
		return (List<ProductCategoryModel>) proCategoryDao.findAll();
	}


	@Override
	public ProductModel getProductById(int id) {
		return productDao.findById(id).get();
	}
	@Override
	public ProductCategoryModel getCategoryById(int id) {
		return proCategoryDao.findById(id).get();
	}
	

	@Override
	public void saveOrUpdate(ProductModel products) {
		productDao.save(products);
		
	}

	@Override
	public void saveOrUpdate(ProductCategoryModel category) {
		proCategoryDao.save(category);
		
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteById(id);
		
	}
	@Override
	public void deleteCategory(int id) {
		proCategoryDao.deleteById(id);
		
	}

	


}

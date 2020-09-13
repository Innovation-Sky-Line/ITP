package com.ossms.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ossms.model.ProductCategoryModel;
import com.ossms.model.*;


public interface ProductService {
	public List<ProductModel> getAllproducts();
	public List<ProductCategoryModel> getAllcategories();

	public ProductModel getProductById(int id);
	public ProductCategoryModel getCategoryById(int id);

	public void saveOrUpdate(ProductModel products);
	public void saveOrUpdate(ProductCategoryModel category);

	public void deleteProduct(int id);
	public void deleteCategory(int id);
	
	public List<String> allCategoryNames();
	public List<String> subCategoryNames();
	public List<ProductCategoryModel> mainCategoryNames();
	Integer getCategoryIdBy(@Param("firstName") String firstName);
	
	public List<String> allSupplierNames();
	public List<Integer> allSupplierIds();

}

package com.ossms.service;

import java.util.List;

import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;


public interface ProductService {
	public List<ProductModel> getAllproducts();
	public List<ProductCategoryModel> getAllcategories();

	public ProductModel getProductById(int id);
	public ProductCategoryModel getCategoryById(int id);

	public void saveOrUpdate(ProductModel products);
	public void saveOrUpdate(ProductCategoryModel category);

	public void deleteProduct(int id);
	public void deleteCategory(int id);
}

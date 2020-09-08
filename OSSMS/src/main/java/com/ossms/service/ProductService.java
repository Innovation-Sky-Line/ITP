package com.ossms.service;

import java.util.List;

import com.ossms.model.ProductModel;


public interface ProductService {
	public List<ProductModel> getAllproducts();

	public ProductModel getProductById(int id);

	public void saveOrUpdate(ProductModel products);

	public void deleteProduct(int id);
}

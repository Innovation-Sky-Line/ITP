package com.ossms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ossms.model.Product;
import com.ossms.repository.ProductRepository;

@Service
public class ProductService{

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
	
	public void updateProduct(Product product) {
		pr.save(product);
	}
}
package com.ossms.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ossms.model.*;


public interface ProductService {
	
	//public List<String> listProductInfo();
	
	public boolean existsByProductName(String pName);
	
	public List<ProductModel> getAllproducts();
	public List<ProductModel> getLastProduct();
	public List<ProductModel> productList();
	public String getImage(int id);
	
	public List<ProductCategoryModel> getAllcategories();
	public List<ProductCategoryModel> getLastCate();
	public List<ProductCategoryModel> cateList();
	
	public List<Supplier> getAllSuppliers();
	
	
	public Supplier getSupNamebyId(int id);
	public ProductCategoryModel cateNameById(Integer ID);

	public ProductModel getProductById(int id);
	public ProductCategoryModel getCategoryById(int id);

	public void saveOrUpdate(ProductModel products);
	public void saveOrUpdate(ProductCategoryModel category);

	public void deleteProduct(int id);
	public void deleteCategory(int id);
	
	public Supplier getSupplierById(int id);
	
	public List<ProductCategoryModel> allCategoryNames();
	public List<ProductCategoryModel> subCategoryNames();
	public List<ProductCategoryModel> mainCategoryNames();
	public List<ProductCategoryModel> mainCategories();
	public Integer getCategoryIdBy(@Param("firstName") String firstName);
	
	
	public List<Supplier> allSupplierNames();
	public List<Integer> allSupplierIds();
	
	public List<ProductCategoryModel> searchCategory(String name);
	List<ProductModel> searchProduct(String name);
	
	public List<String> getCategoryName();
	public List<String> getSupName();
	
	
	public List<ProductModel> getInsufficientProducts();
	public List<ProductModel> getDiscountProducts();
	
	public List<Product> findProductsByName(String prodName);
	

}

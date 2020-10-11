package com.ossms.model;

public class ProductList {

	private ProductModel productModel;
	private ProductCategoryModel categoryModel;
	private Supplier supplier;

	public ProductList(ProductModel productModel, ProductCategoryModel categoryModel, Supplier supplier) {
		super();
		this.productModel = productModel;
		this.categoryModel = categoryModel;
		this.supplier = supplier;
	}

	public ProductList() {
		super();
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public ProductCategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(ProductCategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "ProductList [productModel=" + productModel + ", categoryModel=" + categoryModel + ", supplier="
				+ supplier + "]";
	}

}

package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;




@Entity
@Component
@Table(name = "category")
public class ProductCategoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategory")
	private int idCategory;
	@Column(name = "categoryname")
	private String categoryName;
	@Column(name = "maincategoryid")
	private Integer mainCategoryId;
	
	

	public ProductCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	



	public ProductCategoryModel(int idCategory, String categoryName, Integer mainCategoryId) {
		super();
		this.idCategory = idCategory;
		this.categoryName = categoryName;
		this.mainCategoryId = mainCategoryId;
	}







	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getMainCategoryId() {
		return mainCategoryId;
	}
	public void setMainCategoryId(Integer mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}



	@Override
	public String toString() {
		return "ProductCategoryModel [idCategory=" + idCategory + ", categoryName=" + categoryName + ", mainCategoryId="
				+ mainCategoryId + "]";
	}
	
	
}

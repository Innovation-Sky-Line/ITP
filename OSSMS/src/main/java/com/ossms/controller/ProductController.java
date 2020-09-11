package com.ossms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductModel;
import com.ossms.service.ProductService;


@Controller
@RequestMapping(value = "/padmin")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/proManage")
	public ModelAndView addProducts() {
		ModelAndView model = new ModelAndView("ProManage/Padmin");
		ProductModel product = new ProductModel();
		model.addObject("productForm", product);
		return model;
	}
	
	@RequestMapping(value = "/CateManage")
	public ModelAndView addCategory() {
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		ProductCategoryModel category = new ProductCategoryModel();
		model.addObject("categoryForm", category);
		return model;
	}
//	@GetMapping("/")
//	public String allCategories(@ModelAttribute("category") ProductCategoryModel productCategoryModel, Model model) {
//		List<ProductCategoryModel> categoriesCategoryModels = productService.allCategoryNames();
//		return "ProManage/CateManage";
//		
//	}
//	
//	@ModelAttribute("allCategories")
//	 public List<ProductCategoryModel> allCategories() {
//	      List<ProductCategoryModel> allCategories = productService.allCategoryNames();
//	      return allCategories;
//	   } 
//	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	 public ModelAndView addProduct(ProductModel product) {
	  ModelAndView model = new ModelAndView();
	  productService.saveOrUpdate(product);
	  model.setViewName("redirect:/padmin/productList");
	  
	  return model;
	 }
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	 public ModelAndView addCategory(ProductCategoryModel category) {
	  ModelAndView model = new ModelAndView();
	  productService.saveOrUpdate(category);
	  model.setViewName("redirect:/padmin/categoryList");
	  
	  return model;
	 }
	
	@RequestMapping(value = "/proAdmin")
	public ModelAndView productAdmin() {
		ModelAndView model = new ModelAndView("ProManage/Padmin");
		return model;
	}
	

	@RequestMapping(value = "/proCate")
	public ModelAndView productCategory() {
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		return model;
	}
	
	@RequestMapping(value = "/proRepo")
	public ModelAndView productReports() {
		ModelAndView model = new ModelAndView("ProManage/ProReport");
		return model;
	}
	
//	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
//	 public ModelAndView save(@ModelAttribute("productForm") ProductModel product) {
//		productService.saveOrUpdate(product);
//	  
//	  return new ModelAndView("redirect:/padmin/proAdmin");
//	 }
	
	
	@RequestMapping(value="/productList", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("ProManage/ProductList");
	  List<ProductModel> productList = productService.getAllproducts();
	  model.addObject("productList", productList);
	  
	  return model;
	 }
	
	@RequestMapping(value = "/updateProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int idProduct) {
		ModelAndView model = new ModelAndView();

		ProductModel product = productService.getProductById(idProduct);
		model.addObject("productForm", product);
		model.setViewName("ProManage/Padmin");

		return model;
	}
	
	@RequestMapping(value = "/deleteProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idProduct") int idProduct) {
		productService.deleteProduct(idProduct);

		return new ModelAndView("redirect:/padmin/productList");
	}
	
	@RequestMapping(value="/categoryList", method=RequestMethod.GET)
	 public ModelAndView cateList() {
	  ModelAndView model = new ModelAndView("ProManage/ProCateList");
	  List<ProductCategoryModel> categoryList = productService.getAllcategories();
	  model.addObject("categoryList", categoryList);
	  
	  return model;
	 }
	
	@RequestMapping(value = "/updateCategory/{idCategory}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable int idCategory) {
		ModelAndView model = new ModelAndView();
		ProductCategoryModel category = productService.getCategoryById(idCategory);
		model.addObject("categoryForm", category);
		model.setViewName("ProManage/CateManage");

		return model;
	}
	
	@RequestMapping(value = "/deleteCategory/{idCategory}", method = RequestMethod.GET)
	public ModelAndView cateDelete(@PathVariable("idCategory") int idCategory) {
		productService.deleteCategory(idCategory);

		return new ModelAndView("redirect:/padmin/categoryList");
	}
	
	
}



package com.ossms.controller;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.ProductCategoryModel;
import com.ossms.model.ProductList;
import com.ossms.model.ProductModel;
import com.ossms.model.Supplier;
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
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = productService.allCategoryNames();
		model.addObject("allCategories", allCategories);
		return model;
	}
	
	@RequestMapping(value = "/CateManage")
	public ModelAndView addCategory() {
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);
		ProductCategoryModel category = new ProductCategoryModel();
		model.addObject("categoryForm", category);

		return model;
	}
	
	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	 public ModelAndView addProduct(ProductModel product) {
	  ModelAndView model = new ModelAndView();
	  productService.saveOrUpdate(product);
	  model.setViewName("redirect:/padmin/productList2");
	  
	  return model;
	 }
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	 public ModelAndView addCategory(ProductCategoryModel category) {
	  ModelAndView model = new ModelAndView();
	  productService.saveOrUpdate(category);
	  model.setViewName("redirect:/padmin/categoryList");
	  
	  return model;
	 }
	
	@RequestMapping(value="/addCategory1", method=RequestMethod.POST)
	 public ModelAndView addCategory1(@ModelAttribute("categoryForm") ProductCategoryModel cat) {
	  ModelAndView model = new ModelAndView();
	  
	  productService.saveOrUpdate(cat);
	  model.setViewName("redirect:/padmin/categoryList");
	  
	  return model;
	 }
	
	@RequestMapping(value = "/proAdmin")
	public ModelAndView productAdmin() {
		ModelAndView model = new ModelAndView("ProManage/Padmin");
		return model;
	}
	
	@RequestMapping(value = "/php")
	public ModelAndView productHome() {
		ModelAndView model = new ModelAndView("ProManage/P_home");
		return model;
	}
	
	@RequestMapping(value = "/myProfile")
	public ModelAndView profile() {
		ModelAndView model = new ModelAndView("ProManage/myProfile");
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
	
	
	@RequestMapping(value="/productList2", method=RequestMethod.GET)
	 public ModelAndView proList() {
		ModelAndView mv = new ModelAndView("ProManage/ProductList");
		List<ProductModel> products = productService.getAllproducts();
		List<ProductList> pList = new ArrayList<ProductList>();
		for(ProductModel productModel : products) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);
			
			pList.add(list);
		}
		mv.addObject("productList", pList);
		return mv;
	}

	
	@RequestMapping(value = "/updateProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int idProduct) {
		ModelAndView model = new ModelAndView();
		ProductModel product = productService.getProductById(idProduct);
		model.addObject("productForm", product);
		List<Supplier> allSuppliers = productService.allSupplierNames();
		model.addObject("allSuppliers", allSuppliers);
		List<ProductCategoryModel> allCategories = productService.allCategoryNames();
		model.addObject("allCategories", allCategories);
		model.setViewName("ProManage/Padmin");

		return model;
	}
	
	@RequestMapping(value = "/deleteProduct/{idProduct}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idProduct") int idProduct) {
		productService.deleteProduct(idProduct);

		return new ModelAndView("redirect:/padmin/productList2");
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
		ModelAndView model = new ModelAndView("ProManage/CateManage");
		ProductCategoryModel category = productService.getCategoryById(idCategory);
		model.addObject("categoryForm", category);
		List<ProductCategoryModel> mainCategories = productService.mainCategoryNames();
		model.addObject("mainCategories", mainCategories);

		return model;
	}
	
	@RequestMapping(value = "/deleteCategory/{idCategory}", method = RequestMethod.GET)
	public ModelAndView cateDelete(@PathVariable("idCategory") int idCategory) {
		productService.deleteCategory(idCategory);

		return new ModelAndView("redirect:/padmin/categoryList");
	}
	
	
	
	@RequestMapping(value = "/searchCate", method=RequestMethod.POST)
	public ModelAndView searchCategory(@RequestParam("searchCate") String name) {
		ModelAndView mView = new ModelAndView("ProManage/SearchedCategories");
		List<ProductCategoryModel> cat = productService.searchCategory(name);
		if(!cat.isEmpty()) {
			mView.addObject("SearchedCategoryList", cat);
			return mView;
		}else {
			mView.setViewName("ProManage/Error");
			return mView;
		}
	}
	
	@RequestMapping(value = "/searchPro", method=RequestMethod.POST)
	public ModelAndView searchProduct(@RequestParam("product") String name) {
		ModelAndView mv = new ModelAndView("ProManage/SearchedProducts");
		List<ProductModel> pro = productService.searchProduct(name);
		List<ProductList> pList = new ArrayList<ProductList>();
		for(ProductModel productModel : pro) {
			ProductCategoryModel categoryModel = productService.getCategoryById(productModel.getCategoryId());
			Supplier supplier = productService.getSupplierById(productModel.getSupplierId());
			ProductList list = new ProductList(productModel, categoryModel, supplier);
			
			pList.add(list);
		}
		
		
		if(!pro.isEmpty()) {
			mv.addObject("SearchedroductList", pList);
			return mv; 
		}else {
			mv.setViewName("ProManage/Error");
			return mv;
		}
	}
	
}



package com.ossms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	 public ModelAndView addProduct(ProductModel product) {
	  ModelAndView model = new ModelAndView();
	  productService.saveOrUpdate(product);
	  model.setViewName("redirect:/ProManage/Padmin");
	  
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
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	 public ModelAndView save(@ModelAttribute("productForm") ProductModel product) {
		productService.saveOrUpdate(product);
	  
	  return new ModelAndView("redirect:/padmin/proAdmin");
	 }
	
	
	@RequestMapping(value="/productList", method=RequestMethod.GET)
	 public ModelAndView list() {
	  ModelAndView model = new ModelAndView("ProManage/product_list");
	  List<ProductModel> productList = productService.getAllproducts();
	  model.addObject("productList", productList);
	  
	  return model;
	 }
}



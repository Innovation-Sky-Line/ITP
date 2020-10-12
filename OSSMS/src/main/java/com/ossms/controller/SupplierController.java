package com.ossms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.Supplier;
import com.ossms.service.SupplierService;

@Controller
@RequestMapping(value="/supplier")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	/*---------------------------------Supplier Registration Form-----------------------------------*/
	
	@RequestMapping(value = "/form")
	public ModelAndView supplierReg() {
		ModelAndView model = new ModelAndView("SuppManage/supplier_form");
		Supplier supplier = new Supplier();
		model.addObject("supplier", supplier);
		return model;		
	}	
	
	/*--------------------------------------------Home View-----------------------------------------*/
		
	@RequestMapping(value="/home")
	public ModelAndView supplierHome() {
		ModelAndView model = new ModelAndView("SuppManage/home");		
		return model;		
	}
	
	/*-----------------------------------Supplier Retrieve View-------------------------------------*/
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("SuppManage/supplier_list");
		List<Supplier> supplierList = supplierService.getAllSupplier();
		model.addObject("supplierList", supplierList);
		
		return model;
		
	}
	
	/*------------------------------------Supplier Insert ------------------------------------------*/
	

	@RequestMapping(value="/addSupplier/", method=RequestMethod.POST)
	public ModelAndView addSupplier(Supplier supplier) {
		ModelAndView model = new ModelAndView();
		supplierService.saveOrUpdate(supplier);
		model.setViewName("redirect:/supplier/list");
		
		return model;
	}

	/*--------------------------------------Supplier Update-----------------------------------------*/
	
	@RequestMapping(value="/updateSupplier/{idSupplier}", method=RequestMethod.GET)
	public ModelAndView editSupplier(@PathVariable int idSupplier) {
		ModelAndView model = new ModelAndView();
		System.out.println(idSupplier);
		Supplier supplier = supplierService.getSupplierById(idSupplier);
		System.out.println(supplier);
		model.addObject("supplier",supplier);
		model.setViewName("SuppManage/supplier_form");
		
		return model;

	}
	
	/*---------------------------------Supplier details save to db-----------------------------------*/
	
	@RequestMapping(value="/saveSupplier/", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("supplier") Supplier supplier) {
		supplierService.saveOrUpdate(supplier);
		
		return new ModelAndView("redirect:/supplier/list");

	}
	
	/*----------------------------------------Supplier Delete------------------------------------------*/
	
	@RequestMapping(value="/deleteSupplier/{idSupplier}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idSupplier") int idSupplier) {
		supplierService.deleteSupplier(idSupplier);
		
		return new ModelAndView("redirect:/supplier/list");

	}
	
	/*----------------------------------------Search----------------------------------------------------*/

	@RequestMapping(value = "/searchSea", method = RequestMethod.POST)
	public ModelAndView searchSupplier(@RequestParam("suppliersea") String name, Model model) {
		ModelAndView mv = new ModelAndView("SuppManage/sup_search_res");
		List<Supplier> sList = supplierService.searchSupplier(name);
		

		if (!sList.isEmpty()) {
			return mv.addObject(sList);
		} else {
			String string = "Oops...No Matching Results Found!!!";
			model.addAttribute("fail", string);
			mv.setViewName("SuppManage/sup_search_res");
			return mv;
		}
	}
	
}

package com.ossms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.DelVehicle;
import com.ossms.model.Delivery;
import com.ossms.service.DeliveryService;

@Controller
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;
	
	@RequestMapping("/deliveryList")
	public ModelAndView homepage1() {
		ModelAndView mv = new ModelAndView("DelManage/deliveryList");
		List<Delivery> dels = deliveryService.getAllDelis();
		mv.addObject("list", dels);
//		List<DelCustomer> dCustomers  = deliveryService.getAllCustomers();
//		mv.addObject("list", dCustomers);
		return mv;
	}
	
	
	@RequestMapping("/vehicleList")
	public ModelAndView homepage2() {
		ModelAndView mv = new ModelAndView("DelManage/vehicleList");
		List<DelVehicle> vehicles = deliveryService.getAllVehicles();
		mv.addObject("list", vehicles);
		return mv;
	}
	
	
	@RequestMapping("/newDelivery")
	public String showNewDeliveryPage(Model model) {
		Delivery delivery = new Delivery();
		model.addAttribute("delivery", delivery);
		return "DelManage/newDelivery";
	}
	
	@RequestMapping("/newVehicle")
	public String showNewVehiclePage(Model model) {
		DelVehicle vehicle = new DelVehicle();
		deliveryService.saveVehicle(vehicle);
		model.addAttribute("vehicle", vehicle);
		return "DelManage/newVehicle";
	}
//	@RequestMapping(value = "/newVehicle")
//	public String saveVehicle(@ModelAttribute("vehicle") DelVehicle vehicle) {
//		deliveryService.saveVehicle(vehicle);
//		
//		return "redirect:/vehicleList";
//	}
	
	
	@RequestMapping(value = "/deleteVehicle/{idVehicle}")
	public ModelAndView delete(@PathVariable("idVehicle") int idVehicle) {
		deliveryService.deleteVehicle(idVehicle);

		return new ModelAndView("redirect:/vehicleList");
	}
	
	@RequestMapping("/delReports")
	public ModelAndView reports() {
		ModelAndView mv = new ModelAndView("DelManage/delReports");
		mv.addObject("delReports");
		return mv;
	}
	

	
}

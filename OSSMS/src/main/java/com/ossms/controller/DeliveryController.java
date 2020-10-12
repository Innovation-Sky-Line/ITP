package com.ossms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ossms.model.Customer;
import com.ossms.model.Employee;
import com.ossms.model.DelVehicle;
import com.ossms.model.Delivery;
import com.ossms.model.DeliveryList;
import com.ossms.model.Order;
import com.ossms.service.DeliveryService;

@Controller
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;
	
	@RequestMapping("/deliveryList")
	public ModelAndView homepage1(Model model) {
		ModelAndView mv = new ModelAndView("DelManage/deliveryList");
		List<Order> assignedOrders = deliveryService.getAssignedOrders();
		List<Delivery> deliveries = deliveryService.getAllDelis();
		List<DeliveryList> dList = new ArrayList<DeliveryList>();
		for (Order o : assignedOrders) {
			for(Delivery del : deliveries) {
				if(o.getIdOrder() == del.getOrderid()) {
					DelVehicle vehicle = deliveryService.getVehiclesById(del.getVehicleid());
					Employee emp = deliveryService.getNameOfEmpById(del.getDriverid());
					int cusId = deliveryService.getCustomerId(del.getOrderid());
					Customer cus = deliveryService.getCustomerName(cusId);					
					
					DeliveryList list = new DeliveryList(del, vehicle, emp,cus);
					list.setOrder(o);
					
					dList.add(list);
				}
			}			
		}
		System.out.println(dList.get(1));
		if (!deliveries.isEmpty()) {
			String str = "Delivery Added/Updated Successfully.";
			model.addAttribute("suc", str);
			mv.addObject("deliveryList", dList);
			return mv;
		} else {
			mv.setViewName("DelManage/Error");
			return mv;
		}
	}
	
	

	
	
	@RequestMapping("/newDelivery")
	public ModelAndView showNewDeliveryPage(Model model) {
		ModelAndView mv = new ModelAndView("DelManage/newDelivery");
		List<Employee> drivers = deliveryService.getAllEmps();
		List<DelVehicle> vehicles = deliveryService.getAllVehicles();
		List<Order> incompleteOrders = deliveryService.getAllIncompletedOrders();
		List<DeliveryList> dList = new ArrayList<DeliveryList>();
		for (Order o : incompleteOrders) {

			Customer cus = deliveryService.getCustomerName(o.getCustomerId());					
			
			DeliveryList list = new DeliveryList();
			list.setDelCustomer(cus);
			list.setOrder(o);
			
			dList.add(list);
			
		}

		if (!dList.isEmpty()) {
			String str = "Delivery Added/Updated Successfully.";
			model.addAttribute("suc", str);
			mv.addObject("deliveryList", dList);
			mv.addObject("emps", drivers);
			mv.addObject("vehicles", vehicles);
			return mv;
		} else {
			mv.setViewName("DelManage/Error");
			return mv;
		}
	}
	
	@RequestMapping(value = "/assignDriver", method = RequestMethod.POST)
	public ModelAndView assignDriverToOrder(@RequestParam(value="orderId") int orderId,
			@RequestParam(value="dName") int driverId, @RequestParam(value="vehicle") int vehicleId,
			Model model) {
		
		Order order = deliveryService.findOrder(orderId);
		Delivery newDel = new Delivery(orderId, driverId, vehicleId, LocalDate.now());
		order.setDeliveryStatus("Assigned");
		
		System.out.println(newDel);
		
		deliveryService.update(newDel);	
		deliveryService.saveOrder(order);
		
		return showNewDeliveryPage(model);
	}
	
	@RequestMapping(value="/completeDelivery", method = RequestMethod.POST)
	public ModelAndView completeDelivery(@RequestParam(value="orderId") int orderId, Model model) {
		
		Order order = deliveryService.findOrder(orderId);
		order.setDeliveryStatus("Delivered");
		
		deliveryService.saveOrder(order);
		
		return homepage1(model);
	}
	
	
	@RequestMapping("/vehicleList")
	public ModelAndView homepage2() {
		ModelAndView mv = new ModelAndView("DelManage/vehicleList");
		List<DelVehicle> vehicles = deliveryService.getAllVehicles();
		mv.addObject("list", vehicles);
		return mv;
	}
	
//	@RequestMapping("/newVehicle")
//	public String showNewVehiclePage(Model model) {
//		DelVehicle vehicle = new DelVehicle();
//		model.addAttribute("vehicle", vehicle);
//		deliveryService.saveVehicle(vehicle);
//		return "DelManage/newVehicle";
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
	
	@RequestMapping(value = "/searchCompleteDels", method=RequestMethod.POST)
	public ModelAndView searchStatus(@RequestParam("status") String status, Model model) {
		ModelAndView mv = new ModelAndView("DelManage/SearchedDeliveries");
		List<Order> ord = deliveryService.searchStatus(status);
		return mv.addObject(ord);
	}
	

	
}

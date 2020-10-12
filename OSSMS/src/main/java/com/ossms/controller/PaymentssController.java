package com.ossms.controller;


import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;
import com.ossms.model.PaymentPDFExporter;
import com.ossms.model.Paymentss;
import com.ossms.service.PaymentssService;


@Controller
@RequestMapping(value="/payment")
public class PaymentssController {
	
	@Autowired
	PaymentssService paymentssService;
	
/*---------------------------------Payments Registration Form-----------------------------------*/
	
	@RequestMapping(value = "/payform")
	public ModelAndView paymentReg() {
		ModelAndView model = new ModelAndView("SuppManage/payments");
		Paymentss paymentss = new Paymentss();
		model.addObject("paymentss", paymentss);
		return model;		
	}
	
	
/*------------------------------------Payments Insert ------------------------------------------*/
	

	@RequestMapping(value="/addpayments/", method=RequestMethod.POST)
	public ModelAndView paymentss(Paymentss paymentss) {
		ModelAndView model = new ModelAndView();
		paymentssService.saveOrUpdate(paymentss);
		model.setViewName("redirect:/payment/plist");
		
		return model;
	}
	
/*-----------------------------------Payments Retrieve View-------------------------------------*/
	
	@RequestMapping(value="/plist", method=RequestMethod.GET)
	public ModelAndView plist() {
		ModelAndView model = new ModelAndView("SuppManage/payments_list");
		List<Paymentss> paymentsList = paymentssService.getAllPayments();
		model.addObject("paymentsList", paymentsList);
		
		return model;
		
	}

/*--------------------------------------Payments Update-----------------------------------------*/
	
	@RequestMapping(value="/updatePaymentss/{idPayment}", method=RequestMethod.GET)
	public ModelAndView editPaymentss(@PathVariable int idPayment) {
		ModelAndView model = new ModelAndView();
		System.out.println(idPayment);
		Paymentss paymentss = paymentssService.getPaymentssById(idPayment);
		System.out.println(paymentss);
		model.addObject("Paymentss",paymentss);
		model.setViewName("/payment/payform");
		
		return model;

	}
	
/*---------------------------------Payments details save to db-----------------------------------*/
	
	@RequestMapping(value="/savePaymentss/", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("paymentss") Paymentss paymentss) {
		paymentssService.saveOrUpdate(paymentss);
		
		return new ModelAndView("redirect:/payment/plist");

	}
	
/*-----------------------------------------Report View----------------------------------------*/
	
	@RequestMapping(value="/reports")
	public ModelAndView reportsdis() {
		ModelAndView model = new ModelAndView("SuppManage/reports_dis");
		Paymentss paymentss = new Paymentss();
		model.addObject("paymentss", paymentss);	
		return model;		
	}
	
/*----------------------------------------Payments Delete------------------------------------------*/
	
	@RequestMapping(value="/deletePaymentss/{idPayment}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idPayment") int idPayment) {
		paymentssService.deletePaymentss(idPayment);
		
		return new ModelAndView("redirect:/payment/plist");

	}

/*----------------------------------------Generate Report------------------------------------------*/	

	@RequestMapping(value="/payreport", method=RequestMethod.GET)
	public ModelAndView payreport() {
		ModelAndView model = new ModelAndView("SuppManage/PayReport");
		List<Paymentss> paymentsList = paymentssService.getAllPayments();
		model.addObject("paymentsList", paymentsList);
		
		return model;
		
	}

/*----------------------------------------Export PDF------------------------------------------*/

	@GetMapping("/export")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTimeString = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=SupplierPayments" +currentDateTimeString + ".pdf";
		
		response.setHeader(headerKey, headerValue);
		/*String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		List<EmployeeAttendance> attendanceList = new ArrayList<EmployeeAttendance>();
		*/
		
		List<Paymentss> paymentsList = paymentssService.getAllPayments();
		
	
		PaymentPDFExporter exporter = new PaymentPDFExporter(paymentsList);
		exporter.export(response);
		
	}
	
	
}

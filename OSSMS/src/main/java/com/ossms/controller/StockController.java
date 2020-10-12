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
import com.ossms.model.StockPDFExporter;
import com.ossms.model.Stocks;
import com.ossms.model.Supplier;
import com.ossms.service.StockService;
import com.ossms.service.SupplierService;

@Controller
@RequestMapping(value="/stock")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	/*---------------------------------Stock Registration Form-----------------------------------*/
	
	@RequestMapping(value = "/stockform")
	public ModelAndView stockReg() {
		ModelAndView model = new ModelAndView("SuppManage/stock_form");
		Stocks stocks = new Stocks();
		model.addObject("stocks", stocks);
		return model;		
	}
	
	
	/*-----------------------------------Stock Retrieve View-------------------------------------*/
	
	@RequestMapping(value="/slist", method=RequestMethod.GET)
	public ModelAndView slist() {
		ModelAndView model = new ModelAndView("SuppManage/stocks_list");
		List<Stocks> stocksList = stockService.getAllStocks();
		model.addObject("stocksList", stocksList);
		
		return model;
		
	}
	
	/*------------------------------------Stock Insert ------------------------------------------*/
	

	@RequestMapping(value="/addStocks/", method=RequestMethod.POST)
	public ModelAndView addStocks(Stocks stocks) {
		ModelAndView model = new ModelAndView();
		stockService.saveOrUpdate(stocks);
		model.setViewName("redirect:/stock/slist");
		
		return model;
	}

	/*--------------------------------------Stock Update-----------------------------------------*/
	
	@RequestMapping(value="/updateStocks/{idPurchasedStock}", method=RequestMethod.GET)
	public ModelAndView editStocks(@PathVariable int idPurchasedStock) {
		ModelAndView model = new ModelAndView();
		System.out.println(idPurchasedStock);
		Stocks stocks = stockService.getStocksById(idPurchasedStock);
		System.out.println(stocks);
		model.addObject("stocks",stocks);
		model.setViewName("SuppManage/stock_form");
		
		return model;

	}
	
	/*---------------------------------Stock details save to db-----------------------------------*/
	
	@RequestMapping(value="/saveStocks/", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("stocks") Stocks stocks) {
		stockService.saveOrUpdate(stocks);
		
		return new ModelAndView("redirect:/stock/slist");

	}
	
	/*----------------------------------------Stock Delete------------------------------------------*/
	
	@RequestMapping(value="/deleteStocks/{idPurchasedStock}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idPurchasedStock") int idPurchasedStock) {
		stockService.deleteStocks(idPurchasedStock);
		
		return new ModelAndView("redirect:/stock/slist");

	}
	
	/*----------------------------------------Generate Report------------------------------------------*/	

	@RequestMapping(value="/stockreport", method=RequestMethod.GET)
	public ModelAndView stockreport() {
		ModelAndView model = new ModelAndView("SuppManage/StockReport");
		List<Stocks> stocksList = stockService.getAllStocks();
		model.addObject("stocksList", stocksList);
		
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
		
		List<Stocks> stocksList = stockService.getAllStocks();
		
		StockPDFExporter exporter = new StockPDFExporter(stocksList);
		exporter.export(response);
		
	}
	
}

package com.ossms.controller;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

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

import com.lowagie.text.DocumentException;
import com.ossms.model.AttId;
import com.ossms.model.Attendance;
import com.ossms.model.AttendancePDFExporter;
import com.ossms.model.EmpBasicInfo;
import com.ossms.model.Employee;
import com.ossms.model.EmployeeAttendance;
import com.ossms.model.SalaryPDFExporter;
import com.ossms.repository.AttendanceRepository;
import com.ossms.repository.EmployeeRepository;
import com.ossms.service.EmployeeService;


	
@Controller
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	

	
	/*@RequestMapping(value = "/employeeform")
	public String empAdminPg() {
		return "EmpManage/EmpAdmin";
	}*/
	
	@RequestMapping(value = "/form")
	public ModelAndView employeeReg() {
		ModelAndView model = new ModelAndView("EmpManage/EmpAdmin");
		Employee employee = new Employee();
		model.addObject("employee", employee);
		return model;		
	}
	
	@RequestMapping(value = "/EmployeeHome")
	public String empHomePg() {
		return "EmpManage/EmpHome";
	}
	
	
	@RequestMapping(value = "/Result", method=RequestMethod.POST)
	public ModelAndView calSalary(@RequestParam(value="empId")int idEmployee,@RequestParam(value="otHrs")int otHours,@RequestParam(value="rate")int rate){
		ModelAndView model = new ModelAndView("EmpManage/SalaryReport");
		Employee employee= empService.getEmployeeById(idEmployee);
		EmpBasicInfo empBas= empService.findById(employee.getType()).get();

		employee.setOtHours(otHours);
		employee.setTotSalary(empBas.getBasicSalary()+(rate*otHours));
		empService.saveorUpdate(employee);
		
		List<Employee> employeeList = empService.getallEmployees();
		model.addObject("employeeList", employeeList);
		
		return model;
	}
	
	public String getMonthID(String month) {
		switch(month) {
		case "JANUARY" : return "jan";
		case "FEBRUARY" : return "feb";
		case "MARCH" : return "mar";
		case "APRIL" : return "apr";
		case "MAY" : return "may";
		case "JUNE" : return "jun";
		case "JULY" : return "jul";
		case "AUGUST" : return "aug";
		case "SEPTEMBER" : return "sep";
		case "OCTOBER" : return "oct";
		case "NOVEMBER" : return "nov";
		case "DECEMBER" : return "dec";
		default : return "Invalid";
		}
			
	}
	
	
	@RequestMapping(value="/calSalary/{id}", method=RequestMethod.GET)
	public ModelAndView calSalary(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		System.out.println(id);
		Employee employee = empService.getEmployeeById(id);
		String type = empService.findByType(id);
		Optional<EmpBasicInfo> info = empService.findById(type);
		String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		Attendance attendance = empService.findAttendance(id, monthID);
		
		Float sal = employee.getTotSalary();
		
		if(sal>0) 
		{
			
			model.setViewName("EmpManage/Error");
			return model;
		}
		else {
		int hoursWorked = attendance.getAttendance() - info.get().getHours();
		if(hoursWorked > 0) {
			model.addObject("hours", hoursWorked);
		}else {
			model.addObject("hours", 0);
		}
		
		System.out.println(employee);
		System.out.println(info);
		System.out.println(attendance);
		
	
		model.addObject("employee",employee);
		model.addObject("empType", info.get());
		model.addObject("att", attendance);
		model.setViewName("EmpManage/Trial2");
		
		
		return model;
		}
	}
	
	@RequestMapping(value="/manageAttendance/{id}", method=RequestMethod.GET)
	public ModelAndView manageAttendance(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		System.out.println(id);
		Employee employee = empService.getEmployeeById(id);
		String type = empService.findByType(id);
		Optional<EmpBasicInfo> info = empService.findById(type);
		System.out.println(employee);
		float sal = employee.getTotSalary();
		if(sal>0) 
		{
			
			model.setViewName("redirect:/Employee/AttReport");
			return model;
		}
		else {
		model.addObject("employee",employee);
		model.addObject("empType", info.get());
		model.setViewName("EmpManage/Trial");
		
		return model;
		}	
	}
	
	/*
	@RequestMapping(value = "manageAttendance/{id}", method = RequestMethod.GET)
	public ModelAndView manageAttendance(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		System.out.println(id);
		Employee employee = empService.findByType(id);
		System.out.println(employee);
		model.addObject("employee",employee);
		model.setViewName("EmpManage/ManageAttendance");
		
		return model;

	}*/

	/*@RequestMapping("/addEmployee")
	public ModelAndView save(@ModelAttribute("employee") Employee employee ) {
	ModelAndView mav = new ModelAndView("empList");
	empService.saveorUpdate(employee);
		return mav;
	}*/
	
	/*@RequestMapping("/addEmployee/")
	public String addEmployee(Employee employee) {
		//empService.saveEmp(employee);
		empRepo.save(employee);
		return "EmpManage/ShowEmployee";
	}
	*/
	
	
	@RequestMapping(value="/addEmployee/", method=RequestMethod.POST)
	public ModelAndView addEmployee(Employee employee) {
		ModelAndView model = new ModelAndView();
		empService.saveorUpdate(employee);
		model.setViewName("redirect:/Employee/list");
		return model;
		
	}
	
	
	@RequestMapping(value = "/AddAttendance/", method=RequestMethod.POST)
	//public String attendanceReport() {
		//return "EmpManage/AttendanceReport";
	public ModelAndView addAttendance(@RequestParam(value="monthId")String month,@RequestParam(value="attendance")int attendance,@RequestParam(value="empId")int empId) {
		ModelAndView model = new ModelAndView();
		Attendance a = new Attendance(empId , month , attendance, 2020 );
		empService.saveorUpdate(a);
		model.setViewName("redirect:/Employee/AttReport");
		return model;
	
	}
	
	@RequestMapping(value = "/AttReport", method = RequestMethod.GET)
	public ModelAndView attendanceReport() {
		ModelAndView model = new ModelAndView("EmpManage/AttendanceReport");
		List<EmployeeAttendance> empAttendance = new ArrayList<EmployeeAttendance>();
				
		List<Employee> employeeList = empService.getallEmployees();
		
		String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		for(Employee e : employeeList ){
			
		Attendance attendance = empService.findAttendance(e.getIdEmployee(), monthID);
		EmployeeAttendance emp = new EmployeeAttendance(e,attendance);
		empAttendance.add(emp);
		}
		
		model.addObject("employeeList", empAttendance);
		

		return model;
	}
	
	/*
	@RequestMapping(value="/AttendanceReport/" , method = RequestMethod.GET)
		public ModelAndView attendReport(@PathVariable Integer id) {
			
			ModelAndView model = new ModelAndView();
			System.out.println(id);
			Employee employee = empService.getEmployeeById(id);
			String type = empService.findByType(id);
			Optional<EmpBasicInfo> info = empService.findById(type);
			String month = YearMonth.now().getMonth().toString();
			String monthID = this.getMonthID(month); 
			Attendance attendance = empService.findAttendance(id, monthID);
			List<Employee> employeeList = empService.getallEmployees();
			
	
			
			System.out.println(employee);
			System.out.println(info);
			System.out.println(attendance);
			
			model.addObject("employeeList", employeeList);
			model.addObject("employee",employee);
			model.addObject("empType", info.get());
			model.addObject("att", attendance);
			model.setViewName("EmpManage/Trial3");
			
			
			return model;
		}
	*/
	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("EmpManage/ShowEmployee");
		List<Employee> employeeList = empService.getallEmployees();
		model.addObject("employeeList", employeeList);

		return model;
		
	}
	
/*	
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET)
	public ModelAndView editArticle(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		List<Employee> employeeList = (List<Employee>) empService.getEmployeeById(id);
		//Employee employee = empService.getEmployeeById(id);
	//	model.addObject("employeeForm", employee);
	//	model.setViewName("EmpManage/ShowEmployee");
		model.addObject("employeeList", employeeList);
		
		return model;
	}*/
	
	@RequestMapping(value="/updateEmployee/{id}", method=RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		System.out.println(id);
		Employee employee = empService.getEmployeeById(id);
		System.out.println(employee);
		model.addObject("employee",employee);
		model.setViewName("EmpManage/EmpAdmin");
		
		return model;

	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Integer id) {
		empService.deleteEmployee(id);

		return new ModelAndView("redirect:/Employee/list");
	}
	
	
	@RequestMapping(value = "/Report", method = RequestMethod.GET)
	public ModelAndView Report() {
		ModelAndView model = new ModelAndView("EmpManage/AttReport");
		List<EmployeeAttendance> empAttendance = new ArrayList<EmployeeAttendance>();
		
		String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		List<Attendance> attendanceList = empService.getAllAttendanceDesc(monthID);	
		
		for(Attendance a : attendanceList) {
			Employee emp = empService.getEmployeeById(a.getEmpId());
			empAttendance.add(new EmployeeAttendance(emp, a));
		}
		
		model.addObject("employeeList", empAttendance);


		return model;
	}
	
	
	@RequestMapping(value = "/searchEmployee", method=RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("employee") String type, Model model) {
		ModelAndView mv = new ModelAndView("EmpManage/SearchedEmployees");
		List<Employee> emp = empService.searchEmployees(type);
		
		if(!emp.isEmpty()) {
			
			 
			return mv.addObject(emp);
		}else {
			String string = "Oops...No Matching Category Found!!!";
			model.addAttribute("fail",string );
			mv.setViewName("EmpManage/Error");
			return mv;
		}
		
	}
	
	@GetMapping("/export")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime= dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=BestAttendance" +currentDateTime + ".pdf";
		
		response.setHeader(headerKey, headerValue);
		/*String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		List<EmployeeAttendance> attendanceList = new ArrayList<EmployeeAttendance>();
		*/
		
		List<EmployeeAttendance> empAttendance = new ArrayList<EmployeeAttendance>();
		
		String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		List<Attendance> attendanceList = empService.getAllAttendanceDesc(monthID);	
		
		for(Attendance a : attendanceList) {
			Employee emp = empService.getEmployeeById(a.getEmpId());
			empAttendance.add(new EmployeeAttendance(emp, a));
		}
		
		
		
		AttendancePDFExporter exporter = new AttendancePDFExporter(empAttendance);
		exporter.export(response);
		
	}
	
	
	@GetMapping("/exportSal")
	public void exportSalToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime= dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Employee Salary Report" +currentDateTime + ".pdf";
		
		response.setHeader(headerKey, headerValue);
		/*String month = YearMonth.now().getMonth().toString();
		String monthID = this.getMonthID(month); 
		List<EmployeeAttendance> attendanceList = new ArrayList<EmployeeAttendance>();
		*/
		
		List<Employee> emp =  empService.getallEmployees();
	
		
		SalaryPDFExporter exporter = new SalaryPDFExporter(emp);
		exporter.export(response);
		
	}

	
	
	
}

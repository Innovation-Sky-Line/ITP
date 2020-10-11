<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

.footer {
	position: relative;
	top: 848px;
}
h2{
text-align:center;
}

td {
  text-align: center;
}
th {
  	text-align: center;
	color: black;
}
.title{
	
	width : 60%;
	height: 40%;
	text-align: center;
	
}
 .body {
	position: absolute;
	left: 100px;
	width: 85%;
	top: 500px;
	
}
.sideBox{
	position: absolute;
	width : 8%;
	height: 20%;
	right:38px;
	 
}

.dropbtn {
 
  border-radius: 25px;
  background-color: #0b7dda;
  color: white;
  padding: 13px;
  font-size: 14px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}


.button:hover {
	background-color: white;
	color: black;
}
</style>


<!--  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
-->
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Employee Report</title>
</head>
<body>
<jsp:include page="../views/EmpHeader.jsp"></jsp:include>

		<div class = "sideBox">
		<div class="dropdown">
		  <button class="dropbtn">Print Reports</button>
		  <div class="dropdown-content">
		    <a href="/Employee/export">Best Attendance</a>
		    <a href="/Employee/exportSal">Salary Report</a>
		  </div>
		</div>

	</div>
		<div class = "title" style ="margin : auto">
		<img src="../../resources/images/logo.jpg"><br>
		<h3>Athukorala SuperMarket PVT. LTD.</h3>
		<h4>Best Attendance</h4>
		<p>T.P : +94 68-222 22 54/ +94 76 324 45 66 | FAX : 87686756778 | Email : athukoralasm@gmail.com </p>
		<br><br>
	</div>	
	<div class="body">
 	<table class="table table-striped" id="tab">
 	<thead>
		<tr>
			<td>Name</td>
			<td>Type</td>
			<td>Month</td>
			<td>Shift Hours (Per Month)</td>
			<td>OT Hours</td>
			<td>Attendance (Total Hours)</td>
			
		</tr>
	</thead>	
		<c:forEach var="emp"  items="${employeeList }">
		<tr>
			<td>${emp.employee.firstName } ${emp.employee.lastName }</td>
			<td>${emp.employee.type }</td>
			<td>${emp.attendance.monthId  }</td>
			<td>${emp.attendance.attendance-emp.employee.otHours  }</td>
			<td>${emp.employee.otHours  }</td>
			<td>${emp.attendance.attendance  }</td>
		
			
	
		</tr>		
		</c:forEach>
		
	</table>
	<br><br>
	<div class = "title" style ="margin : auto">
		<img src="../../resources/images/logo.jpg"><br>
		<h3>Athukorala SuperMarket PVT. LTD.</h3>
		<h4>Employee Salary Report</h4>
		<p>T.P : +94 68-222 22 54/ +94 76 324 45 66 | FAX : 87686756778 | Email : athukoralasm@gmail.com </p>
		<br><br>
	</div>	
	<table class="table table-striped" id="tab">
 	<thead>
		<tr>
			<td>Name</td>
			<td>Employee Type</td>
			<td>Month</td>
			<td>OT Hours</td>
			<td>Total Salary</td>
			
		</tr>
	</thead>	
		<c:forEach var="emp"  items="${employeeList }">
		<tr>
			<td>${emp.employee.firstName } ${emp.employee.lastName }</td>
			<td>${emp.employee.type }</td>
			<td>${emp.attendance.monthId  }</td>
			<td>${emp.employee.otHours  }</td>
			<td>${emp.employee.totSalary }</td>
		
			
	
		</tr>		
		</c:forEach>
		
	</table>
	
	
	</div>
	
	
	
	
	
	
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
<title>Manage Attendance</title>
</head>
<style>

.footer {
	position: relative;
	top: 848px;
}

#save{
background-color: #4CAF50;
text-align: center;
margin-left: auto;
margin-right: auto;

}
#readonly {
  background-color:#9d9d9e;
  color: white;
  text-align: center;
}

h2{
text-align:center;
}
</style>
<body>
<jsp:include page="../views/EmpHeader.jsp"></jsp:include>
<h2>Manage Employee Attendance</h2>
<hr>
<br>
<br>	
	<table class="table table-striped">
	<tr>
		<td>first name</td>
		<td><input type="text" value="${employee.firstName }" readonly id="readonly"></td>
	</tr>
	<tr>
		<td>Basic Salary</td>
		<td><input type="text" value="${empType.basicSalary }" readonly id="readonly"></td>
	</tr>
	<tr>
		<td>Type</td>
		<td><input type="text" value="${employee.type }" readonly id="readonly"></td>
	</tr>
	<tr>
		<td>Shift hours</td>
		<td><input type="text" value="${empType.hours }" readonly id="readonly"></td>
	</tr>
	</table>
	
	<div class= "insert" style="width:800px; margin:0 auto;" >
	<form action="/Employee/AddAttendance/" method="POST" class="table table-striped" >
		<table >
		
			<tr>
				<td><input type="text" value="${employee.idEmployee }"  name= "empId" hidden>
				Enter month</td> 
				<td><input type="text" name="monthId"></td>  
			</tr>
			<tr>
	    		<td>Number of hours worked in the month</td>  
	    		<td><input type="text" name="attendance"></td> 
	   		</tr>
		</table>	
		<br>
		
		<input id="save" type="submit" name="submit" class="btn btn=primary" value="Manage">
	
	
		</form>
	</div>
	
	<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
	
</body>
</html>
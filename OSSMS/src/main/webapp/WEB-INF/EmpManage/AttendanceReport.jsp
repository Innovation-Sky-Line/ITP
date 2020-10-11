<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h2{
text-align:center;
}

td {
  text-align: center;
}

#tab{
	position: absolute;
	left: 100px;
	width: 85%;
	top:280px;
	
}

.footer {
	position: relative;
	top: 848px;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
-->
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Attendance Summary</title>
</head>
<body>
<jsp:include page="../views/EmpHeader.jsp"></jsp:include>
 <h2>Employee Attendance Summary</h2>
 <hr>
<br>
<br>
	
	
 	<table class="table table-striped" id="tab">
		<tr>
			<td>Name</td>
			<td>Type</td>
			<td>Month</td>
			<td>Attendance (Total Hours)</td>
			
		</tr>
		<c:forEach var="emp"  items="${employeeList }">
		<tr>
			<td>${emp.employee.firstName }</td>
			<td>${emp.employee.type }</td>
			<td>${emp.attendance.monthId  }</td>
			<td>${emp.attendance.attendance  }</td>
		
			
	
		</tr>		
		</c:forEach>
		
	</table>
 <div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
 
</body>
</html>
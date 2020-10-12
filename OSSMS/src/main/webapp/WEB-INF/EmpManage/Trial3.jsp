<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="overflow-x:auto;">
	<table class="table table-dark table-hover">
		<tr>
			<td>ID</td>
			<td>Type</td>
			<td>Name</td>
			<td>Contact Number</td>
			<td>Daily Shift</td>
			
		</tr>
		<c:forEach var="emp" items="${employeeList }">
		<tr>
			<td>${emp.idEmployee }</td>
			<td>${emp.type }</td>
			<td>${emp.firstName  }</td>
			<td>${emp.contactNo }</td>
			<td>${emp.hoursWorked }</td>
			<td>
					<spring:url value="/Employee/updateEmployee/${emp.idEmployee }" var="updateURL"/>
					<a class="btn btn-primary" href="${updateURL }" role="button" >Update</a>
				</td>
				<td>
					<spring:url value="/Employee/calSalary/${emp.idEmployee }" var="calURL"/>
					<a class="btn btn-primary" href="${calURL }" role="button" >Calculate Salary</a>
				</td>
				<td>
					<spring:url value="/Employee/manageAttendance/${emp.idEmployee }" var="manAtteURL"/>
					<a class="btn btn-primary" href="${manAtteURL }" role="button" >Manage Attendance</a>
				</td>
				<td>
					<spring:url value="/Employee/deleteEmployee/${emp.idEmployee }" var="deleteURL"/>
					<a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
				</td>
				
		</tr>		
		</c:forEach>
		
	</table>
	</div>
</body>
</html>
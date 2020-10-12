<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<style>
#save{
background-color: #4CAF50;
text-align: center;

}

h2{
text-align:center;
}

</style>
<title>Manage Attendance</title>
</head>
<body>
<img src="../../resources/images/EMS2.png"  width="100%" height="300px">
<jsp:include page="../../resources/EmpHeader.jsp"></jsp:include>	
	<h2>Manage Attendance</h2>
	<hr>
<br>
<br>
	<div class="container">
		<spring:url value="/Employee/AddAttendance/" var="saveURL"/>
		
		<form:form cssClass="form">
		<form:hidden path="idEmployee"/>
		
		<div class="form-group">
		<label>Enter Firstname</label>
		<input type="text" cssClass="form-control" id="firstName"  value="${employee.firstName }" readonly="true"/>
		</div>
		
		<div class="form-group">
		<label>Employee Type</label>
		<input type="text" cssClass="form-control" id="type" value="${employee.type }" readonly="true"/>
		</div>
		
		<div class="form-group">
		<label>Basic Salary</label>
		<input type="text"cssClass="form-control" id="totSalary" value="${empType.basicSalary }" readonly="true"/>
		</div>
		
		<div class="form-group">
		<label>Shift Hours</label>
		<input type="text"cssClass="form-control" id="hoursWorked" value="${empType.hours }" readonly="true"/>
		</div>
		
		<form:form method="post" action="${saveURL }" cssClass="form">
		<!--  <input type="text" value="${employee.idEmployee }"  />-->
		
		<div class="form-group">
		<label>Enter month</label>
		<form:input path="" cssClass="form-control" id=""/>
		</div>
		
		<div class="form-group">
		<label>Number of Hours worked</label>
		<form:input path="" cssClass="form-control" id=""/>
		</div>
		
		
		<input type="submit" id="save" class="btn btn=primary" value="Manage"><br><br>
	    	</form:form>
		</form:form>
	</div>
	 <jsp:include page="../../resources/Footer.jsp"></jsp:include>
</body>
</html>
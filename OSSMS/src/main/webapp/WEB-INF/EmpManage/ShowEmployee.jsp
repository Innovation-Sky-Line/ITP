<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
 -->
 
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>

sideBox{
	position: absolute;
	width : 40%;
	height: 20%;
	right:0px;
	 
}
form.example input[type=text] {
border-radius: 25px;
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
 
  opacity: 0.9;
  border-radius: 25px;
  width: 20%;
  padding: 15px;
  background: #2196F3;
  color: white;
  font-size: 15px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}
.footer {
	position: relative;
	top: 848px;
}

.listBtn{
 float : right;
  opacity: 0.9;
  border-radius: 25px;
  width: 20%;
  padding: 10px;
  background: green;
  color: white;
  font-size: 15px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
#save{
background-color: #4CAF50;
text-align: center;

}
td {
  text-align: center;
}
h2{
text-align:center;
}

#tab{
 	right:100px;
 }
 .body {
	position: absolute;
	left: 210px;
	width: 85%;
	top: 380px;
	
}
</style>
<title>Employee Details</title>
</head>
<body>
<jsp:include page="../views/EmpHeader.jsp"></jsp:include>
<jsp:include page="../views/EmpManageSideBar.jsp"></jsp:include>

<div class = "sideBox">
		<form:form class="example" action="/Employee/searchEmployee" method = "POST" style="margin:auto;right:2px;max-width:550px">
  			<input type="text" placeholder ="Search Employee by Type..." name="employee" required = "required">
  			<button type="submit"><i class="fa fa-search"></i></button>
		</form:form>
		<a href="/Employee/form"><button class="listBtn">Add New Employees</button></a>
	</div><br>
<h2>Employees</h2>
<hr>
<br>
<br>	
	<div style="overflow-x:auto;" class="body">
	<table class="table table-dark table-hover" id="tab">
		<tr>
			<td>ID</td>
			<td>Type</td>
			<td>Name</td>
			<td>Contact Number</td>
			<td>Address</td>
			
		</tr>
		<c:forEach var="emp" items="${employeeList }">
		<tr>
			<td>${emp.idEmployee }</td>
			<td>${emp.type }</td>
			<td>${emp.firstName  }</td>
			<td>${emp.contactNo }</td>
			<td>${emp.address }</td>
			<td>
					<spring:url value="/Employee/updateEmployee/${emp.idEmployee }" var="updateURL"/>
					<a class="btn btn-primary" href="${updateURL }" role="button" >Update</a>
				</td>
				<td>
					<spring:url value="/Employee/manageAttendance/${emp.idEmployee }" var="manAtteURL"/>
					<a class="btn btn-primary" href="${manAtteURL }" role="button" >Manage Attendance</a>
				</td>
				<td>
					<spring:url value="/Employee/calSalary/${emp.idEmployee }" var="calURL"/>
					<a class="btn btn-primary" href="${calURL }" role="button" >Calculate Salary</a>
				</td>
				<td>
					<spring:url value="/Employee/deleteEmployee/${emp.idEmployee }" var="deleteURL"/>
					<a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
				</td>
				
		</tr>		
		</c:forEach>
		
	</table>
	</div>
<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
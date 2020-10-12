<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
-->

<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}

.sideBox {
	position: absolute;
	width: 40%;
	height: 20%;
	right: 0px;
}

form.example input[type=text] {
	border-radius: 25px;
	padding: 10px;
	font-size: 17px;
	border: 2px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	opacity: 0.9;
	border-radius: 25px;
	width: 20%;
	padding: 1px;
	background: #0b7dda;
	color: white;
	font-size: 15px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

.listBtn {
	opacity: 0.9;
	border-radius: 25px;
	width: 20%;
	padding: 10px;
	background: #0b7dda;
	color: white;
	font-size: 12px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

form.example button:hover {
	background: Green;
}

.listBtn:hover {
	background: Green;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}
.footer {
	position: relative;
	top: 848px;
}

#save{
background-color: #4CAF50;
text-align: center;

}

body {
  background-colur:#236be8;

}
.body {
	position: absolute;
	left: 210px;
	width: 40%;
	top: 180px;
	
}


h2{
text-align:center;
}
</style>

<script>
function confirmation(){

	 alert( "Record Added Succefully!" );
}

</script>

<meta charset="ISO-8859-1">
<title>Employee Administration.</title>
</head>
<body>
<jsp:include page="../views/EmpHeader.jsp"></jsp:include>
<jsp:include page="../views/EmpManageSideBar.jsp"></jsp:include>

<div class="sideBox">
		<form:form class="example" action="/Employee/searchEmployee" method = "POST" style="margin:auto;right:2px;max-width:550px">
  			<input type="text" placeholder ="Search Employee by Type..." name="employee" required = "required">
  			<button type="submit"><i class="fa fa-search"></i></button>
		</form:form>
		<a href="/Employee/list"><button class="listBtn">All
				Employees</button></a>
	</div>

	

<div class="body">
		<spring:url value="/Employee/addEmployee/" var="saveURL"/>
		<h2>ADD Employee</h2>
		<hr>
<br>
<br>
		<form:form modelAttribute="employee" name="myForm" method="post" onsubmit="return confirmation()" action="${saveURL }" cssClass="form">
		<form:hidden path="idEmployee"/>
		
		<div class="form-group">
		<label>Enter Firstname</label>
		<form:input path="firstName" cssClass="form-control" id="firstName" name="fname" required="required"/>
		</div>
		
		<div class="form-group">
		<label>Enter Lastname</label>
		<form:input path="lastName" cssClass="form-control" id="lastName" required="required"/>
		</div>
		
		<div class="form-group">
		<label>Enter Contact Number (Format 0712345678)</label>
		<form:input path="contactNo" cssClass="form-control" id="contactNo" required="required"  pattern="0[0-9]{09}"/>
		</div>
		
		<div class="form-group">
		<label>Address</label>
		<form:input path="address" cssClass="form-control" id="address" required="required"/>
		</div>
		
		<div class="form-group">
		<label>Enter Position:</label><br>
		<label>Management</label>
		<form:radiobutton path="position" value="Management" cssClass="form-control" id="position"/>
		<label>Non Management</label>
		<form:radiobutton path="position" value="Non Management" cssClass="form-control" id="position"/>
		</div>
		
		<div class="form-group">
		<label>Employee Type:</label><br>
		<label>Cashier</label>
		<form:radiobutton  path="type" value="cashier" cssClass="form-control" id="type"/>
		<label>Sales Worker</label>
		<form:radiobutton  path="type" value="salesworker" cssClass="form-control" id="type"/>
		<label>Driver</label>
		<form:radiobutton  path="type" value="driver" cssClass="form-control" id="type"/>
		</div>
		
		
		
		
		<input type="submit" id="save" class="btn btn=primary" value="Save" ><br><br>
		
		</form:form>
	</div>
	
<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>

</body>
</html>
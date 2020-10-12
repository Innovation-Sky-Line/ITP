<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	
	<!--  Bootstrap -->
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
	<!--  Bootstrap -->
	
	
	
<style type="text/css">
.body {
	position: absolute;
	left: 200px;
	width: 40%;
	top: 200px;
}

.footer {
	position: relative;
	top: 848px;
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
</style>	
	
	
	<title>Supplier Form</title>
	
	
</head>
<body>
		<!--  Header -->
		
		<jsp:include page="../views/SupHeader.jsp"></jsp:include>
		<jsp:include page="../views/SupmanageSidebar.jsp"></jsp:include>
		
		<!--  Header -->
		
		<!--  Form Start-->
	<div class="body">
		<spring:url value="/supplier/addSupplier/" var="saveURL"/>
		<h2>Supplier Details Form</h2>
		<form:form modelAttribute="supplier" method="post" action="${saveURL }" cssClass="form">
		<form:hidden path="idSupplier"/>
		
		<div class="form-group">
		<label>Name</label>
		<form:input path="supplierName" cssClass="form-control" id="supplierName" pattern = "^[A-Za-z0-9&_/\s]{1,32}$" title = "Can only use '_''/' and '&' as Characters." required="required" />
		</div>
		
		<div class="form-group">
		<label>Address</label>
		<form:input path="address" cssClass="form-control" id="address" pattern = "^[A-Za-z0-9&_/\s]{1,32}$" title = "Can only use '_''/' and '&' as Characters." required="required"/>
		</div>
		
		<div class="form-group">
		<label>Email</label>
		<form:input path="email" cssClass="form-control" id="email" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title = "Invalid Email Address." required="required"/>
		</div>
		
		<div class="form-group">
		<label>Status</label>
		<form:select path="status" cssClass="form-control" id="status" required = "required">
			<form:option value = "Active">Active</form:option>
			<form:option value = "Inactive">Inactive</form:option>
			</form:select>
		</div>
				
		<div class="form-group">
		<label>Contact No</label>
		<form:input path="contactNo" cssClass="form-control" id="contactNo" type="number" required = "required"/>
		</div>
		
		<input type="submit" id="save"class="btn btn=primary" value="Save">
		
		
		</form:form>
	</div>
		<!--  Form End-->

 <div class="footer">
		<jsp:include page="../views/SupFooter.jsp"></jsp:include>
	</div>
</body>

	
</html>
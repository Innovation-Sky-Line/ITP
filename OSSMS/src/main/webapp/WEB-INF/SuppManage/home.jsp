<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Bootstrap -->
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Bootstrap -->

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
</style>
<title>Supplier Administration.</title>
</head>
<body>

	 <!--  Header -->
		
		
		
	 <!--  Header -->
	
	<h1>Welcome To Supplier Management Administration Page!</h1>
	
	 <!--  Header Buttons -->
	<div class="container">
	<div class="center">
	<a href="/supplier/form"><button type="button" id="butn" class="btn btn-primary">Supplier Form</button></a>
	<a href="/supplier/list"><button type="button" id="butn" class="btn btn-primary">Supplier List</button></a>
	<a href="/payment/payform"><button type="button" id="butn" class="btn btn-primary">Payments</button></a>
	<a href="/stock//stockform"><button type="button" id="butn" class="btn btn-primary">Stock Maintenance</button></a>
	<a href="/payment/reports"><button type="button" id="butn" class="btn btn-primary">Reports</button></a>
	</div></div>
	
	<!--  Header Buttons -->
	
</body>
</html>
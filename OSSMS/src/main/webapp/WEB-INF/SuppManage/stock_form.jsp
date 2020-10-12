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
	<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
	<title>Stock Maintenance Form</title>

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
	
</head>
<body>
		<!--  Header -->
		
		<jsp:include page="../views/SupHeader.jsp"></jsp:include>
		<jsp:include page="../views/SupmanageSidebar.jsp"></jsp:include>
		
		<!--  Header -->
		
		<!--  Form -->
	<div class="container">
		<spring:url value="/stock/addStocks/" var="saveURL"/>
		<h2><center>Stocks Registration</center></h2>
		<form:form modelAttribute="stocks" method="post" action="${saveURL }" cssClass="form">
		<form:hidden path="idPurchasedStock"/>
		
		<div class="form-group">
		<label>Payment ID</label>
		<form:input path="paymentID" cssClass="form-control" id="paymentID" required = "required"/>
		</div>
		
		<div class="form-group">
		<label>Quantity</label>
		<form:input path="quantity" cssClass="form-control" id="quantity" type="number" required = "required"/>
		</div>
		
		<div class="form-group">
		<label>Purchase Date</label>
		<form:input path="purchaseDate" cssClass="form-control" id="purchaseDate" type ="date" required = "required"/>
		</div>		
		
		<input type="submit" id="save"class="btn btn=primary" value="Save">
		
		</form:form>
	</div>
	<!--  Form -->
	 <div class="footer">
		<jsp:include page="../views/SupFooter.jsp"></jsp:include>
	</div>
</body>
</html>
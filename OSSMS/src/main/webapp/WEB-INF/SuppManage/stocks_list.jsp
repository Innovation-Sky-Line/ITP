<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
		
<head>


<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
table{
	left : 100px;
}
#tab{
	right : 100px;
	width : 85%;

}
.body{
	position : absolute;
	left : 210px;
	width : 85%;
	top : 230px;
}
#save{
background-color: #4CAF50;
text-align: center;

}
</style> 
	
<title>Stocks Details.</title>
</head>

<body>
	
		<!--  Header -->
		
		<jsp:include page="../views/SupHeader.jsp"></jsp:include>
		<jsp:include page="../views/SupmanageSidebar.jsp"></jsp:include>
		
		<!--  Header -->
	
		<!--  Data Retrieved Display Table Start-->
	<h2><center>Registered Stock List</center></h2>
<div style="overflow-x:auto;" class="body">
	<table id ="tab" class="table table-dark table-hover">
		<tbody>
		
			<tr>
				<td>Stock ID</td>
				<td>Payment ID</td>
				<td>Quantity</td>
				<td>Purchased Date</td>
				
			</tr>
			<c:forEach items="${stocksList }" var="stocks">
			<tr>
				<td>${stocks.idPurchasedStock}</td>
				<td>${stocks.paymentID}</td>
				<td>${stocks.quantity}</td>
				<td>${stocks.purchaseDate}</td>
				<td>
					<spring:url value="/stock/updateStocks/${stocks.idPurchasedStock}" var="updateURL"/>
					<a id="save" class="btn btn-primary" href="${updateURL }" role="button" >Update</a>
				</td>
				<td>
					<spring:url value="/stock/deleteStocks/${stocks.idPurchasedStock}" var="deleteURL"/>
					<a id="save" class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		
		
		<spring:url value="/stock/stockform" var="addURL"/>
					<a id="save" class="btn btn-primary" href="${addURL }" role="button" >Add New Stock</a>

</div>
		<!--  Data Retrieved Display Table End-->
<div class="footer">
		<jsp:include page="../views/SupFooter.jsp"></jsp:include>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">
.body {
	position: absolute;
	left: 200px;
	width: 40%;
	top: 250px;
}

.footer {
	position: relative;
	top: 800px;
}

.sideBox {
	position: absolute;
	width: 8%;
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
	background: #2196F3;
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

.listBtn:hover {
	background: green;
}

form.example button:hover {
	background: green;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}

.dropbtn {
	border-radius: 25px;
	background-color: #0b7dda;
	color: white;
	padding: 13px;
	font-size: 14px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.title {
	width: 60%;
	height: 40%;
	text-align: center;
}

.logo_container {
	height: 85%;
	display: table;
}

.sidebtn {
	background-color: #000080;
	opacity: 1.3;
	border: none;
	color: white;
	padding: 40px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	border-radius: 10%;
	transition-duration: 0.4s;
}

.active, .sidebtn:hover {
	background-color: blue;
	color: white;
}

.repobtn {
	border-radius: 25px;
	background-color: #0b7dda;
	color: white;
	padding: 13px;
	font-size: 14px;
	border: none;
	cursor: pointer;
}

.active, .repobtn:hover {
	background-color: blue;
	color: white;
}

.sideBox1 {
	position: absolute;
	left: 500px;
}
</style>
<meta charset="ISO-8859-1">
<title>Product Administration.</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<jsp:include page="../views/P_report_sidebar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->
	<br>
	<div class="sideBox1">
		<a href="/padmin/proReport"><button class="repobtn">Insufficient
				Products</button></a> <a href="#"><button class="repobtn active">Discounted
				Products</button></a>
	</div>

	<div class="sideBox">
		<div class="dropdown">
			<button class="dropbtn">Print Reports</button>
			<div class="dropdown-content">
				<a href="/padmin/exportProductPdf">Insufficient Products</a> <a
					href="/padmin/disExportProductPdf">Discounts</a>
			</div>
		</div>

	</div>


	<div class="body">

		<div class="container" style="font-size: 15px;">
			<h2>Products With discounts.</h2>
			<table class="table table-dark table-hover">
				<thead>

					<th scope="row">#ID</th>
					<th scope="row">Product Name</th>
					<th scope="row">Price(LKR)</th>
					<th scope="row">Discount(%)</th>
					<th scope="row">Final Price(LKR)</th>
					<th scope="row">Current Stock</th>
					<th scope="row">Supplier ID</th>
					<th scope="row">Supplier Name</th>
					<th scope="row">Category ID</th>
					<th scope="row">Category Name</th>

				</thead>
				<tbody>
					<c:forEach items="${discounted }" var="p">
						<tr>
							<td>${p.productModel.idProduct }</td>
							<td>${p.productModel.productName }</td>
							<td>${p.productModel.price }</td>
							<c:set var="price" value="${p.productModel.price }"></c:set>
							<td>${p.productModel.discount }</td>
							<c:set var="dis" value="${p.productModel.discount }"></c:set>
							<c:set var="fPrice" scope="page" value="${price-price*dis/100 }"></c:set>
							<td><c:out value="${fPrice }"></c:out></td>
							<td>${p.productModel.currentStock }</td>
							<td>${p.productModel.supplierId }</td>
							<td>${p.supplier.supplierName }</td>
							<td>${p.productModel.categoryId }</td>
							<td>${p.categoryModel.categoryName  }</td>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>
	<!-- End of Your Parts!!! -->

</body>
</html>
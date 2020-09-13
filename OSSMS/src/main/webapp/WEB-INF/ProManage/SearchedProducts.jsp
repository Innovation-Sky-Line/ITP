<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<style type="text/css">

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

</style>
</head>
<body>
<jsp:include page="../views/Header.jsp"></jsp:include>
<div class = "sideBox">
		<form:form class="example" action="" style="margin:auto;right:2px;max-width:550px">
  			<input type="text" placeholder ="Search.." name="search2">
  			<button type="submit"><i class="fa fa-search"></i></button>
		</form:form>
		<a href="/padmin/proManage"><button class="listBtn">Add New Products</button></a>
	</div>
	<div class="container">
		<h2>Product List</h2>
		<table class="table table-striped">
			<thead>
				
				<th scope="row">#ID</th>
				<th scope="row">Product Name</th>
				<th scope="row">Price</th>
				<th scope="row">Discount</th>
				<th scope="row">Current Stock</th>
				<th scope="row">Image</th>
				<th scope="row">Supplier ID</th>
				<th scope="row">Category ID</th>
				<th scope="row">Buying Limit</th>
			</thead>
			<tbody>
				<c:forEach items="${SearchedroductList }" var="product">
					<tr>
						<td>${product.idProduct }</td>
						<td>${product.productName }</td>
						<td>${product.price }</td>
						<td>${product.discount }</td>
						<td>${product.currentStock }</td>
						<td>${product.productImage }</td>
						<td>${product.supplierId }</td>
						<td>${product.categoryId }</td>
						<td>${product.buyingLimit }</td>
						
						<td><spring:url value="/padmin/updateProduct/${product.idProduct }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url value="/padmin/deleteProduct/${product.idProduct }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/padmin/proManage" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add
			New Product</a>
	</div>
</body>
</html>
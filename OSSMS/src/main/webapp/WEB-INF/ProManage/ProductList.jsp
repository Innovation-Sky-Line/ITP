<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
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
				<c:forEach items="${productList }" var="product">
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
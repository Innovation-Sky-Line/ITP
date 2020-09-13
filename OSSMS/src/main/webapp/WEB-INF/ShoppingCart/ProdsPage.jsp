<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
</head>
<style>
	#prod{
		border-collapse:collapse;
		margin-left:30%;
		margin-top: 5%; 
		font-size:20px;
	}
	#prod tr{
		height:40px;
	}
	#prod td{
		padding: 10px;
		text-align:center;
	}
	
</style>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	
	<table>
		<form:form action="/search" method="POST">
		<tr>
			<td><input type="text" name="search" /></td>
			<td><button type="submit"><i class="fas fa-search fa-1x"></i></button></td>
		</tr>
		</form:form>
	</table>
	
	<table id="prod" border="1">
		<tr>
			<td>Product</td>
			<td>Price</td>
			<td>Discount</td>
			<td></td>
			<td>Add to Cart</td>
		</tr>
		<c:forEach var="prod" items="${prods }">
		<form:form action="/addToCart" method="POST">
		<tr>
			<td>${prod.productName }</td>
			<td>${prod.price }</td>
			<td>${prod.discount }</td>
			<td><input type="text" name="qty" /><input type="text" name="orderId" value="${order }" hidden/>
			<input type="text" name="prodId" value="${prod.productId }" hidden/>
			</td>
			<td><input type="submit" value="Add" /></td>
		</tr>
		</form:form>
		</c:forEach>
	</table>
	<p>${sessionScope.orderId }</p>
</body>
</html>
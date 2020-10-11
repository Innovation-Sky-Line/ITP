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
			<td>Image</td>
			<td>Product</td>
			<td>Price</td>
			<td>Discount</td>
			<td>Add to Cart</td>
		</tr>
		<c:forEach var="prod" items="${prods }">
		<form:form action="/addToCart" method="POST">
		<tr>
			<td><img src="${prod.img }" style="width:50px; height:50px;" /></td>
			<td>${prod.productName }</td>
			<td>${prod.price }</td>
			<td>${prod.discount }</td>
			<td>
				<input type="text" name="prodId" value="${prod.productId }" hidden/>
				<input type="submit" onclick="return addedToCart()" value="Add" />
			</td>
		</tr>
		</form:form>
		</c:forEach>
	</table>
	<p>${sessionScope.orderId }</p>
	<form action="/cart" method="post">
		<input type="submit" value="Cart" />
	</form>
</body>
<script>
	function addedToCart(){
		var con = confirm("Added to Cart");
		if(con)
			return true;
		else 
			return false;
	}
</script>
</html>
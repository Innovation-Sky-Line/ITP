<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/billStyle.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
<title>Detailed Bill</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>

	<div class="main_content">
		<div class="main_table">
			<table class="shop-more">
				<tr>
					<td><a href="/pastOrders"><i class="fas fa-arrow-left fa-2x"></i></a></td>
					<td><a href="/pastOrders"><h3>Back to Orders</h3></a></td>
				</tr>
			</table>
			<h1>Your Bill</h1>
			<table id="cart">
				<tbody>
					<tr>
						<th width="40%">Product Name</th>
						<th width="20%">Qty</th>
						<th width="20%">Price</th>
					</tr>
					<c:set var="total" value="0"></c:set>
					<c:forEach var="cart" items="${userCart }">
					<c:set var="total" value="${total + cart.price }"></c:set>
					<tr>
						<td class="prod">${cart.prodName }</td>
						<td class="prod">${cart.qty }</td>
						<td class="prod">${cart.price }</td>
					</tr>
					</c:forEach>
					<tr>
						<td id="last-row">Total</td>
						<td id="last-row">&nbsp;</td>
						<td id="last-row">${total }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders for Month</title>
</head>
<body>

	<table border="1" style="padding:5px;">
		<tr>
			<th>Order ID</th>
			<th>Order Date</th>
			<th>Action</th>
		</tr>
		<c:forEach var="order" items="${orders1 }">
			<tr>
				<td>${order.orderId }</td>
				<td>${order.date }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
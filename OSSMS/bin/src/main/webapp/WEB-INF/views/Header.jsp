<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/HeaderStyle.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
</head>
<body>

	<div id="cart_header_container">
		<table id="cart_header" width="100%">
			<tbody>
				<tr>
					<td id="header_logo" rowspan="2"><img id="img_header_logo"
						src="resources/images/logo.jpg"></td>
					<td id="header_title" rowspan="2"><h1>Athukorala Pvt.
							Ltd.</h1></td>
					<td id="header_proPic"><i class="fas fa-user-circle fa-3x"></i></td>
					<td id="header_uname">Username</td>
				</tr>
				<tr>
					<td id="header_cart"><spring:url value="/cart"
								var="cartURL" /><a href="${cartURL }"><i class="fas fa-shopping-cart fa-2x"></i></a></td>
					<td id="header_logout"><button id="btn-logout">Log Out</button></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>
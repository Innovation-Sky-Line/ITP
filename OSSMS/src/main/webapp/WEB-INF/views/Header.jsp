<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
=======
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}

.header {
	width: 100%;
	height: 120px;
	display: block;
	color: white;
	background-color: #000080;
	opacity: 0.9;
}

.header table {
	table-layout: fixed;
	width: 100%;
}

.logo_container {
	height: 100%;
	display: table;
	float: left;
}

.logo_container h2 {
	height: 100%;
	display: table-cell;
	vertical-align: middle;
}

.func_name {
	margin: auto;
	width: 100%;
	border: 3px solid #73AD21;
	padding: 10px;
}

.func_name h1 {
	text_align: center;
	color: white;
}

.profile_container {
	height: 100%;
	width: 10%;
	display: table;
	float: right;
	display: table;
}

.button {
	background-color: blue;
	opacity: 1.3;
	border: none;
	color: white;
	padding: 10px 26px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 15%;
	transition-duration: 0.4s;
	cursor: pointer;
}

.button:hover {
	background-color: white;
	color: black;
}

.nav {
	width: 100%;
	height: 40px;
	display: block;
	color: white;
	background-color: black;
	opacity: 0.9;
}

.navtb {
	background-color: blue;
	opacity: 1.3;
	border: none;
	color: white;
	padding: 12px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 10px;
	border-radius: 15%;
	transition-duration: 0.4s;
}

.navtb:hover {
	background-color: black;
	color: white;
}
</style>
<script>
	function sure (){
		var con = confirm("Are you sure?");
		if (con){
			return true;
	
		}

		else {
			return false;	
		}
	}
</script>
>>>>>>> 340193a4bb63fae2b7bfe4ffcfe1d65360011e51
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/HeaderStyle.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
</head>
<body>
<<<<<<< HEAD

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
=======
	<div class="header">
		<table>
			<tr>
				<td>
					<div class="logo_container">
						<img src="../../resources/images/logo.jpg"><br>
						<p></p>
					</div>
				</td>
				<td>
					<div class="func_name">
						<h1>Product Admin Panel</h1>
					</div>
				</td>
				<td>
					<div class="profile_container">
						<span>Product Admin</span><br> <br>
						<form method="POST" action="#">
							<input type="submit" onclick="return sure()" class="button"
								value="Log out">
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="nav">
		<table>
			<tr>
				<td><a href="/padmin/proManage"><button class="navtb">Main
							Panel</button></a></td>
				<td><a href="/padmin/cphp"><button class="navtb">CPHP</button></a></td>

			</tr>
>>>>>>> 340193a4bb63fae2b7bfe4ffcfe1d65360011e51
		</table>
	</div>

</body>
</html>
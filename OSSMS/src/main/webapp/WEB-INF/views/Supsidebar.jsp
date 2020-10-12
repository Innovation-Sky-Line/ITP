<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title></title>
<style type="text/css">
.sideBar {
	width: 10%;
	height: 600px;
	display: block;
	border: 2px solid black;
	background-color: white;
	opacity: 0.9;
	padding: 15px;
}

.sidebtn {
	background-color: #000080;
	opacity: 1.3;
	border: none;
	color: white;
	padding: 20px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	border-radius: 1%;
	transition-duration: 0.4s;
}

.sidebtn:hover {
	background-color: blue;
	color: white;
}
</style>
</head>
<body>
	<div class="sideBar">
		<table>
			<!-- button 01 -->
			<tr>
				<td><a href="#"><button class="sidebtn">Supplier Control Panel</button></a></td>
			</tr>
			<!-- button 02 -->
			<tr>
				<td><a href="#"><button class="sidebtn">Supplier History</button></a></td>
			</tr>
			<!-- button 03 -->
			<tr>
				<td><a href="#"><button class="sidebtn">Stock Payments and Maintenance</button></a></td>
			</tr>
		</table>

	</div>
</body>
</html>
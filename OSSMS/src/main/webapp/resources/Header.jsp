<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 15%;
	transition-duration: 0.4s;
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
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div class="header">
		<table>
			<tr>
				<td>
					<div class="logo_container">
						<img src="logo.png"><br>
						<p>Athukotala SM Pvt. Ltd.</p>
					</div>
				</td>
				<td>
					<div class="func_name">
						<h1>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Admin
							Panel.</h1>
					</div>
				</td>
				<td>
					<div class="profile_container">
						<span>&nbsp &nbsp User
						</span><br>
						<br>
						<form method="POST" action="#">
							<input type="submit" class="button" value="Log out">
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="nav">
		<table>
			<tr>
				<td><a href="/Employee/form"><button type="button" class="btn btn-primary">Add Employee</button></a></td>
				<td><a href="/Employee/list"><button type="button" class="btn btn-primary"> Employee Info </button></a></td>
				<td><a href="/Employee/calSalary"><button type="button" class="btn btn-primary">Calculate  Salary </button></a></td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
</head>
<body>

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
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
</head>
<body>

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
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
</head>
<body>

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
		</table>
	</div>
</body>
</html>
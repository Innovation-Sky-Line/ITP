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
	height: 90%;
	display: table;
	float: left;
}

.logo_container h2 {
	height: 100%;
	display: table-cell;
	vertical-align: middle;
}

/*.func_name {
	margin: auto;
	width: 100%;
	padding: 10px;
}

.func_name h1 {
	text_align: center;
	color: white;
}*/
.sm_container {
	height: 100%;
	width: 10%;
	display: table;
	float: right;
	display: table;
}

.fa {
	padding: 10px;
	font-size: 15px;
	width: 20px;
	text-align: center;
	text-decoration: none;
	margin: 5px 2px;
}

.fa:hover {
	opacity: 0.7;
}

.fa-facebook {
	background: #3B5998;
	color: white;
}

.fa-twitter {
	background: #55ACEE;
	color: white;
}

.fa-google {
	background: #dd4b39;
	color: white;
}

.fa-linkedin {
	background: #007bb5;
	color: white;
}

.fa-youtube {
	background: #bb0000;
	color: white;
}
</style>

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
					<div class="">
						<p>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
							&nbsp Copyright &copy; INNOVATION SKYLINE 2020</p>
					</div>
				</td>
				<td>
					<div class="">
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp <a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-twitter"></a> <a href="#"
							class="fa fa-google"></a> <a href="#" class="fa fa-linkedin"></a>
						<a href="#" class="fa fa-youtube"></a>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
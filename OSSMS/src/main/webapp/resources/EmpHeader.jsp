<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=montserrat:400,800" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<title></title>

<style>

*{
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}

.header{
	width: 100%;
	height: 80px;
	display: block;
	background-color: #101010;
}

.inner_header{
	width: 1000px;
	height: 100%;
	display: block;
	margin: 0 auto;
}

.logo_container{
	height: 100%;
	display: table;
	float: left;
}

.logo_container h1{
	color: white;
	height: 100%;
	display: table-cell;
	vertical-align: middle;
	font-family: 'Montserrat';
	font-size: 32px;
}

.logo_container h1 span{
	font-weight: 800;
}

.navigation{
	//float: right;
	height: 100%;
}

.navigation a{
	height: 100%;
	display: table;
	float: left;
	//padding: 0px 20px;
}

.navigation a:last-child{
	padding-right: 0;	
}

.navigation a li{
	display: table-cell;
	vertical-align: middle;
	height: 100%;
	color: white;
	font-family: 'Montserrat';
	font-size: 16px;
}
</style>
	
	</head>
	
	
	
	
	
<body>
<div class="header">
		<div class="inner_header">
			<div class="logo_container">
				
		</div>
		
		<ul class="navigation">
			<a href="/Employee/form"><li> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Add Employee</li></a>
			<a href="/Employee/list"><li> &nbsp &nbsp &nbsp &nbsp Employee Info</li></a>
			
			
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
h2{
text-align:center;
}
</style>
<link rel="stylesheet" type="text/css" href="src/main/webapp/resources/css/main.css" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Employee Administration.</title>
</head>
<body>
<jsp:include page="../views/Header.jsp"></jsp:include>
	<jsp:include page="../views/EmpManageSideBar.jsp"></jsp:include>
<img src="../../resources/images/EMS2.png"  width="100%" height="300px">
<jsp:include page="../../resources/EmpHeader.jsp"></jsp:include>	

	<h1>Welcome To Employee Management Administration Page!</h1>
	<hr>
<br>
<br>
	
	<a href="/Employee/form"><button type="button" class="btn btn-primary">Add Employee</button></a>
	<a href="/Employee/list"><button type="button" class="btn btn-primary"> Employee Info </button></a>
	<a href="/Employee/AttReport"><button type="button" class="btn btn-primary"> Employee Report </button></a>
	


	<div class="bottom"><jsp:include page="../views/Footer.jsp"></jsp:include></div>

</body>
</html>
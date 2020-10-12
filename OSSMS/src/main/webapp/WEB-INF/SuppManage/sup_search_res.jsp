<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
		
<head>
<script>
			function sure(){
				var con = confirm("Are you sure?");
				if(con){
					return true;
					
				}else{
					return false;
				}
			}
			
		</script>
<style type="text/css">
.sideBox {
	position: absolute;
	width: 40%;
	height: 20%;
	right: 0px;
}

form.example input[type=text] {
	border-radius: 25px;
	padding: 10px;
	font-size: 17px;
	border: 2px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	opacity: 0.9;
	border-radius: 25px;
	width: 20%;
	padding: 1px;
	background: #0b7dda;
	color: white;
	font-size: 15px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

.listBtn {
	opacity: 0.9;
	border-radius: 25px;
	width: 20%;
	padding: 10px;
	background: #0b7dda;
	color: white;
	font-size: 12px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
	margin-left:30px;
}

form.example button:hover {
	background: Green;
}

.listBtn:hover {
	background: Green;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}
#tab{
	right : 100px;
	width : 85%;

}
.body{
	position : absolute;
	left : 210px;
	width : 85%;
	top : 230px;
}
#save{
background-color: #4CAF50;
text-align: center;

}
	

</style>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<!--  Bootstrap -->
 	 <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
  <!--  Bootstrap -->
  
	
<title>Supplier Details.</title>
</head>

<body>
	
		<!--  Header -->
		
		<jsp:include page="../views/SupHeader.jsp"></jsp:include>
		<jsp:include page="../views/SupmanageSidebar.jsp"></jsp:include>
		
		<!--  Header -->
	
		<!--  Data Retrieved Display Table Start-->
	<div class="sideBox">
		<form:form class="example" action="/supplier/searchSea" method="POST"
			style="margin:auto;right:2px;max-width:550px">
			<input type="text" placeholder="Search Suppliers.." name="suppliersea"
				required="required">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
		
	</div>
	<h2><center>Supplier Details List</center></h2>
<div style="overflow-x:auto;" class="body">
	<table id="tab" class="table table-dark table-hover">
		<tbody>
		
			<tr>
				<td>ID</td>
				<td>Supplier Name</td>
				<td>Address</td>
				<td>Email</td>
				<td>Contact Number</td>
				<td>Status</td>
				
			</tr>
			<c:forEach items="${supplierList }" var="supplier">
			<tr>
				<td>${supplier.idSupplier}</td>
				<td>${supplier.supplierName}</td>
				<td>${supplier.address}</td>
				<td>${supplier.email}</td>
				<td>${supplier.contactNo}</td>
				<td>${supplier.status}</td>
				<td>
					<spring:url value="/supplier/updateSupplier/${supplier.idSupplier}" var="updateURL"/>
					<a id="save" class="btn btn-primary" href="${updateURL }" role="button" >Update</a>
				</td>
				<td>
					<spring:url value="/supplier/deleteSupplier/${supplier.idSupplier}" var="deleteURL"/>
					<a id="save" class="btn btn-primary" href="${deleteURL }" role="button" onclick="return sure()">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>


		<!--  Data Retrieved Display Table End-->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">
.body {
	position: absolute;
	left: 200px;
	width: 80%;
	top: 250px;
}

.footer {
	position: relative;
	top: 848px;
}

.sideBox {
	top:0px;
	position: absolute;
	width: 60%;
	height: 10%;
	right: 0px;
	left:450px;
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
	width: 80%;
	padding: 10px;
	background: #008000;
	color: white;
	font-size: 12px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;

	
}

form.example button:hover {
	background:  #fad325;
	color:black;
}

.listBtn:hover {
	background: #fad325;
	color:black;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}

.custTR{
  background-color: blue;
  color:white;
}
</style>
<script>

function populate(s1,s2){
	var s1 = document.getElementById(s1);
	var s2 = document.getElementById(s2);
}



function validateForm(){
if( document.pFrom.price.value < 1 ) {
    alert( "Unit Price must not be 0 or less !!!" );
    document.pFrom.price.focus() ;
    return false;
 }else if( document.pFrom.supName.value == null ) {
    alert( "Select a Supplier !!!" );
    document.pFrom.supName.focus() ;
    return false;
 }
 else if( document.pFrom.catName.value == null ) {
	    alert( "Select a Category !!!" );
	    document.pFrom.catName.focus() ;
	    return false;
	 }
 
else if( document.pFrom.currentStock.value < 1 ) {
    alert( "# of Units must not be 0 or less !!!" );
    document.pFrom.currentStock.focus() ;
    return false;
 }
else if( document.pFrom.buyingLimit.value < 1 ) {
    alert( "Buying Limit must not be 0 or less !!!" );
    document.pFrom.buyingLimit.focus() ;
    return false;
 }
else if( document.pFrom.discount.value < 0 && document.pFrom.discount.value > 100) {
    alert( "Discount must be between 0-100% !!!" );
    document.pFrom.discount.focus() ;
    return false;
 }else
 return(true);
 
function sure(){
	var con = confirm("Are you sure?");
	if(con){
		return true;
		
	}else{
		return false;
	}
} 
 
 
}
</script>
<meta charset="ISO-8859-1">
<title>Vehicle List</title>
</head>
<body>
	<jsp:include page="../views/dHeader.jsp"></jsp:include>
	<jsp:include page="../views/dSideBar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->



	<div class="body">
	<div>
		<div class="sideBox">
		<a href="showNewVehiclePage"><button class="listBtn">Add New Vehicle</button></a>
		</div>
		
		<h2>Available Vehicles</h2>
		<table class="table table-dark table-hove">
			<thead>
				<tr class="custTR">
				<th scope="row">Vehicle ID</th>
				<th scope="row">Registration No</th>
				<th scope="row">Delete</th>
	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="v">
					<tr>
						<td>${v.idvehicle }</td>
						<td>${v.registrationno }</td>
						
						<td><spring:url value="/deleteVehicle/${v.idvehicle }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" onclick="return sure()" role="button" >Delete </a></td>
 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<!-- End of Your Parts!!! -->
	<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
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


<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<!--  Bootstrap -->
  	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
  <!--  Bootstrap -->
  
<style type="text/css">
.body {
	position: absolute;
	left: 200px;
	width: 40%;
	top: 200px;
}

.footer {
	position: relative;
	top: 848px;
}

.sideBox {
	position: absolute;
	width: 8%;
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
}

form.example button:hover {
	background: Green;
}

.title{
	
	width : 60%;
	height: 40%;
	text-align: center;
	
}
.listBtn:hover {
	background: Green;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}
</style>	
<title>Payment Report</title>
</head>

<body>
	
		<!--  Header -->
		
		<jsp:include page="../views/SupHeader.jsp"></jsp:include>
		
		<!--  Header -->
	
		<!--  Data Retrieved Display Table Start-->
		<div class = "sideBox">
	<spring:url value="/payment/payform" var="addURL"/>
					<a href="/payment/export/" id="save" class="btn btn-primary" href="${addURL }" role="button" >Print Report</a></div>
	<div class = "title" style ="margin : auto">
		<img src="../../resources/images/logo.jpg"><br>
		<h3>Athukorala SuperMarket PVT. LTD.</h3>
		<h4>Supplier Payment Report</h4>
		<p>T.P : +94 68-222 22 54/ +94 76 324 45 66 | FAX : 87686756778 | Email : athukoralasm@gmail.com </p>
		<br><br>
	</div>	
<div style="overflow-x:auto;">
	<form:form method="POST" action="/payment/generatepayreport">
		<input type="date" name="date" />
		<button type="submit">Generate Report</button>
	</form:form>
	<table class="table table-dark table-hover">
		<tbody>
		
			<tr>
				<td>ID</td>
				<td>Product ID</td>
				<td>PaymentDate</td>
				<td>Amount</td>
				<td>Type</td>
				
				
				
				
			</tr>
			<c:set var="payments" value="${paymentsList }"></c:set>
			<c:if test="${not empty paymentsList }">
				<c:forEach items="${paymentsList }" var="paymentss">
				<tr>
					<td>${paymentss.idPayment}</td>
					<td>${paymentss.prodId}</td>
					<td>${paymentss.paymentDate}</td>
					<td>${paymentss.amount}</td>
					<td>${paymentss.type}</td>
					
				
				</c:forEach>
			</c:if>
		</tbody>
		</table>
		</div>
		
		


		<!--  Data Retrieved Display Table End-->

</body>
</html>
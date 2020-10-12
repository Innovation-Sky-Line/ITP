<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="resources/css/complete.css" />
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}
.footer {
	position: relative;
	top: 848px;
}


.body {
	position: absolute;
	left: 210px;
	width: 40%;
	top: 180px;
	
}

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

.btnCom{

	background-color: #5cb85c;

}
</style>
<meta charset="ISO-8859-1">
<title>Complete Orders</title>
</head>
<body>
	<jsp:include page="../views/OrderHeader.jsp"></jsp:include>
	<jsp:include page="../views/OrderSideBar.jsp"></jsp:include>
<div class="sideBox">
		<form:form class="example" action="/searchCompleteOrders" method="POST"
			style="margin:auto;right:2px;max-width:550px">
			<input type="text" placeholder="Search Orders.." name="status"
				required="required">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
	
	</div>
	
<div class="body" >
	<h2 class="h">Complete Orders</h2>
	

<div class="main_content"> 	
<h4>Recently Complete Orders........</h4>
<br>

 <table class="w3-table-all">
    <thead>
      <tr class="w3-light-grey">
        <th>Order ID</th>
        <th>Date</th>
        <th>Customer name</th>
        <th>Action of Order</th>
      </tr>
    </thead>
		<c:forEach var="order" items="${orderList}">
		<tr>
		<form action="/bill" method="post">
			<td>${order.orderId}<input type="text" value="${order.orderId}"
					name="orderId" hidden /></td>
			<td>${order.date}</td>
			<td>${order.name}</td>
			<td><button type="submit" class="btnCom" >VIEW DETAILS</button></td>
		</form>
		</tr>
		</c:forEach> 
	</tbody>
</table>
</div>
</div>


	<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
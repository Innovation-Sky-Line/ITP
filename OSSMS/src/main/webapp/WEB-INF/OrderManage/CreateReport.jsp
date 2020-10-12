<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

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
	top: 650px;
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
.title{
	
	width : 60%;
	height: 40%;
	text-align: center;
	
}

.main_content{
	margin-right:1%;
	margin-top: 2.5%;
	width: 98.5%;
	height: 600px;
	padding: 10px;
}
table {
  border-collapse: collapse;
  width: 100%;
  left :300px;
 
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
.btnCom{

	background-color: #5cb85c;

}
.t{
	left:300px;
}
</style>
<meta charset="ISO-8859-1">
<title>Reports</title>
</head>
<body>
	<jsp:include page="../views/OrderHeader.jsp"></jsp:include>
	<jsp:include page="../views/OrderSideBar.jsp"></jsp:include>
		


		<div class = "title" style ="margin : auto">
		<img src="../../resources/images/logo.jpg"><br>
		<h3>Athukorala SuperMarket PVT. LTD.</h3>
		<h4>Complete Order Information Report</h4>
		<p>T.P : +94 68-222 22 54/ +94 76 324 45 66 | FAX : 87686756778 | Email : athukoralasm@gmail.com </p>
		<br><br>
	</div>
	
	<div class="body" >
<div class="main_content"> 
<br><br><br><br><br>
<br><br><br><br><br><br>
<div class="t">
	<table class="w3-table-all" style="color: black;">
		<thead>
			<tr class="w3-light-grey">
				<th>Order ID</th>
				<th>Date</th>
				<th>Action of Order</th>
			</tr>
		</thead>
		<c:forEach var="order" items="${orders1 }">
			<tr>
				<form action="/bill" method="post">
					<td>${order.idOrder }<input type="text"
						value="${order.idOrder }" name="orderId" hidden /></td>
					<td>${order.date }</td>
					<td><button type="submit" class="btnCom">VIEW DETAILS</button></td>
				</form>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
</div>

	<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>

</body>
</html>
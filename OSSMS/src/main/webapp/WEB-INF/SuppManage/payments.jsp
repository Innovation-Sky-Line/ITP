<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />

<meta charset="ISO-8859-1">

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
.footer {
	position: relative;
	top: 848px;
}

#save{
background-color: #4CAF50;
text-align: center;

}

</style>
<title>Supplier Payments Form.</title>
</head>
<body>

		<!--  Header -->
		
		<jsp:include page="../views/SupHeader.jsp"></jsp:include>
		<jsp:include page="../views/SupmanageSidebar.jsp"></jsp:include>
		
		<!--  Header -->
	
	<div class="body">

		<spring:url value="/payment/addpayments/" var="saveURL"/>
		<h2>Payments Details Form</h2>
		<form:form modelAttribute="paymentss" method="post" action="${saveURL }" cssClass="form">
		<form:hidden path="idPayment"/>
		
		<div class="form-group">
		<label>Product ID</label>
		<form:input path="prodId" cssClass="form-control" id="prodId" type="number" required = "required"/>
		</div>
		
		<div class="form-group">
		<label>Amount</label>
		<form:input path="amount" cssClass="form-control" id="amount" type="number" required = "required"/>
		</div>
		
		<div class="form-group">
		<label>Payment Type</label>
		<form:select path="type" cssClass="form-control" id="type" required = "required">
		<form:option value = "Credit">Credit</form:option>
			<form:option value = "Debit">Debit</form:option>
			</form:select>
		</div>
		
		<div class="form-group">
		<label>Payment Date</label>
		<form:input path="paymentDate" cssClass="form-control" id="paymentDate" type="date"/>
		</div>
		
		
		<input type="submit" id="save"class="btn btn=primary" value="Save">
		
		</form:form>

	</div>
	<!-- End of Your Parts!!! -->
<div class="footer">
		<jsp:include page="../views/SupFooter.jsp"></jsp:include>
	</div>	
</body>
</html>
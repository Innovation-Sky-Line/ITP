<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!--  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />-->

<!-- <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">>-->

<!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">-->

<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>

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
.form-group>label {
  bottom: 34px;
  left: 15px;
  position: relative;
  background-color: white;
  padding: 0px 5px 0px 5px;
  font-size: 1.1em;
  transition: 0.2s;
  pointer-events: none;
}

.form-control:focus~label {
  bottom: 55px;
}

.form-control:valid~label {
  bottom: 55px;
}
.btn {
  position: relative;

  display: block;
  margin: 30px auto;
  padding: 0;

  overflow: hidden;

  border-width: 0;
  outline: none;
  border-radius: 2px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, .6);
  
  background-color: #2ecc71;
  color: #ecf0f1;
  
  transition: background-color .3s;
}

.btn:hover, .btn:focus {
  background-color: #27ae60;
}

.btn > * {
  position: relative;
}

.btn span {
  display: block;
  padding: 12px 24px;
}

.btn:before {
  content: "";
  
  position: absolute;
  top: 50%;
  left: 50%;
  
  display: block;
  width: 0;
  padding-top: 0;
    
  border-radius: 100%;
  
  background-color: rgba(236, 240, 241, .3);
  
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

.btn:active:before {
  width: 120%;
  padding-top: 120%;
  
  transition: width .2s ease-out, padding-top .2s ease-out;
}

/* Styles, not important */
*, *:before, *:after {
  box-sizing: border-box;
}

.btn.orange {
  background-color: #e67e22;
}

.btn.orange:hover, .btn.orange:focus {
  background-color: #d35400;
}

.btn.red {
  background-color: #e74c3c;
}

.btn.red:hover, .btn.red:focus {
  background-color: #c0392b;
}
</style>
<meta charset="ISO-8859-1">
<title>Customer Admin</title>
</head>
<body >
	<jsp:include page="../views/C_Admin_Header.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->

	<div class="body">	
		<form action="/customer/getlist">
		<div class="container" style="margin-left:-175px" >
			
		      <div class="row">
                  <div class="col-md-6">
                     <div class="form-group">
                      <input type="text" class="form-control" name="fname" id="usr" required>
		        	  <label for="usr">First Name</label>
                     </div>
                  </div>
                  <div class="col-md-6" style="margin-left:-150px">
                     <div class="form-group" style="margin-top:-28px" >
                      <button type="submit" class="btn btn-primary pull-right"style="padding-left:10px;padding-right:10px;padding-top:5px;padding-bottom:5px">Search</button>
                     </div>
                  </div>
              </div>

		</div>
		</form>
		<c:set var="sucess" value="${requestScope['sucess']}"/>
              		<c:choose>
			        <c:when test="${empty sucess}">
			        </c:when>
			        <c:otherwise>
        <div class="container" style="font-size:14px;margin-left:-175px">
				  <h2>Search Result</h2>
					<table class="table table-striped">
					<thead>
                      <th scope="row">ID</th>
                      <th scope="row">FirstName</th>
                      <th scope="row">LastName</th>
                      <th scope="row">Email</th>
                      <th scope="row">Button</th>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${list }">
                    	<tr>
                    		<td>${customer.idCustomer }</td>
                    		<td>${customer.firstName }</td>
                    		<td>${customer.lastName }</td>
                    		<td>${customer.email }</td>
                    		<td>
                    		<form:form action="/customer/customerreport" methos="POST">
                    		<input type="hidden" name="customerId" value="${customer.idCustomer  }"  />
                    		
                    		<button type="submit" class="btn btn-primary" style="background:green;margin: 10px 5px 10px 5px;padding-left:10px;padding-right:10px;" >view</button>
                    		
                    		</form:form>
                    		</td>
                    	</tr>
                    </c:forEach>
                    </tbody>
                  </table>
		</div>
		</c:otherwise>
	    </c:choose>
	    
	    <!-- second method -->
	    <c:set var="sucess" value="${requestScope['report']}"/>
              		<c:choose>
			        <c:when test="${empty report}">
			        </c:when>
			        <c:otherwise>
                  <a href="/customer/CustomerAdminDashbord">
                  
                  <button type="button" class="btn btn-primary" style="background:green;margin: 10px 5px 10px 5px;padding-left:10px;padding-right:10px;margin-left:-150px" >Back to Admin</button>
                  
                  </a>			        
        <div class="container" style="font-size:14px;margin-left:-175px">
				  <h2>Payment History</h2>
					<table class="table table-striped">
					<thead>
                      <th scope="row">Payment id</th>
                      <th scope="row">Date</th>
                      <th scope="row">Method</th>
                      <th scope="row">Amount</th>
                    </thead>
                    <tbody>
                    <c:forEach var="payments" items="${payments }">
                    	<tr>
                    	
                    		<td>${payments.paymentId }</td>
                    		<td>${payments.date }</td>
                    		<td>${payments.type }</td>
                    		<td>${payments.amount }</td>
                  		
                    	</tr>
                    	
                    </c:forEach>
                    	<tr style="background:#8F757D;font-weight:bold;border-top: 3px solid black;">
                    		<td></td>
                    		<td></td>
                    		<td>total</td>
                    		<td>${total}</td>
                    	</tr>
                    </tbody>
                  </table>

		</div>
		</c:otherwise>
	    </c:choose>
	    
	</div>
	<!-- End of Your Parts!!! -->
	<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/pastOrderstyles.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
<title>Previous Orders</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	
	<div class="main_content"> 	  
  		<div class="main_table">
  		<table class="shop-more">  		
  			<tr><td><a href="#"><i class="fas fa-arrow-left fa-2x"></i></a></td>
  			<td></td>
  			<td><a href="#"><h3>Back to Profile</h3></a></td></tr>
  		</table>
  		<h1>Your Previous Orders</h1>
	 	 <table id="orders">
	  	  <tbody>
	  	  
	      <tr>
	      	<th width="20%">Order ID</th>
	        <th width="20%">Date</th>
	        <th width="20%">Total Price</th>
	        <th width="20%">Action</th>
          </tr>          
          <c:forEach var="order" items="${pastOrders }">
	      <tr>
	     	<td class="prod">${order.order.orderId }</td>
	        <td class="prod">${order.order.date }</td>
	        <td class="prod">${order.total }</td>
	        <td class="prod">
	        <form:form action="/detailedBill" method="POST">
	        	<input type="text" name="orderId" value="${order.order.orderId }" hidden />
	        	<input type="submit" id="btn_details" value="VIEW BILL" />
	        </form:form>
	        </td>
          </tr>
          </c:forEach>          
        </tbody>
    	</table>
 		</div>
	</div>
		

</body>
</html>
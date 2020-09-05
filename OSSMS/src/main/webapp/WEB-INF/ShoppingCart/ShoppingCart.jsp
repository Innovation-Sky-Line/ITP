<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/cartStyle.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
<title>Shopping Cart</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<div class="main_content"> 	  
  		<div class="main_table">
  		<table class="shop-more">  		
  			<tr><td><i class="fas fa-arrow-left fa-2x"></i><td></td><td><h3>Shop More</h3></td></tr>
  		</table>
  		<h1>Your Cart</h1>
	 	 <table id="cart">
	  	  <tbody>
	      <tr>
	        <th width="40%">Product Name</th>
	        <th width="20%">Qty</th>
	        <th width="20%">Price</th>
	        <th width="20%">Remove</th>
          </tr>
          <c:forEach items="${userCart }" var="cart">
	      <tr>
	        <td class="prod" style="text-align:center;">${cart.prodName }</td>
	        <td class="prod" style="text-align:center;">
	        	<a href="/increment/${cart.orderId }"><i class="fas fa-minus"></i></a>&nbsp; 
	        	${cart.qty }&nbsp; 
	        	<a href="/decrement/${cart.orderId }"><i class="fas fa-plus"></i></a>
	        </td>
	        <td class="prod" style="text-align:center;">${cart.price }</td>
	        <td class="prod" style="text-align:center;"><i class="fas fa-trash-alt fa-1x"></i></td>
          </tr>
          </c:forEach>
          <form:form action="/userpay" method="POST">
          <tr>          
	        <td id="last-row">Total</td>
	        <td id="last-row">&nbsp;</td>
	        <td id="last-row"><input type="text" name="total" value="${total }" readonly></td>
	        <td id="last-row">&nbsp;</td>
          </tr>
          <tr>
          	<td id="btn-row" colspan="4"><input id="btn_checkout" type="submit" value="CHECKOUT"></td>
          </tr>
          </form:form>
        </tbody>
    	</table>
 		</div>
	</div>

</body>
</html>
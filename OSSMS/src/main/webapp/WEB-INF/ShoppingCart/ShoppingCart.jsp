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
          <c:set var="total" value="0"></c:set>
          <c:set var="orderId" value="0"></c:set>
          <c:forEach items="${userCart }" var="cart">
          <c:set var="total" value="${total + cart.price }"></c:set>
          <c:set var="orderId" value="${cart.orderId }"></c:set>
	      <tr>
	        <td class="prod" style="text-align:center;">${cart.prodName }</td>
	        <td class="prod" style="text-align:center;">
	        	<table style="margin-left:25%"><tr><td>
		        	<form:form action="/decrementCart" method="POST">
		        	<input type="text" name="orderId" value="${cart.orderId }" hidden/>
		        	<input type="text" name="prodId" value="${cart.prodId }" hidden/>
		        	<button class="cart_btns" type="submit"><i class="fas fa-minus"></i></button>
		        	</form:form> </td>
		        	<td>${cart.qty }&nbsp;</td> 
		        	<td><form:form action="/incrementCart" method="POST">
		        	<input type="text" name="orderId" value="${cart.orderId }" hidden/>
		        	<input type="text" name="prodId" value="${cart.prodId }" hidden/>
		        	<button class="cart_btns" type="submit"><i class="fas fa-plus"></i></button>
		        	</form:form></td>
	        	</tr></table>
	        </td>
	        <td class="prod" style="text-align:center;">${cart.price }</td>
	        <form:form action="/deleteCartItem" method="POST">
	        	<input type="text" name="orderId" value="${cart.orderId }" hidden/>
		        <input type="text" name="prodId" value="${cart.prodId }" hidden/>
	        	<td class="prod" style="text-align:center;"><button class="cart_btns" type="submit"><i class="fas fa-trash-alt fa-1x"></i></button></td>
	        </form:form>
          </tr>
          </c:forEach>
          <form:form action="/userpay" method="POST">
          <tr>          
	        <td id="last-row">Total</td>
	        <td id="last-row">&nbsp;</td>
	        <td id="last-row">${total }</td>
	        <td id="last-row"><input type="text" name="total" value="${total }" hidden/>
	        				<input type="text" name="orderId" value="${orderId }" hidden/>	</td>
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
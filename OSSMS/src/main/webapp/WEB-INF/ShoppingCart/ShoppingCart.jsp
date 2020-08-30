<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/cartStyles.css" />
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
	      <tr>
	        <td class="prod">&nbsp;</td>
	        <td class="prod">&nbsp;</td>
	        <td class="prod">&nbsp;</td>
	        <td class="prod" style="text-align:center;"><i class="fas fa-trash-alt fa-2x"></i></td>
          </tr>
          <tr>
	        <td id="last-row">Total</td>
	        <td id="last-row">&nbsp;</td>
	        <td id="last-row">&nbsp;</td>
	        <td id="last-row">&nbsp;</td>
          </tr>
          <tr>
          	<td id="btn-row" colspan="4"><input id="btn_checkout" type="submit" value="CHECKOUT"></td>
          </tr>
          
        </tbody>
    	</table>
 		</div>
	</div>

</body>
</html>
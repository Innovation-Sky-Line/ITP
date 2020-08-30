<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/pastOrderStyles.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
<title>Previous Orders</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	
	<div class="main_content"> 	  
  		<div class="main_table">
  		<table class="shop-more">  		
  			<tr><td><i class="fas fa-arrow-left fa-2x"></i><td></td><td><h3>Back to Profile</h3></td></tr>
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
	      <tr>
	     	<td class="prod">&nbsp;</td>
	        <td class="prod">&nbsp;</td>
	        <td class="prod">&nbsp;</td>
	        <td class="prod"><input id="btn_details" type="submit" value="VIEW BILL"></td>
          </tr>
          <tr>
          	<td class="prod">&nbsp;</td>
	        <td class="prod">&nbsp;</td>
	        <td class="prod">&nbsp;</td>
	        <td class="prod"><input id="btn_details" type="submit" value="VIEW BILL"></td>
          </tr>
          
        </tbody>
    	</table>
 		</div>
	</div>
		

</body>
</html>
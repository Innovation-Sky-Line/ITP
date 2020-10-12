<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/addressStyles.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
<title>Change Address</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	
	<div class="main_content"> 	  
  		<div class="main_table">
  		<table class="backToPayment">  		
  			<tr><td><i class="fas fa-arrow-left fa-2x"></i><td></td><td><h3>Back to Payment</h3></td></tr>
  		</table>
  		<h1>New Address</h1>
	 	 <table id="new-address">
	  	  <tbody>
	      <tr>
	        <td class="l-col">House Number</td>
	        <td><input type="text" id="hNo" /></td>
          </tr>
	      <tr>
	        <td class="l-col">Street Name</td>
	        <td><input type="text" id="strName" /></td>
          </tr>
          <tr>
	      	<td class="l-col">City</td>
	        <td><input type="text" id="city" /></td>
          </tr>
          <tr>
          	<td id="btn-row" colspan="2"><input id="btn_save" type="submit" value="SAVE"></td>
          </tr>
          
        </tbody>
    	</table>
 		</div>
	</div>

</body>
</html>
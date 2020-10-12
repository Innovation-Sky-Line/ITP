<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/bill.css" />  

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
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
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

</style>
<title>Bill Details</title>
</head>
<body>

	<jsp:include page="../views/OrderHeader.jsp"></jsp:include>
	<jsp:include page="../views/OrderSideBar.jsp"></jsp:include>
	
	<div class="body" >

		<div class="main_content"> 
  
  	<div class="main_table"> 


  		<h1>Details of Bill</h1>
	 	 <table >
	  	  <tbody>
	  	   
	      <tr>
	        <th >Product Name</th>
	        <th >Qty</th>
	        <th >Price</th>
          </tr>
           <c:set var="total" value="0"></c:set>
          <c:forEach var="pro" items="${cart }">
           <c:set var="total" value="${total + pro.price }"></c:set>
           
	      <tr>
	        <td >${pro.prodName}</td>
	        <td >${pro.qty}</td>
	        <td >${pro.price}</td>
          </tr>
          </c:forEach> 
          <tr>
	        <td id="last-row">Total :</td>
	        <td id="last-row">${total }</td>
	        </tr> 
          
          <tr>
          	<td id="btn-row"><a href="/list"><button type="button" id="btn_details">Back to orders</button></a></td>
          </tr>       
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
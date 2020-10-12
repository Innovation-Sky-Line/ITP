<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>
<style type="text/css">
.sideBar {
	position: absolute;
    width: 13%;
    height: 850px;
    border: 2px solid black;
    opacity: 0.9;
    padding: 15px;
	
}
body{
height: auto;
}

.sidebtn {
	background-color: #000080;
	opacity: 1.3;
	border: none;
	color: white;
	padding: 40px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	border-radius: 10%;
	transition-duration: 0.4s;
}

.active, .sidebtn:hover {
	background-color: blue;
	color: white;
}
</style>
</head>
<body>
	<div class="sideBar" id="sidebtns">
		<table>
			<!-- button 01 -->
			<tr>
				<td><a href="/supplier/form"><button class="sidebtn active">Add
							New Suppliers</button></a></td>
			</tr>
			<!-- button 02 -->
			<tr>
				<td><a href="/supplier/list"><button
							class="sidebtn">Complete Supplier List</button></a></td>
			</tr>
			<!-- button 03 -->
			<tr>
				<td><a href="/payment/payform"><button
							class="sidebtn">Register Payments</button></a></td>
			</tr>
			<!-- button 04 -->
			<tr>
				<td><a href="/stock/stockform"><button
							class="sidebtn">Stock Maintenance</button></a></td>
			</tr>
			<!-- button 05 -->
			<tr>
				<td><a href="/payment/reports"><button
							class="sidebtn">Generate Reports</button></a></td>
			</tr>
			
			
		</table>

	</div>


	<script type="text/javascript">
		//Get the container element
		var btnContainer = document.getElementById("sidebtns");

		// Get all buttons with class="btn" inside the container
		var btns = btnContainer.getElementsByClassName("sidebtn");

		// Loop through the buttons and add the active class to the current/clicked button
		for (var i = 0; i < btns.length; i++) {
			btns[i].addEventListener("click", function() {
				var current = document.getElementsByClassName("active");
				current[0].className = current[0].className.replace(" active","");						
				this.className += " active";
			});
		}
	</script>
	
	
</body>


</html>
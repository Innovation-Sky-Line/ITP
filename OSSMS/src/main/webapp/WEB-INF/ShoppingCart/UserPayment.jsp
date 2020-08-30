<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/userPayStyle.css" />
<link rel="stylesheet" href="resources/css/all.css"></link>
<title>Pay Here</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>

	<div class="main_content">
		<div class="main_table">
			<table class="backToCart">
				<tr>
					<td><i class="fas fa-arrow-left fa-2x"></i>
					<td></td>
					<td><h3>Back to Cart</h3></td>
				</tr>
			</table>
			<table id="payTable">
					<tbody>
						<form>
							<tr>
								<td  height="60px" class="table-left">Address</td>
								<td><textarea id="address" rows="4" cols="40"></textarea></td>
							</tr>
							<tr>
								<td id="address-row" colspan='2'><button id="changeAddress">Change Address</button></td>
							</tr>
							<tr>
								<td class="table-left">Select Payment Method</td>
								<td>
									<input type="radio" name="paymentMethod" value="Card" id="radio-pay">Card <br>
									<input type="radio" name="paymentMethod" value="Cash On Delivery" id="radio-pay">Delivery
								</td> 
							</tr>
							<tr>
								<td class="table-left">Enter Card Number</td>
								<td><input type="text" id="cardNumber"></td>
							</tr>
							<tr>
								<td class="table-left">Enter CVC Number</td>
								<td><input type="text" id="cvcNo"></td>
							</tr>
							<tr>
								<td class="table-left">Card Expiration Date</td>
								<td><input type="date" id="expDate"></td>							
							</tr>
							<tr>
								<td id="pay-row" colspan='2' id="last-row"><input type="submit" id="payBtn" value="Proceed With Payment"></td>
							</tr>
						</form>	
					</tbody>
			</table>
		</div>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<div class="main_content">
		<div class="main_table">
			<table class="backToCart">
				<tr>
					<td><a href="/cart"><i class="fas fa-arrow-left fa-2x"></i></a></td>
					<td></td>
					<td><a href="/cart"><h3>Back to Cart</h3></a></td>
				</tr>
			</table>
			<table id="payTable">
				<form:form action="/cusPayment" method="POST">
					<tbody>
						<tr>
							<td colspan="2" id="pay_logo"><img src="resources/images/logo.jpg" /></td>
						</tr>
						<tr>
							<td height="60px" class="table-left">Address</td>
							<td><input type="text" id="u_addr" name="address" value="${address }" disabled/></td>
						</tr>
						<tr>
							<td id="address-row" colspan='2' style="text-align: center">
								<input type="checkbox" id="chgAdd" onclick="showAddress()" />Change Address For this Delivery
							</td>
						</tr>
						<tr>
							<td class="table-left">Select Payment Method</td>
							<td><input type="radio" name="paymentMethod" value="Card"
								id="card" onclick="showCard()" checked>Card <br> 
								<input type="radio"
								name="paymentMethod" value="Cash On Delivery" id="cash" onclick="showCard()">Delivery
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div id="cardDetails">
								<table id="payTable">
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
								</table>
								</div>
							</td>
						</tr>
						<tr>
							<td class="table-left">Total Amount</td>
							<td><input type="text" name="orderId" value="${orderId }"
								hidden /><input type="text" name="total" readonly
								value="${totalPrice }"></td>
						</tr>
						<tr>
							<td id="pay-row" colspan='2' id="last-row"><input
								type="submit" id="payBtn" value="Proceed With Payment"></td>
						</tr>

					</tbody>
				</form:form>
			</table>
		</div>
	</div>

</body>
<script type="text/javascript">
	function showCard(){
		if(document.getElementById('card').checked){
			document.getElementById('cardDetails').style.display = 'block';
		}
		else
			document.getElementById('cardDetails').style.display = 'none';			
		return;
	}
	function showAddress(){
		if(document.getElementById('chgAdd').checked)
			document.getElementById('u_addr').disabled = false;
	}	
</script>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">

.body {
	position: relative;
	left: 200px;
	width: 40%;
	top : 40px;
}

.footer{
	 position:relative;
	 top: 105px;
}
</style>
<meta charset="ISO-8859-1">
<title>Product Administration.</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<jsp:include page="../views/P_sidebar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->
	<div class="body">
		<form action="">
			<label>Product Name : </label> <input type="text"> <br>
			<br> <label for="suppliers">Choose a supplier : </label> <select
				id="suppliers" name="suppliers">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="fiat">Fiat</option>
				<option value="audi">Audi</option>
			</select> <br>
			<br> <label for="category"> Category : </label> <select
				id="category" name="category">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="fiat">Fiat</option>
				<option value="audi">Audi</option>
			</select> &nbsp &nbsp &nbsp <label for="subcategory">Sub category : </label> <select
				id="subcategory" name="subcategory">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="fiat">Fiat</option>
				<option value="audi">Audi</option>
			</select><br>
			<br> <label>Unit Price : </label> <input type="Number">
			<br>
			<br> <label># of Units : </label> <input type="Number">
			<br>
			<br> <label>Buying Limit : </label> <input type="Number">
			<br>
			<br> <label>Discount Rate : </label> <input type="Number">
			<br>
			<br> <label for="img">Select image:</label> <input type="file"
				id="img" name="img" accept="image/*"><br><br>
			<div style="position: relative; left : 60px;" >
				<input type="reset">  &nbsp &nbsp &nbsp<input type="submit">
			</div>
		</form>
		</div>
	<!-- End of Your Parts!!! -->
	<div class = "footer">
	<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
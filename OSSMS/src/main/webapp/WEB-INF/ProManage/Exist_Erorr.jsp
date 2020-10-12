<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking Error</title>
<style type="text/css">
.errorContainer {
	margin-top: 200px;
	margin-left: 300px;
	width: 800px;
	height: 250px;
	background-color: red;
	border-radius: 20px;
	position: absolute;
}

h2 {
	text-align: center;
}

.backBtn {
	height: 40px;
	background-color: black;
	font-size: 15px;
	color: white;
	cursor: pointer;
	border-radius: 20px;
	margin: 0;
	position: absolute;
	left: 50%;
	top: 40%;
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}
</style>
</head>

<body>
	<div class="errorContainer">
		<div class="msg">
			<h2>Entered Product Already Exists in the Database!!!</h2>
		</div>
		<div class="backButton">
			<a href="/padmin/proManage"><button class="backBtn">&#8678;
					Re-Enter a Product</button></a>
		</div>
	</div>
</body>
</html>
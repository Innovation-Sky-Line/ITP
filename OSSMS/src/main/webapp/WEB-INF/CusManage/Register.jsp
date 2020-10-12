<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>Customer Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #fff;
	background-image: url("../../resources/images/unsplash-inside-mall.jpg");
	background-size: cover; 
	background-position: top center;
	font-family: 'Roboto', sans-serif;
}
.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}
.form-control:focus {
	border-color: #5cb85c;
}
.form-control, .btn {        
	border-radius: 3px;
}
.signup-form {
	width: 450px;
	margin: 0 auto;
	padding: 30px 0;
  	font-size: 15px;
}
.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}
.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}	
.signup-form h2:before {
	left: 0;
}
.signup-form h2:after {
	right: 0;
}
.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}
.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.signup-form .form-group {
	margin-bottom: 20px;
}
.signup-form input[type="checkbox"] {
	margin-top: 3px;
}
.signup-form .btn {        
	font-size: 16px;
	font-weight: bold;		
	min-width: 140px;
	outline: none !important;
}
.signup-form .row div:first-child {
	padding-right: 10px;
}
.signup-form .row div:last-child {
	padding-left: 10px;
}    	
.signup-form a {
	color: #fff;
	text-decoration: underline;
}
.signup-form a:hover {
	text-decoration: none;
}
.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}	
.signup-form form a:hover {
	text-decoration: underline;
}  
</style>
</head>
<body>

<div class="signup-form">
    <form:form action="/customer/addcustomer" method="POST" modelAttribute="customer"> 
		<h2>Register</h2>
        <div class="form-group">
			<div class="row">
				<div class="col"><input type="text" class="form-control" name="firstName" placeholder="First Name" required="required"></div>
				<div class="col"><input type="text" class="form-control" name="lastName" placeholder="Last Name" required="required"></div>
			</div>        	
        </div>
        <div class="form-group">
        	<input type="email" class="form-control" name="email" placeholder="Email"  required="required">
        </div>
         <div class="form-group">
               		<c:set var="exist" value="${requestScope['exist']}"/>
              		<c:choose>
			        <c:when test="${empty exist}">
			        </c:when>
			        <c:otherwise>
			             <div class="alert alert-warning alert-dismissible fade show" style="margin-top:10px">
		         	  		${exist }
						 </div>  
					</c:otherwise>
			    	</c:choose>		    
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="address" placeholder="address"  required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="contactNo" placeholder="Phone"  required="required">
		</div>
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username"  required="required">
        </div>
		<div class="form-group">
			<div class="row">
				<div class="col"><input type="password" class="form-control" name="password" placeholder="password"  required="required"></div>
				<div class="col"><input type="password" class="form-control" name="pass2"  placeholder="confirm password" required="required"></div>
			</div>
        </div> 
         <div class="form-group">
               		<c:set var="missmatch" value="${requestScope['missmatch']}"/>
              		<c:choose>
			        <c:when test="${empty missmatch}">
			        </c:when>
			        <c:otherwise>
			             <div class="alert alert-warning alert-dismissible fade show" style="margin-top:10px">
		         	  		${missmatch }
						 </div>  
					</c:otherwise>
			    	</c:choose>		    
        </div>
 
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form:form>
	<div class="text-center">Already have an account? <a href="login-page">Sign in</a></div>

</div>
</body>
</html>
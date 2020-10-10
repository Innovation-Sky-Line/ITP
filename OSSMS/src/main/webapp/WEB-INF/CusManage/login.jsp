<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
    <script src="../../resources/bootstrap/css/bootstrap.bundle.min.js"></script>
    <script src="../../resources/bootstrap/js/bootstrap.slim.min.js"></script>
    <link rel="stylesheet" href="../../resources/css/styleforlogin.css"></link>
  </head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Welcome to DDA Online services</h5>
            <form class="form-signin" action="/log/login" method="post">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
                <label for="inputPassword">Password</label>
              </div>

              <div class="custom-control custom-checkbox mb-3">
              <a href="forgotpassword">
                <label >forgot password</label>
              </a>
              </div>
              
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">
               <a href="Register">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="button" ><i class="fab fa-google mr-2"></i>Register</button>
              </a>
              		<c:set var="sucess" value="${requestScope['sucess']}"/>
              		<c:choose>
			        <c:when test="${empty sucess}">
			        </c:when>
			        <c:otherwise>
			             <div class="alert alert-warning alert-dismissible fade show" style="margin-top:10px">
		         	  		${sucess }
						 </div>  
					</c:otherwise>
			    	</c:choose>
			    	<c:set var="sucess" value="${requestScope['incorrect']}"/>
              		<c:choose>
			        <c:when test="${empty incorrect}">
			        </c:when>
			        <c:otherwise>
			             <div class="alert alert-warning alert-dismissible fade show" style="margin-top:10px">
		         	  		${incorrect }
						 </div>  
					</c:otherwise>
			    	</c:choose>
   
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
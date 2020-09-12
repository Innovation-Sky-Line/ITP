<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <form class="form-signin" th:action="@{/login}" method="post">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>

              <div class="custom-control custom-checkbox mb-3">
               
                <label >forgot password</label>
              
              </div>
              
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">
               <a href="Register">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="button" ><i class="fab fa-google mr-2"></i>Register</button>
              </a>
              <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="button"><i class="fab fa-facebook-f mr-2"></i>home</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
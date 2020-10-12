<!--
=========================================================
Material Kit - v2.0.7
=========================================================

Product Page: https://www.creative-tim.com/product/material-kit
Copyright 2020 Creative Tim (https://www.creative-tim.com/)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../../resources/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../../resources/assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Login - Page
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../../resources/assets/css/material-kit.css?v=2.0.7" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../../resources/assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="login-page sidebar-collapse">
         	<c:set var="sucess" value="${requestScope['sucess']}"/>
                <c:choose>
                <c:when test="${empty sucess}">
                </c:when>
                <c:otherwise>
                      <div class="alert alert-success">
                              <div class="container">
                              <div class="alert-icon">
                                  <i class="material-icons">check</i>
                              </div>
                              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                  <span aria-hidden="true"><i class="material-icons">clear</i></span>
                              </button>
                              <b>Success Alert:</b> ${sucess }
                              </div>
                          
                      </div>                     
                </c:otherwise>
                </c:choose>
        	<c:set var="sucess" value="${requestScope['notequal']}"/>
                <c:choose>
                <c:when test="${empty notequal}">
                </c:when>
                <c:otherwise>
                      <div class="alert alert-success">
                              <div class="container">
                              <div class="alert-icon">
                                  <i class="material-icons">check</i>
                              </div>
                              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                  <span aria-hidden="true"><i class="material-icons">clear</i></span>
                              </button>
                              <b>Success Alert:</b> ${notequal }
                              </div>
                          
                      </div>                     
                </c:otherwise>
                </c:choose>
                <c:set var="sucess" value="${requestScope['incorrect']}"/>
                <c:choose>
                <c:when test="${empty incorrect}">
                </c:when>
                <c:otherwise>
                      <div class="alert alert-warning">
                          <div class="container">
                          <div class="alert-icon">
                              <i class="material-icons">warning</i>
                          </div>
                          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                              <span aria-hidden="true"><i class="material-icons">clear</i></span>
                          </button>
                          <b>Warning Alert:</b> ${incorrect }
                          </div>
                      </div>	         	  		
                </c:otherwise>
                </c:choose>       
  <div class="page-header header-filter" style="background-image: url('../../resources/assets/img/bg7.jpg'); background-size: cover; background-position: top center;">
             
   <div class="container">
      <div class="row">
        <div class="col-lg-4 col-md-6 ml-auto mr-auto">
          <div class="card card-login">
            <form class="form" action="/customer/login" method="post">
              <div class="card-header card-header-primary text-center">
                <h4 class="card-title">Login</h4>
                <div class="social-line">
                  <a href="#pablo" class="btn btn-just-icon btn-link">
                    <i class="fa fa-facebook-square"></i>
                  </a>
                  <a href="#pablo" class="btn btn-just-icon btn-link">
                    <i class="fa fa-twitter"></i>
                  </a>
                  <a href="#pablo" class="btn btn-just-icon btn-link">
                    <i class="fa fa-google-plus"></i>
                  </a>
                </div>
              </div>
              <a href="Register">
              <u><p class="description text-center">Don't have an Account?Register</p></u>
              </a>

              <div class="card-body">
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">mail</i>
                    </span>
                  </div>
                  <input type="email" name="email" class="form-control" placeholder="Email...">
                </div>
                <div class="input-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">lock_outline</i>
                    </span>
                  </div>
                  <input type="password" name="password" class="form-control" placeholder="Password...">
                </div>
                <div class="input-group">
                  <div class="row">
                    <div class="col-md-8 mx-auto">           
                      <button class="btn btn-primary" type="submit">Login</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="footer text-center">
                <a href="forgotpassword" class="btn btn-primary btn-link btn-wd btn-lg">Forgot Password</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <footer class="footer">

    </footer>
  </div>
  <!--   Core JS Files   -->
  <script src="../../resources/assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="../../resources/assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="../../resources/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
  <script src="../../resources/assets/js/plugins/moment.min.js"></script>
  <!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
  <script src="../../resources/assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="../../resources/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
  <!--  Google Maps Plugin    -->
  <!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
  <script src="../../resources/assets/js/material-kit.js?v=2.0.7" type="text/javascript"></script>
</body>

</html>
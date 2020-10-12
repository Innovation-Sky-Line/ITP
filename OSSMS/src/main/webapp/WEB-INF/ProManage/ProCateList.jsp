<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Category List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<style type="text/css">
sideBox {
	position: absolute;
	width: 40%;
	height: 20%;
	right: 0px;
}

form.example input[type=text] {
	border-radius: 25px;
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	opacity: 0.9;
	border-radius: 25px;
	width: 20%;
	padding: 15px;
	background: #2196F3;
	color: white;
	font-size: 15px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

.listBtn {
	float: right;
	opacity: 0.9;
	border-radius: 25px;
	width: 20%;
	padding: 10px;
	background: green;
	color: white;
	font-size: 15px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

.listBtn:hover {
	background-color: #0b7dda;
}

form.example button:hover {
	background: #0b7dda;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #0b7dda;
}

.dropbtn {
	border-radius: 25px;
	background-color: #3e8e41;
	color: white;
	padding: 13px;
	font-size: 14px;
	border: none;
}
</style>

<script>
			function sure(){
				var con = confirm("Are you sure?");
				if(con){
					return true;
					
				}else{
					return false;
				}
			}
			
		</script>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<div class="sideBox">
		<form:form class="example" action="/padmin/searchCate" method="POST"
			style="margin:auto;right:2px;max-width:550px">
			<input type="text" placeholder="Search Categories.."
				name="searchCate" required="required">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
		<a href="/padmin/CateManage"><button class="listBtn">Add
				New Categories</button></a>

		<div class="dropdown">
			<button class="dropbtn">View Main Categories</button>
			<div class="dropdown-content">
				<div class="container">
					<h2>Main Categories</h2>
					<table class="table table-dark table-hover">
						<thead>

							<th scope="row">Main Category ID</th>
							<th scope="row">Main Category Name</th>

							<!--  <th scope="row">Main Category Name</th>-->

						</thead>
						<tbody>
							<c:forEach items="${mainCategoryList }" var="mcategory">
								<tr>
									<td>${mcategory.idCategory }</td>
									<td>${mcategory.categoryName }</td>

									<!--  <td><c:if test="${category.mainCategoryId != null}">${category.categoryName }</c:if></td>-->

								</tr>
							</c:forEach>
						</tbody>

					</table>

				</div>
			</div>
		</div>


	</div>

	<div class="msg" style="margin: auto; color: green; width: 35%;">
		<h4>${suc}</h4>
	</div>
	<div class="container">
		<h2>Category List</h2>
		<table class="table table-dark table-hover">
			<thead>

				<th scope="row">#ID</th>
				<th scope="row">Category Name</th>
				<th scope="row">Main Category ID</th>
				<!--  <th scope="row">Main Category Name</th>-->

			</thead>
			<tbody>
				<c:forEach items="${categoryList }" var="category">
					<tr>
						<td>${category.idCategory }</td>
						<td>${category.categoryName }</td>
						<td>${category.mainCategoryId }</td>
						<!--  <td><c:if test="${category.mainCategoryId != null}">${category.categoryName }</c:if></td>-->

						<td><spring:url
								value="/padmin/updateCategory/${category.idCategory}"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url
								value="/padmin/deleteCategory/${category.idCategory}"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" onclick="return sure()" role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<spring:url value="/padmin/CateManage" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			Category</a>
	</div>






</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">

.body {
	position: absolute;
	left: 200px;
	width: 40%;
	top : 200px;
}

.footer{
	 position:relative;
	 top: 600px;
}
.sideBox{
	position: absolute;
	width : 40%;
	height: 20%;
	right:0px;
	 
}
form.example input[type=text] {
border-radius: 25px;
  padding: 10px;
  font-size: 17px;
  border: 2px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
 
  opacity: 0.9;
  border-radius: 25px;
  width: 20%;
  padding: 1px;
  background: #2196F3;
  color: white;
  font-size: 15px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

.listBtn{
 
  opacity: 0.9;
  border-radius: 25px;
  width: 20%;
  padding: 10px;
  background: #0b7dda;
  color: white;
  font-size: 12px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
  margin-left:30px;
}
.listBtn:hover {
  background: green;
}

form.example button:hover {
  background: green;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}

</style>
<meta charset="ISO-8859-1">
<title>Product Administration.</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<jsp:include page="../views/Cate_sidebar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->
	<div class = "sideBox">
		<form:form class="example" action="/padmin/searchCate" method ="POST" style="margin:auto;right:2px;max-width:550px">
  			<input type="text" placeholder="Search Categories.." name="searchCate" required = "required">
  			<button type="submit"><i class="fa fa-search"></i></button>
		</form:form>
		<a href="/padmin/categoryList"><button class="listBtn">All Categories</button></a>
	</div>
	
	<div class="body">
	
	<spring:url value="/padmin/addCategory1" var="saveURL" />
		
		<form:form modelAttribute="categoryForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="idCategory" />
			<div class="form-group">
				<label>Category Name : </label>
				<form:input path="categoryName"  pattern = "^[A-Za-z0-9&_/\s]{1,32}$" title = "Can only use '_','/' and '&' as Characters." cssClass="form-control"  id="categoryName" required = "required"/>
			</div>
			
			<div class="form-group">
				<label>Select Main Category : </label>

				
				<form:select path="mainCategoryId" cssClass="form-control"  id="categoryName">
					<option value=""></option>
					<c:forEach var="cat" items="${mainCategories }">
					<option value="${cat.idCategory }">${cat.categoryName }</option>
						<c:if test="${cat.mainCategoryId == null }">	
						</c:if>
					</c:forEach>
				</form:select>
				     
			</div>
			
			
			<div class="btn"  style="position: relative; left : 200px;"  >
			<button type="reset" class="btn btn-primary">Reset</button>  <button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form:form>
		
		</div>
	<!-- End of Your Parts!!! -->
	<div class = "footer">
	<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
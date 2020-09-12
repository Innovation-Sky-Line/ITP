<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">

.body {
	position: relative;
	left: 200px;
	width: 40%;
	top : 40px;
}

.footer{
	 position:relative;
	 top: 400px;
}
</style>
<meta charset="ISO-8859-1">
<title>Product Administration.</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<jsp:include page="../views/Cate_sidebar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->
	<div class="body">
	
	<spring:url value="/padmin/addCategory" var="saveURL" />
		
		<form:form modelAttribute="categoryForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="idCategory" />
			<div class="form-group">
				<label>Category Name : </label>
				<form:input path="categoryName" cssClass="form-control"  id="categoryName" />
			</div>
			
			<div class="form-group">
				<label>Select Main Category : </label>
				<form:select path="mainCategoryId" cssClass="form-control"  id="supplierId">
					<form:option value = ""></form:option>
					<form:option value = "${allCategories }" itemLable = "id" itemValue = "category"></form:option>
					
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
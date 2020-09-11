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
	
	<spring:url value="/padmin/addProduct" var="saveURL" />
		
		<form:form modelAttribute="productForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="idProduct" />
			<div class="form-group">
				<label>Product Name : </label>
				<form:input path="productName" cssClass="form-control"  id="product" />
			</div>
			
			<div class="form-group">
				<label>Supplier : </label>
				<form:select path="supplierId" cssClass="form-control"  id="supplierId" >
				<form:option value = "0">Select</form:option>
				<form:option value = "1">1</form:option>
				</form:select>
			</div>
			
			<div class="form-group">
				<label>Category : </label>
				<form:select path="categoryId" cssClass="form-control"  id="categoryId" >
				<form:option value = "0">Select</form:option>
				<form:option value = "6">6</form:option>
				</form:select>
			</div>
			
			<div class="form-group">
				<label>Unit Price : </label>
				<form:input path="price" cssClass="form-control" id="price" />
			</div>
			
			<div class="form-group">
				<label># of units : </label>
				<form:input path="currentStock" cssClass="form-control" id="currentStock" />
			</div>
			
			 <div class="form-group">
				<label>Buying Limit : </label>
				<form:input path="buyingLimit" cssClass="form-control" id="buyingLimit" />
			</div>
			
			<div class="form-group">
				<label>Discount Rate : </label>
				<form:input path="discount" cssClass="form-control" id="discount" />
			</div>
			
			<div class="form-group">
				<label>Upload image : </label>
				<form:input path="productImage" cssClass="form-control" id="productImage" type ="file" />
			</div>
			<div class="btn"  style="position: relative; left : 200px;"  >
			  <button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form:form>
	
		</div>
	<!-- End of Your Parts!!! -->
	<div class = "footer">
	<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
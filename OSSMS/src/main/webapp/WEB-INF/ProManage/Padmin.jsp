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
	 top: 848px;
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
  border: 3px solid grey;
  float: left;
  width: 80%;
  background: white;
}

form.example button {
 
  opacity: 0.9;
  border-radius: 25px;
  width: 20%;
  padding: 1px;
  background: #0b7dda;
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
  font-size: 15px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: black;
}
.listBtn:hover {
  background: black;
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
	<jsp:include page="../views/P_sidebar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->
	<div class = "sideBox">
		<form:form class="example" action="" style="margin:auto;right:2px;max-width:550px">
  			<input type="text" placeholder="Search Products.." name="search2">
  			<button type="submit"><i class="fa fa-search"></i></button>
		</form:form>
		<a href="/padmin/productList"><button class="listBtn">All Products</button></a>
	</div>
	
	
	<div class="body">
	
	<spring:url value="/padmin/addProduct" var="saveURL" />
		
		<form:form modelAttribute="productForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="idProduct" />
			<div class="form-group">
				<label>Product Name : </label>
				<form:input path="productName" cssClass="form-control"  id="product" required = "required"/>
			</div>
			
			<!--  <div class="form-group">
				<label>Supplier : </label>
				<form:select path="supplierId" cssClass="form-control"  id="supplierId" required = "required">
				<form:option value = "-1">Select</form:option>
				<form:option value = "1">1</form:option>
				</form:select>
			</div>-->
			
			<div class="form-group">
			<label>Select Supplier : </label>
			<form:select class="form-group" path="supplierId" cssClass="form-control"  id="categoryName" required = "required">
					<option value="-1" >Select</option>
					<c:forEach var="sup" items="${allSuppliers }">
					<option value="${sup.idSupplier }">${sup.supplierName }</option>
					</c:forEach>
				</form:select>
			</div>
			
			
			<div class="form-group">
			<label>Select Category : </label>
			<form:select class="form-group" path="categoryId" cssClass="form-control"  id="categoryName" required = "required">
					<option value="">Select</option>
					<c:forEach var="cat" items="${allCategories }">
					<option value="${cat.idCategory }">${cat.categoryName }</option>
					</c:forEach>
				</form:select>
			</div>
			
			<div class="form-group">
				<label>Unit Price (LKR) : </label>
				<form:input path="price" cssClass="form-control" id="price" type = "number"  min="0"  required = "required"/>
			</div>
			
			<div class="form-group">
				<label># of units : </label>
				<form:input path="currentStock" cssClass="form-control" id="currentStock" type = "number"  min="0" required = "required"/>
			</div>
			
			 <div class="form-group">
				<label>Buying Limit : </label>
				<form:input path="buyingLimit" cssClass="form-control" id="buyingLimit"  min="0" type = "number"/>
			</div>
			
			<div class="form-group">
				<label>Discount Rate (%): </label>
				<form:input path="discount" cssClass="form-control" id="discount"  min="0" max="100" type = "number" />
			</div>
			
			<div class="form-group">
				<label>Upload image : </label>
				<form:input path="productImage" cssClass="form-control" id="productImage" type ="file" />
			</div>
			<div class="btn"  style="position: relative; left : 200px;"  >
			   <button type="reset" class="btn btn-primary">Reset</button>&nbsp &nbsp &nbsp<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form:form>
	
		</div>
	<!-- End of Your Parts!!! -->
	<div class = "footer">
	<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
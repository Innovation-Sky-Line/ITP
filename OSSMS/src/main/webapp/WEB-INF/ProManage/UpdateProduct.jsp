<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<style type="text/css">
.body {
	position: absolute;
	left: 200px;
	width: 40%;
	top: 200px;
}

.footer {
	position: relative;
	top: 848px;
}

.sideBox {
	position: absolute;
	width: 40%;
	height: 20%;
	right: 0px;
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
	background: #0b7dda;
	color: white;
	font-size: 15px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

.listBtn {
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
}

form.example button:hover {
	background: Green;
}

.listBtn:hover {
	background: Green;
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

function populate(s1,s2){
	var s1 = document.getElementById(s1);
	var s2 = document.getElementById(s2);
}



function validateForm(){
if( document.pFrom.price.value < 1 ) {
    alert( "Unit Price must not be 0 or less !!!" );
    document.pFrom.price.focus() ;
    return false;
 }else if( document.pFrom.supName.value == null ) {
    alert( "Select a Supplier !!!" );
    document.pFrom.supName.focus() ;
    return false;
 }
 else if( document.pFrom.catName.value == null ) {
	    alert( "Select a Category !!!" );
	    document.pFrom.catName.focus() ;
	    return false;
	 }
 
else if( document.pFrom.currentStock.value < 1 ) {
    alert( "# of Units must not be 0 or less !!!" );
    document.pFrom.currentStock.focus() ;
    return false;
 }
else if( document.pFrom.buyingLimit.value < 1 ) {
    alert( "Buying Limit must not be 0 or less !!!" );
    document.pFrom.buyingLimit.focus() ;
    return false;
 }
else if( document.pFrom.discount.value < 0 && document.pFrom.discount.value > 100) {
    alert( "Discount must be between 0-100% !!!" );
    document.pFrom.discount.focus() ;
    return false;
 }else
 return(true);
}
</script>
<meta charset="ISO-8859-1">
<title>Product Administration.</title>
</head>
<body>
	<jsp:include page="../views/Header.jsp"></jsp:include>
	<jsp:include page="../views/P_sidebar.jsp"></jsp:include>
	<!-- Include Your parts within this comment.-->
	<div class="sideBox">
		<form:form class="example" action="/padmin/searchPro" method="POST"
			style="margin:auto;right:2px;max-width:550px">
			<input type="text" placeholder="Search Products.." name="product"
				required="required">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
		<a href="/padmin/productList2"><button class="listBtn">All
				Products</button></a>
	</div>


	<div class="body">

		<spring:url value="/padmin/updateProduct2" var="saveURL" />

		<form:form name="pFrom" modelAttribute="productForm" method="post"
			action="${saveURL }" cssClass="form" onsubmit="return validateForm()"
			enctype="multipart/form-data">
			<form:hidden path="idProduct" />
			<div class="form-group">
				<label>Product Name : </label>
				<form:input name = "pronm" path="productName" cssClass="form-control"
					pattern="^[A-Za-z0-9&_/\s]{1,32}$"
					title="Can only use '_','/' and '&' as Characters." id="idpnm" 
					required="required" />
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
				<form:select class="form-group" path="supplierId"
					cssClass="form-control" id="supName" name="supName"
					required="required">
					<c:set value="${sName } " var="sn"></c:set>
					<c:set value="${sId } " var="si"></c:set>
					<c:if test="${not empty sName}">
						<option value="${si }">${sn }</option>
					</c:if>
					<option value="">Select</option>
					<c:forEach var="sup" items="${allSuppliers }">
						<option value="${sup.idSupplier }">${sup.supplierName }</option>
					</c:forEach>
				</form:select>
			</div>


			<!-- <div class="form-group">
				<label>Select the Main Category : </label>
				<form:select class="form-group" path="categoryId"
					cssClass="form-control" id="mcatName" name="mcatName"
					onchange="populate(this.id,catName)" required="required">
					<c:set value="${cName } " var="cn"></c:set>
					<c:set value="${cId } " var="ci"></c:set>
					<c:if test="${not empty cName}">
						<option value="${ci }">${cn }</option>
					</c:if>
					<option value="">Select</option>
					<c:forEach var="cat" items="${mainCategories }">
						<option value="${cat.idCategory }">${cat.categoryName }</option>
					</c:forEach>
				</form:select>
			</div>





			 <div class="dropdown">
			<button class="dropbtn">Select Main Categories</button>
			<div class="dropdown-content">
				<div class="container">
					<table class="table table-striped">
						<thead>

						</thead>
						<tbody>
						<form:form action = "/padmin/getSubs" method = "POST">
							<c:forEach items="${mainCategories }" var="mcategory">
								<tr>
									<td><input type="hidden" id="mCatName" name="mCatName" value="${mcategory.categoryName }"></td>
									<td><input type="submit" value="${mcategory.categoryName }"></td>
								</tr>
							</c:forEach>
						</form:form>
						</tbody>

					</table>

				</div>
			</div>
		</div>-->











			<div class="form-group">
				<label>Select the Sub Category : </label>
				<form:select class="form-group" path="categoryId"
					cssClass="form-control" id="catName" name="catName"
					required="required">
					<c:set value="${cName } " var="cn"></c:set>
					<c:set value="${cId } " var="ci"></c:set>
					<c:if test="${not empty cName}">
						<option value="${ci }">${cn }</option>
					</c:if>
					<option value="">Select</option>
					<c:forEach var="cat" items="${allCategories }">
						<option value="${cat.idCategory }">${cat.categoryName }</option>
					</c:forEach>
				</form:select>
			</div>

			<div class="form-group">
				<label>Unit Price (LKR) : </label>
				<form:input path="price" cssClass="form-control" id="price"
					type="number" min="1" name="price" required="required" />
			</div>

			<div class="form-group">
				<label># of units : </label>
				<form:input path="currentStock" cssClass="form-control"
					id="currentStock" name="currentStock" type="number" min="1"
					required="required" />
			</div>

			<div class="form-group">
				<label>Buying Limit : </label>
				<form:input path="buyingLimit" cssClass="form-control"
					id="buyingLimit" name="buyingLimit" min="1" type="number" />
			</div>

			<div class="form-group">
				<label>Discount Rate (%): </label>
				<form:input path="discount" cssClass="form-control" id="discount"
					name="discount" min="0" max="100" type="number" />
			</div>

			<div class="form-group">
				<label>Upload image : </label> <input name="image" id="productImage"
					type="file" accept="image/png, image/jpeg" required="required" />
			</div>
			<div class="btn" style="position: relative; left: 200px;">
				<button type="reset" class="btn btn-primary">Reset</button>
				&nbsp &nbsp &nbsp
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form:form>

	</div>
	<!-- End of Your Parts!!! -->
	<div class="footer">
		<jsp:include page="../views/Footer.jsp"></jsp:include>
	</div>
</body>
</html>
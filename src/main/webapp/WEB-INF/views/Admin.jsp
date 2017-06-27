<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">

<head>
<%@include file="/WEB-INF/views/Header.jsp"%>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	/* border-color: #ccc; */
	width: 100%;
}

.tg tr:hover {
	background-color: #f5f5f5
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	text-align: center;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9;
}

/* section {
	height: 100%;
	min-height: 25cm;
	width: 100%;
} */
</style>


</head>

<body>


	<div id="all">

		<div id="heading-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1>Admin page</h1>
					</div>
					<div class="col-md-5">
						<ul class="breadcrumb">
							<li><a href="<c:url value="/"/>">Admin</a></li>
							<c:if
								test="${isAdminClickedCategories==true||isAdminClickedEditCategories==true }">
								<li>Category</li>
							</c:if>
							<c:if
								test="${isAdminClickedSuppliers==true||isAdminClickedEditSuppliers==true }">
								<li>Supplier</li>
							</c:if>
							<c:if
								test="${isAdminClickedProducts==true||isAdminClickedEditProducts==true }">
								<li>Product</li>
							</c:if>
						</ul>

					</div>
				</div>
			</div>
		</div>
		<section>

			<c:if
				test="${isAdminClickedCategories==true||isAdminClickedEditCategories==true }">
				<%@include file="category.jsp"%>
			</c:if>

			<c:if
				test="${isAdminClickedProducts==true||isAdminClickedEditProducts==true }">
				<%@include file="product.jsp"%>
			</c:if>

			<c:if
				test="${isAdminClickedSuppliers==true ||isAdminClickedEditSuppliers==true}">
				<%@include file="supplier.jsp"%>
			</c:if>
		</section>




		<%@include file="/WEB-INF/views/Footer.jsp"%>

	</div>
	<!-- /#all -->

	

	

<%-- <%@include file="/WEB-INF/views/gmap.jsp"%> --%>

	
</body>
</html>
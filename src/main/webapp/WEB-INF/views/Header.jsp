<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
  <title>MobiShop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">MobiShop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="aboutus">AboutUs</a></li>
      <li><a href="loginPage">Login</a></li>
      <li><a href="register">Register</a></li>
      <li><a href="contactus">ContactUs</a></li>
      <li>
      
      <div class="col-sm-8">
						<div class="login pull-right">


						<c:choose>
							<c:when test="${pageContext.request.userPrincipal.name != null}">							
							
								<i class="fa fa-user-admin"></i>
								<a>Hello, ${pageContext.request.userPrincipal.name}</a>
								<a href="<c:url value="/j_spring_security_logout"/>">
								<i class="fa fa-sign-out"></i>Sign Out</a>
							</c:when>						
							<c:otherwise><a href="<c:url value="/"/>"><i class="fa fa-home"></i> 
							<!-- <span class="hidden-xs text-uppercase">Home</span></a> -->
							<a href="<c:url value="/login"/>"> <i class="fa fa-sign-in"></i> 
							<!-- <span class="hidden-xs text-uppercase">Sign in</span></a>  -->
							<%-- <a href="<c:url value="/register"/>"><i class="fa fa-user"> </i>  --%>
						<!-- 	<span class="hidden-xs text-uppercase">Sign up</span></a> -->
						 </c:otherwise>
						</c:choose> 
						</div>
						</div>
      
      </li>
      
      
      <li> 
      
      <c:choose>
												<c:when test="${pageContext.request.userPrincipal.name != null}">
													<c:if test="${pageContext.request.userPrincipal.name == 'Admin'}">
													
														<li><a href="<c:url value='/categories'/>">Category</a></li>
														<li><a href="<c:url value="/suppliers"/>">Supplier</a></li>
														<li><a href="<c:url value="/products"/>">Product</a></li>
													</c:if>
													
													<c:if test="${pageContext.request.userPrincipal.name != 'Admin'}">
													
														<li><a href="<c:url value="/user/cart"/>">Cart</a></li>
													
													</c:if>
													</c:when>
													
													<c:otherwise>
													
													<%-- 	<li><a href="<c:url value="/register"/>">Register</a></li>
														<li><a href="<c:url value="/loginPage"/>">Login</a></li> --%>
													
													</c:otherwise>
											</c:choose>
      </li>
    </ul>
  </div>
</nav>
  
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    
    </div>
    <ul class="nav navbar-nav">
      
	<div> <!-- *** MENU BAR***-->
	<hr color="red" size="5">
  
	<ul id="menu">
	<div class="container">
       <div class="row">
		<c:forEach items="${categoryList}" var="category">
		
				<li><a href="${category.name}">${category.name}</a>
				<ul>
					<c:forEach items="${category.products}" var="product">

						<li><a href="<c:url value='product/get/${product.id}' />">${product.name}</a></li>

					</c:forEach>

				</ul>
			</li>
		</c:forEach>
		</div>
	</div>
	</ul>
	<hr color="red" size="5">
	</div>  
    </ul>
  </div>
</nav>
</body>
</html>

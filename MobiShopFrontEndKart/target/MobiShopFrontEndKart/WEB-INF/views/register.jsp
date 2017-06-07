<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en">

<head>
<%@include file="/WEB-INF/views/Header.jsp"%>
<style type="text/css">
.form-group input{
	width:50%;
}
</style>
</head>



<body>

	<div id="all">









		<div id="content">
			<div class="container">

				

						<h2 class="text-uppercase">Create a new account</h2>
						<p class="lead">Not our registered customer yet?</p>
						
						<div class="error" style="color: #ff0000;">${usernameError}${emailError}${userPhoneError }</div>
						
						
						<c:if test="${not empty message}">
								<div class="error" style="color: #ff0000;">${message}${usernameError}</div>
						</c:if>
						
						
						<hr>
						<p>With registration with us new world of latest products, fantastic
							discounts and much more opens to you! The whole process will not
							take you more than a minute!</p>
						<p class="text-muted">
							If you have any questions, please feel free to <a
								href="<c:url value="/contact"/>">contact us</a>, our customer service center
							is working for you 24/7.
						</p>

						<hr>

						<!-- LOOK HERE -->
						<form:form action="register" method="post" commandName="usersDetail">
						
						 
							
					
								<div class="form-group">
								<label for="fullname-signup">Full Name</label>
								
								<form:errors path="userFullName" cssStyle="color: #ff0000" />
								<div class="controls docs-input-sizes">
									<form:input type="text" placeholder="user full name" path="userFullName" class="form-control" id="userFullName" />
								</div> </div>



								<div class="form-group">
								<label for="name-signup">Name</label>
								
								<form:errors path="username" cssStyle="color: #ff0000" /> 
								<div class="controls docs-input-sizes">
									<form:input type="text" placeholder="user name" path="username" class="form-control" id="username" />
								</div> </div>


								<div class="form-group">
									<label for="name-signup">Phone</label>
									
									<div class="controls docs-input-sizes">
										<form:input type="text" placeholder="phone" path="userPhone" 
										class="form-control" id="phone-signup" max="10" />
									</div>
								</div>


								
								<div class="form-group">
									<label for="email-signup">Email</label>
									
									<form:errors path="userEmail" cssStyle="color: #ff0000" />
									<div class="controls docs-input-sizes">
										<form:input placeholder="email" path="userEmail" 
										class="form-control" id="email-signup" />
									</div>
								</div>

								


								<div class="form-group">
									<label for="password-signup">Password</label>
									
									<form:errors path="password" cssStyle="color: #ff0000" />
									<div class="controls docs-input-sizes">
										<form:input type="password" path="password" class="form-control"
											placeholder="password" id="password-signup" min="7" max="15" />
									</div>
								</div>


								<div class="form-group">
								<div class="text-center">
									<button type="submit" class="btn btn-template-main pull-left">
										<i class="fa fa-user-md"></i> Register
									</button>
								</div></div>
								
								<div class="form-group">
								<div class="text-center">
									<button type="reset" class="btn btn-template-main"
										value="Reset">Clear</button>
								</div></div>
							

						</form:form>
						<br> <br>
					
					

			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->

		<br>



		<%@include file="/WEB-INF/views/Footer.jsp"%>
		<!-- /#footer -->


	</div>
	<!-- /#all -->


	<!-- #### JAVASCRIPT FILES ### -->
	

</body>
</html>
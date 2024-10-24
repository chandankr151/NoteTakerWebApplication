<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register_page</title>

<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body style="background-color: #f0f0f0;">
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center">
						<h3>Login Page</h3>
						<c:if test="${not empty msg}">
							<h5 style="color: red;">${msg}</h5>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="loginUser" method="post">

							<div class="md-3">
								<label>Enter Email</label> <input type="email" name="email"
									class="form-control" required>
							</div>

							<div class="md-3">
								<label>Enter Password</label> <input type="password"
									name="password" class="form-control" required>
							</div>
							<br>

							<button class="btn btn-primary col-md-12">Login</button>
						</form>
					</div>
					<div class="card-footer text-center">
						<p class="fs-6">
							don't have an account <a href="${pageContext.request.contextPath}/register"
								class="text-decoration-name">register</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
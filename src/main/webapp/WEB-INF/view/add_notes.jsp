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
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-header text-center">
						<h3>Add Your Notes</h3>
						<c:if test="${not empty msg }">
							<h6 style="color: red;">${msg}</h6>
						</c:if>
						<c:remove var="msg" />
					</div>
					<div class="card-body">
						<form action="saveNotes" method="post">
							<div class="md-3">
								<label>Enter Title</label> <input type="text" name="title"
									class="form-control" required>
							</div>

							<div class="md-3">
								<label>Enter Description</label>
								<textarea rows="6" cols="" name="description"
									class="form-control">
								
								</textarea>
							</div>

							<button class="btn btn-primary mt-4 ">Save</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
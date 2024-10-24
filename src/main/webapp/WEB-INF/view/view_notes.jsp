<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Notes</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>

	<div class="container-fluid p-2">
		<h4 class="text-center">View All Notes</h4>
		<c:if test="${not empty msg }">
			<h5 style="align-tex: center; color: red; font-family: cursive">${msg}</h5>
		</c:if>
		<c:remove var="msg" />
		<div class="row">

			<c:forEach var="notes" items="${list}">
				<div class="col-md-7 offset-md-3 mt-3">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img alt="addNotesImage"
									src='<c:url value='/resources/images/addNotes.jpeg' /> '
									width="50px" height="50">
							</div>

							<p>${notes.title}</p>
							<p>${notes.description}</p>
							<p>${notes.date }</p>

							<div class="text-center">
								<a href="editNotes?id=${notes.id}"
									class="btn btn-primary btn-sm">edit</a> <a
									href="deleteNotes?id=${notes.id}" class="btn btn-danger btn-sm">delete</a>
							</div>
						</div>
					</div>

				</div>
			</c:forEach>

		</div>
	</div>
</body>
</html>
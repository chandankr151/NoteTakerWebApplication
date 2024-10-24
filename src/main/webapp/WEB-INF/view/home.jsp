<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>

<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>

	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<h2 style="text-align: center;">Welcome to E-Notes Management
		System</h2>

	<div class="container-fluid p-0 m-0">
		<img alt="notesImages"
			src='<c:url value="/resources/images/notes.jpg"></c:url>'
			width="100%" height="520px">
	</div>
</body>
</html>
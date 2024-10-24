<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body style="background-color: #f0f0f0;">
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>

	<h1>User Logged in Successfully: ${userObj.fullName }</h1>
</body>
</html>
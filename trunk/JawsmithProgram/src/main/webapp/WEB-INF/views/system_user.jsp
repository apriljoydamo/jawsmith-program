<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>System User</title>
		<link rel="stylesheet" type="text/css" href={pageContext.request.contextPath}/resources/css/styles.css">
		<jsp:include page="header.jsp" />
	</head>
	<body>
		<div>
		<form action="${pageContext.request.contextPath}/addUser" method="POST">
			<input type="text" name="last_name" value="Last Name"/>			
			<input type="text" name="first_name" value="First Name" />
			<input type="text" name="username" value="Username" />
			<input type="text" name="password" value="Password" />
			<input type="hidden" value="1" name="access" />
			<input type="submit" value="Save"/>
		</form>
		</div>
	</body>
</html>
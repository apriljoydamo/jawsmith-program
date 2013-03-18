<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login_page.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-prod.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/beauteethful.js"></script>
		</head>
	<body>
		<div class="" id="body_div">
			<h3>Please enter your username and password:</h3>
			<c:if test="${param.error == 'true'}">
		   		<font color="red"> Incorrect username and/or password! :D</font>
			</c:if>
		    <div class="center">
		    <form action="j_spring_security_check" method="POST"><br />
				<p>
					<label for="j_username">Username</label>
					<input id="j_username" name="j_username" type="text" />
				</p>
				<p>
					<label for="j_password">Password</label>
					<input id="j_password" name="j_password" type="password" />
				</p>
				<input id="submit_button" class="submit_button mouseout_button" type="submit" value="Login"/>	
			</form>
		    </div>
		</div>
	</body>
</html>
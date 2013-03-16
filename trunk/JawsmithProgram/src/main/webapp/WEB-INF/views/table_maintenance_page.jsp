<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
		<jsp:include page="header.jsp" />
	</head>
	<body>
		<div>
		Hi Admin!
		<form action="/JawSmithProgram/logout" method="POST">
		<input type="submit" value="Logout"/>
		</form>
			
		<form action="/JawSmithProgram/patients" method="POST">
		<input type="submit" value="Patients"/>
		</form>

		<form action="/JawSmithProgram/tableMaintenance" method="POST">
		<input type="submit" value="Table Maintenance"/>
		</form>
		
		<form action="/JawSmithProgram/logout" method="POST">
		<input type="text" name="search" value="Search" />
		<input type="submit" value="Search"/>
		</form>
		
		<form action="/JawSmithProgram/advancedSearch" method="POST">
		<input type="submit" value="Advanced Search"/>
		</form>
		
		<form action="/JawSmithProgram/addSomething" method="POST">
		<input type="submit" value="+"/>
		</form>
		
		<form action="/JawSmithProgram/saveReport" method="POST">
		<input type="submit" value="Save Report"/>
		</form>
		
		</div>
	</body>
</html>
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
		<div id="home_page_div1">
			<form action="${pageContext.request.contextPath}/home" method="POST">
			<input type="submit" value="Patients"/>
			</form>
	
			<c:if test="${user.access!=1}">
				<form action="${pageContext.request.contextPath}/home?tblmaintenance=true" method="POST">
				<input type="submit" value="Table Maintenance"/>
				</form>
			</c:if>
			
			<form action="${pageContext.request.contextPath}/advancedSearch" method="POST">
			<input type="submit" value="Advanced Search"/>
			</form>
			
			<form action="${pageContext.request.contextPath}/addSomething" method="POST">
			<input type="submit" value="+"/>
		</form>
		
		</div>	
		<div id="home_page_div2">
			<table>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
						
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<c:if test="${param.tblmaintenance==true}">
			<table>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
						
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			</c:if>
		</div>	
		<div id="home_page_div3">
			<form action="${pageContext.request.contextPath}/saveReport" method="POST">
			<input type="submit" value="Save Report"/>
			</form>
		</div>	
		
	</body>
</html>
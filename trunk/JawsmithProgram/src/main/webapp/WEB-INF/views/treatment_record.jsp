<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
		<jsp:include page="header.jsp" />
	</head>
	<body>
		<div id="treatment_record_div1">
			<img alt="" src="" />
		</div>
		<div id="treatment_record_div2">
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
					<td></td>	
				</tr>
			</table>
		</div>
		
		<div id="treatment_record_div3">	
			<form action="${pageContext.request.contextPath}/treatmentRecord/save" method="POST">
			<input type="submit" value="Save"/>
			</form>
		</div>
	</body>
</html>
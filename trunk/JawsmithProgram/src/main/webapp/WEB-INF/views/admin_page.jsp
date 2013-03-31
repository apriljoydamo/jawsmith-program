<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrator Page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>
		<jsp:include page="header.jsp" />
	</head>
	<body>
		<div class="" id="homepage_panel">
	      <label id="table_maintenance_button" onclick="buttonNextPage('${pageContext.request.contextPath}/table_maintenance/view')" class="button mouseout_button">Table Maintenance</label>
          <label id="system_users" onclick="buttonNextPage('${pageContext.request.contextPath}/system_users/view')" class="button mouseout_button">System Users</label>  
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrator Page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-prod.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>		
	</head>
	<center>
	<body>
	<div id="body_div">
	<jsp:include page="header.jsp" />
		<div id="homepage_panel">
			<label id="add_system_users" onclick="buttonNextPage('')" class="button mouseout_button">Add System Users</label>  
			<label id="edit_system_users" onclick="buttonNextPage('')" class="button mouseout_button">Edit System Users</label>  
			<label id="add_table_maintenance" onclick="buttonNextPage('')" class="button mouseout_button">Add Table Maintenance</label>
	        <label id="edit_table_maintenance" onclick="buttonNextPage('')" class="button mouseout_button">Edit Table Maintenance</label>
		</div>   
		<div id=user_list>
			<h3>SYSTEM USERS</h3>
		<center>
			<table id="user_table">
				<tr>
					<th class="table_header">First Name</th>
					<th class="table_header">Last Name</th>
					<th class="table_header">Username</th>
					<th class="table_header">Password</th>
					<th class="table_header">User Access</th>
				</tr>
				<c:forEach var="sysUser" items="${sysUsersList}">
				<tr>
					<td w_bg><c:out value="${sysUser.first_name}"/></td>
					<td w_bg><c:out value="${sysUser.last_name}"/></td>
					<td w_bg><c:out value="${sysUser.username}"/></td>
					<td w_bg><c:out value="${sysUser.password}"/></td>
					<td w_bg>${sysUser.access}
						
					</td>
				</tr>
				</c:forEach>
			</table>
		</center>	
		</div>
		
		<div id="tm_bg">
		<h3>TABLE MAINTENANCE</h3>
		<div id="tablem_list">
			<div>
			<table id="tablem_table">
				<tr>
					<th class="table_header">Reference Id</th>
					<th class="table_header">Code Table Value</th>
					<th class="table_header">Description</th>
					<th class="table_header">Status</th>
				</tr>
				<c:forEach var="tblMaintenance" items="${tblMaintenanceList}">
				<tr>
					<td w_bg><c:out value="${tblMaintenance.reference_id}"/></td>
					<td w_bg><c:out value="${tblMaintenance.code_table_value}"/></td>
					<td w_bg><c:out value="${tblMaintenance.tbl_maintenance_description}"/></td>
					<td w_bg><c:out value="${tblMaintenance.status}"/></td>
				</tr>
				</c:forEach>
			</table>
			</div>
		</div>
		</div>
			<jsp:include page="${system_user.jsp}" />
	</div>		
	</body>	
	</center>
</html>
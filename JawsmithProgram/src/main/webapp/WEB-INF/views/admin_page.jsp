<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrator Page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modal.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin_page.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-prod.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin_page.js"></script>		
	</head>
	<body>
	<center>
		<form id="user_form_id" action="${pageContext.request.contextPath}/system_users/record" method="POST">
			<input type="hidden" value="" id="user_id_hidden" name="user_id_hidden" />
		</form>
		<form id="tablem_form_id" action="${pageContext.request.contextPath}/table_maintenance/record">
			<input type="hidden" value="" id="tablem_id_hidden" name="tablem_id_hidden"/>
		</form>
		
	<div id="body_div">
	<jsp:include page="header.jsp" />
		<div id="homepage_panel">
			<label class="button mouseout_button" onClick="buttonNextPage('#add_user_div')">Add System Users</label>  
			<label class="button mouseout_button" onClick="buttonNextPage('#add_tablem_div')">Add Table Maintenance</label>
	    </div>   
		<div id=user_list>
			<h3 style="position: relative; top: 15px">SYSTEM USERS</h3>
		<center>
		<div id="user_list_table">
			<table id="user_table">
				<tr>
					<th style="width: 20%;" class="table_header">First Name</th>
					<th style="width: 20%;" class="table_header">Last Name</th>
					<th style="width: 20%;" class="table_header">Username</th>
					<th style="width: 20%;" class="table_header">Password</th>
					<th style="width: 20%;" class="table_header">User Access</th>
				</tr>
				<c:forEach var="sysUser" items="${sysUsersList}">
				<tr id="user_id" class="patient_records" onclick="selectUser('${sysUser.user_id}')">
					<td><c:out value="${sysUser.first_name}"/></td>
					<td><c:out value="${sysUser.last_name}"/></td>
					<td><c:out value="${sysUser.username}"/></td>
					<td><c:out value="${sysUser.password}"/></td>
					<td>${sysUser.access}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</center>	
		</div>
		
		<div id="tm_bg">
		<h3  style="position: relative; top: 165px">TABLE MAINTENANCE</h3>
			<div id="tablem_list_table">
				<table id="tablem_table">
					<tr>
						<th style="width: 20%;" class="table_header">Reference Id</th>
						<th style="width: 20%;" class="table_header">Code Table Value</th>
						<th style="width: 40%;" class="table_header">Description</th>
						<th style="width: 20%;" class="table_header">Status</th>
					</tr>
					<c:forEach var="tblMaintenance" items="${tblMaintenanceList}">
					<tr id="tbl_maintenance_id" class="patient_records" onclick="selectTblMaintenance('${tblMaintenance.table_maintenance_id}')">
						<td><c:out value="${tblMaintenance.reference_id}"/></td>
						<td><c:out value="${tblMaintenance.code_table_value}"/></td>
						<td><c:out value="${tblMaintenance.tbl_maintenance_description}"/></td>
						<td><c:out value="${tblMaintenance.status}"/></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>		
	</div>	
	
	<div id="add_user_div" class="modalDialog">
			<div id="add_user_form">
 			<a id="close_user" href="#close" class="close_reg close" title="">X</a><br/>
 	      		<label id="add_user_label">ADD USER</label>
 				<form action="${pageContext.request.contextPath}/system_users/add" method="POST">
 					<table>
 						<tr>
 							<td>Username:</td>
 							<td><input type="text" name="username" value="" />
 							</td>
 						</tr>
 						<tr>
 							<td>Password:</td>
 							<td><input type="password" name="password" value="" />
 							</td>
 						</tr>
 						<tr>
 							<td>First Name:</td>
 							<td><input type="text" name="first_name" value="" />
 							</td>
 						</tr>
 						<tr>
 							<td>Last Name:</td>
 							<td><input type="text" name="last_name" value="" />
 							</td>
 						</tr>
 						<tr>
 							<td>Access:</td>
 							<td><select name="access">
 									<option value="1">Administrator</option>
 									<option value="2">Doctor</option>
 									<option value="3">Secretary</option>
 							</select>
 							</td>
 						</tr>
 
 					</table>
 					<input type="submit" value="Submit" />
 				</form>
 			</div>
		</div>
		
		
	<div id="edit_user_div" class="modalDialog">	
		<div id="add_user_form">
		<a id="close_user" href="#close" class="close_reg close" title="">X</a><br/>
		<label id="edit_user_label">EDIT USER</label>
	      	<form action="${pageContext.request.contextPath}/system_users/edit" method="POST">
	      	<input type="hidden" name="user_id" value="${selectedUser.user_id}" />
				<table>
					<tr>
						<td>Username: </td>
						<td><input type="text" name="username" value="${selectedUser.username}" /></td>
					</tr>
					<tr>
						<td>Password: </td>
						<td><input type="text"  name="password"  value="${selectedUser.password}" /></td>
					</tr>
					<tr>
						<td>First Name: </td>
						<td><input type="text" name="first_name" value="${selectedUser.first_name}" /></td>
					</tr>
					<tr>
						<td>Last Name: </td>
						<td><input type="text" name="last_name"  value="${selectedUser.last_name}" /></td>
					</tr>
					<tr>
						<td>Access: </td>
						<td><select name="access">
							<option value="1" ${selectedUser.access=='1' ? 'selected' : ''}>Administrator</option>
							<option value="2" ${selectedUser.access=='2' ? 'selected' : ''}>Doctor</option>	
							<option value="3" ${selectedUser.access=='3' ? 'selected' : ''}>Secretary</option>	
						</select></td>
					</tr>
					
				</table>
				<input type="submit" value="Submit"/>
			</form>
			</div>
		</div>
		
		
		<div id="add_tablem_div" class="modalDialog">
			<div id="tablem_form">
			<a id="close_tablem" href="#close" class="close_reg close" title="">X</a><br/>
			<label id="add_tablem_label">ADD TABLE MAINTENANCE</label>
	      	<form action="${pageContext.request.contextPath}/table_maintenance/add" method="POST">
				<table>
					<tr>
						<td>Reference Id:</td>
						<td>
							<select name="reference_id">
								<c:forEach var="tblMaintenance" items="${refIdList}">
									<option value="${tblMaintenance.code_table_value}">${tblMaintenance.tbl_maintenance_description}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Code Table Value: </td>
						<td><input type="text" name="code_table_value" value="" /></td>
					</tr>
					<tr>
						<td>Description: </td>
						<td><input type="text" name="tbl_maintenance_description" value="" /></td>
					</tr>
					<tr>
						<td>Status: </td>
						<td><select name="status">
							<option value="true">Active</option>
							<option value="false">Inactive</option>		
						</select></td>
					</tr>
					
				</table>
				<input type="submit" value="Submit"/>
			</form>
			</div>
		</div>
		<div id="edit_tablem_div" class="modalDialog">
			<div id="tablem_form">
			<a id="close_tablem" href="#close" class="close_reg close" title="">X</a><br/>
			<label id="add_tablem_label">EDIT TABLE MAINTENANCE</label>
	      	<form action="${pageContext.request.contextPath}/table_maintenance/edit" method="POST">
	      	<input type="hidden" name="table_maintenance_id" value="${selectedTblMaintenance.table_maintenance_id}" />
				<table>
					<tr>
						<td>Reference Id:</td>
						<td>
							<select name="reference_id" >
								<c:forEach var="tblMaintenance" items="${refIdList}">
									<option value="${tblMaintenance.code_table_value}" ${selectedTblMaintenance.reference_id==tblMaintenance.code_table_value ? 'selected' : ''} >${tblMaintenance.tbl_maintenance_description}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Code Table Value: </td>
						<td><input type="text" name="code_table_value" value="${selectedTblMaintenance.code_table_value}" /></td>
					</tr>
					<tr>
						<td>Description: </td>
						<td><input type="text" name="tbl_maintenance_description" value="${selectedTblMaintenance.tbl_maintenance_description}" /></td>
					</tr>
					<tr>
						<td>Status: </td>
						<td><select name="status">
							<option value="true" ${selectedTblMaintenance.status=='true' ? 'selected' : ''} >Active</option>
							<option value="false" ${selectedTblMaintenance.status=='false' ? 'selected' : ''} >Inactive</option>		
						</select></td>
					</tr>
					
				</table>
				<input type="submit" value="Submit"/>
			</form>
			</div>
		</div>
		
	</center>
	</body>	
</html>
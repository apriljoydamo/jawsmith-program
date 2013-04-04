<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

	
	<div id="register_div" class="modalDialog">
		<div id="register_panel" class="">
	    <a href="#close" class="close_reg close" title="">X</a>
	    <label id="add_patient_label">ADD SYSTEM USER</label>
		<form action="${pageContext.request.contextPath}/system_users/add" method="POST">
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" value="First Name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" value="Last Name"/></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" value="Username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" value="Password" /></td>
				</tr>
				<tr>
					<td>User Access</td>
					<td>
						<select>
							<option value="1">Administrator</option>
							<option value="2">Doctor</option>
							<option value="3">Secretary</option>
						</select>
					</td>
				</tr>
			 	<tr>              
                <td><label id="save_button" class="button mouseout_button">Save</label></td>
	          </tr>
	      	</table>
		</form>
		</div>
	</div>	
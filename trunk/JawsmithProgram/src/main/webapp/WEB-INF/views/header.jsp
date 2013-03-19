
		<div class="" id="acc_panel">
			<label id="user_name" class="">Hi Admin!</label>
			<label id="logout_button" class="button mouseout_button">
				<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
			</label>
		</div>
	
		<!--This div is for the header.
			The header contains the company logo, the system user who is currently logged-in,
			the current date and time, the current user settings, and the log-out link.
		<div class="" id="acc_panel">
			<p>Welcome ${user.first_name} ${user.last_name}</p>
			<p>${serverTime}</p>
			<p>${headerMessage}</p>
			
			<form action="${pageContext.request.contextPath}/j_spring_security_logout">
				<input type="submit" value="logout" class="text_button" />
			</form>
			<form action="${pageContext.request.contextPath}/main">
				<input type="submit" value="Back to Main Page" class="text_button" />
			</form>
			<form action="${pageContext.request.contextPath}/renewPassword">
				<input type="submit" value="Change Password" class="text_button" />
			</form>
		</div>
		-->
		
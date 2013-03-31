
		<div class="" id="acc_panel">
			<label id="user_name" class="">Hi ${user.first_name} ${user.last_name}!</label>
			<label id="logout_button" class="button mouseout_button" onclick="buttonNextPage('${pageContext.request.contextPath}/j_spring_security_logout')">
				Log Out
			</label>
			<label id="user_name" class=""><a href="${pageContext.request.contextPath}/home">TEMPORARY HOME</a></label>
		</div>
	
		
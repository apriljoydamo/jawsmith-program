
<div class="" id="acc_panel">
	<label id="user_name" class="">Hi ${user.first_name} ${user.last_name}!</label>
	<label style="position:relative; top: 33px;" onclick="buttonNextPage('${pageContext.request.contextPath}/home')" class="button mouseout_button">HOME</label> 
	<label id="logout_button" class="button mouseout_button" onclick="buttonNextPage('${pageContext.request.contextPath}/j_spring_security_logout')">Log Out</label>
</div>


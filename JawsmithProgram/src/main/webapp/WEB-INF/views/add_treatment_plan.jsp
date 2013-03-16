
		<div>
			<h1>TREATMENT PLAN</h1>
			
			<form action="${pageContext.request.contextPath}/add_record" method="POST">
				Treatment:
				<input type="text" name="treatment" value="" />	
				<input type="text" name="fee" value="Fee" />	
				
				<br/>
				
				Alternate Treatment:
				<input type="text" name="alternateTreatment" value="" />	
				<input type="text" name="altFee" value="Fee" />
				
				<input type="submit" value="Save"/>
			</form>
		</div>
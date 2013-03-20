	<!-- UNUSED -->
		<div id="add_patient_div">
		
			<form action="/${pageContext.request.contextPath}/add_patient" method="POST">
				<input type="text" name="last_name" value="Last Name"/>			
				<input type="text" name="first_name" value="First Name" />
				<input type="text" name="middle_name" value="Middle Name" />
				<br/>
				Date of Birth: 	<input type="text" name="dob" value="mm/dd/yyyy" />
				<br/>
					Sex:	<select name="sex">
							<option value="M">Male</option>
							<option value="F">Female</option>
						</select>
				<br/>
				<input type="text" name="rel_status" value="Relationship Status" />
				<br/><br/>
				<input type="text" name="address" value="Address" />
				<input type="text" name="city" value="City" />
				<br/>
				<input type="text" name="tel_num" value="Tel No." />
				<input type="text" name="mobile_num" value="Mobile No." />
				<input type="text" name="email" value="E-mail" />
				<br/><br/>		
				<input type="text" name="occupation" value="Occupation" />
				<input type="text" name="religion" value="Religion" />
				<br/><br/>
				<input type="text" name="referred_by" value="Referred By" />
				<input type="text" name="guardian" value="Guardian" />
				
				<input type="submit" value="Save"/>
				
			</form>
		</div>
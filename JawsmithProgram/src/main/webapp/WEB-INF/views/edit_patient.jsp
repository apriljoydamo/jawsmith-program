<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="register_div" class="modalDialog">
		<div id="register_panel" class="">
	      <label id="add_patient_label">EDIT PATIENT</label>
	      <a href="#close" class="close_reg close" title="">X</a>
	      <form id="add_patient_form" action="${pageContext.request.contextPath}/patient/edit" method="POST" >
	        <table>
	          <tr>
	                <td>Patient No: </td>
	                <td><input type="text" id="add_patient_num" name="patient_num" class="" value="${patient.patient_num}"/></td> 
	          </tr>
	          <tr>
	                <td>First Name: </td>
	                <td><input type="text" id="add_patient_first_name" name="first_name" class="" value="${patient.first_name}"/></td> 
	          </tr>
	          <tr>              
	                <td>Middle Name: </td>
	                <td><input type="text" id="add_patient_middle_name" name="middle_name" class="" value="${patient.middle_name}"/></td> 
	          </tr>
	          <tr>              
	                <td>Last Name: </td>
	                <td><input type="text" id="add_patient_last_name" name="last_name" class="" value="${patient.last_name}"/></td> 
	          </tr>
	          <tr>              
	                <td>Date of Birth: </td>
	                <td><input placeholder="MM/dd/yyyy" type="text" id="add_patient_date_of_birth" name="dob" class="" value="<fmt:formatDate value='${patient.birthday}' pattern='MM/dd/yyyy'/>" /></td> 
	          </tr>
	          <tr>              
	                <td>Gender: </td>
	                <td><label><input type="radio" name="add_patient_sex" value="Male" ${patient.sex=="M" ? 'checked' : ''}/>Male</label>
	        			<label><input type="radio" name="add_patient_sex" value="Female" ${patient.sex=="F" ? 'checked' : ''}/>Female</label></td>  
	          </tr>
	          <tr>              
	                <td>Marital Status: </td>
	                <td><select name="rel_status" id="add_patient_marital_status">
	                      <option value="single" ${patient.relationship_status=='single' ? 'selected' : ''}>Single</option>
	                      <option value="married" ${patient.relationship_status=='married' ? 'selected' : ''}>Married</option>
	                      <option value="widow" ${patient.relationship_status=='widow' ? 'selected' : ''}>Widow</option>
	                      <option value="divorced" ${patient.relationship_status=='divorced' ? 'selected' : ''}>Divorced</option>
	                      <option value="seperated" ${patient.relationship_status=='seperated' ? 'selected' : ''}>Seperated</option>
		                  </select>
		           	</td> 
	          </tr>
	          <tr>              
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Postal Address: </td>
	                <td><textarea id="add_patient_postal_address" name="address" class="">${patient.address}</textarea></td> 
	          </tr>
	          <tr>              
	                <td>Home Phone No. </td>
	                <td><input type="text" id="add_patient_home_no" name="tel_num" class="" value="${patient.telephone_number}"/></td> 
	          </tr>
	          <tr>              
	                <td>Mobile Number: </td>
	                <td><input type="text" id="add_patient_mobile_no" name="mobile_num" class="" value="${patient.mobile_number}"/></td> 
	          </tr>
	          <tr>              
	                <td>E-mail: </td>
	                <td><input type="text" id="add_patient_email" name="email" class="" value="${patient.email_address}"/></td> 
	          </tr>
	          <tr>               
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Nationality: </td>
	                <td><input type="text" id="add_patient_nationality" name="nationality" class="" value="${patient.nationality}"/></td> 
	          </tr>
	          <tr>              
	                <td>Occupation: </td>
	                <td><input type="text" id="add_patient_occupation" name="occupation" class="" value="${patient.occupation}"/></td> 
	          </tr>
	          <tr>              
	                <td>Religion: </td>
	                <td><input type="text" id="add_patient_religion" name="religion" class="" value="${patient.religion}"/></td> 
	          </tr>
	          <tr>              
	                <td>Guardian: </td>
	                <td><input type="text" id="add_patient_guardian" name="guardian" class="" value="${patient.guardian}"/></td> 
	          </tr>
	          <tr>              
	                <td>Referred by: </td>
	                <td><input type="text" id="add_patient_referred_by" name="referred_by" class="" value="${patient.referred_by}"/></td> 
	          </tr>
	          
	          <c:if test="${user.access==1}">
	          <tr>              
	                <td>Patient Status: </td>
	                <td><select name="status" id="add_patient_status">
	                      <option value="true" ${patient.status=='true' ? 'selected' : ''}>Active</option>
	                      <option value="false" ${patient.status=='false' ? 'selected' : ''}>Inactive</option>
		                  </select></td> 
	          </tr>
	          </c:if>
	          
	          <tr>              
	                <td><label id="save_button" class="button mouseout_button" onclick="validatePatient()" >Save</label></td>
	          </tr>
	      	</table>
	      </form>
	  </div>
	</div>
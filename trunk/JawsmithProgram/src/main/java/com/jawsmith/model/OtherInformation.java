package com.jawsmith.model;

import java.util.Date;

public class OtherInformation {
	private int other_info_id;
	private String chief_complaint;
	private String diagnosis;
	private Date last_visit_date;
	private int patient_id;
	
	public int getOther_info_id() {
		return other_info_id;
	}
	public void setOther_info_id(int other_info_id) {
		this.other_info_id = other_info_id;
	}
	public String getChief_complaint() {
		return chief_complaint;
	}
	public void setChief_complaint(String chief_complaint) {
		this.chief_complaint = chief_complaint;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}

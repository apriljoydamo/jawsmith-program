package com.jawsmith.model;

import java.util.Date;

public class MedicalHistory {
	private int medical_history_id;
	private Date last_visit_date;
	private String question_id;
	private String answer;
	private int patient_id;
	
	public int getMedical_history_id() {
		return medical_history_id;
	}
	public void setMedical_history_id(int medical_history_id) {
		this.medical_history_id = medical_history_id;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}

	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question) {
		this.question_id = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}

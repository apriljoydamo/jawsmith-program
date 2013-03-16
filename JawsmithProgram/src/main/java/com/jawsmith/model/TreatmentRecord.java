package com.jawsmith.model;

import java.sql.Date;

public class TreatmentRecord {
	private int treatment_record_id;
	private Date last_visit_date;
	private String tooth_number;
	private String description;
	private String prescription;
	private float debit;
	private Date credit_date;
	private float credit_amount;
	private int patient_id;
	
	public int getTreatment_record_id() {
		return treatment_record_id;
	}
	public void setTreatment_record_id(int treatment_record_id) {
		this.treatment_record_id = treatment_record_id;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	public String getTooth_number() {
		return tooth_number;
	}
	public void setTooth_number(String tooth_number) {
		this.tooth_number = tooth_number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public float getDebit() {
		return debit;
	}
	public void setDebit(float debit) {
		this.debit = debit;
	}
	public Date getCredit_date() {
		return credit_date;
	}
	public void setCredit_date(Date credit_date) {
		this.credit_date = credit_date;
	}
	public float getCredit_amount() {
		return credit_amount;
	}
	public void setCredit_amount(float credit_amount) {
		this.credit_amount = credit_amount;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}

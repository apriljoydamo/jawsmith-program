package com.jawsmith.model;

import java.sql.Date;

public class TreatmentPlan {
	private int treatment_plan_id;
	private Date treatment_date;
	private String treatment;
	private float treatment_fee;
	private String alternative_treatment;
	private float alternative_treatment_fee;
	private int patient_id;
	
	
	public int getTreatment_plan_id() {
		return treatment_plan_id;
	}
	public void setTreatment_plan_id(int treatment_plan_id) {
		this.treatment_plan_id = treatment_plan_id;
	}
	public Date getTreatment_date() {
		return treatment_date;
	}
	public void setTreatment_date(Date treatment_date) {
		this.treatment_date = treatment_date;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public float getTreatment_fee() {
		return treatment_fee;
	}
	public void setTreatment_fee(float treatment_fee) {
		this.treatment_fee = treatment_fee;
	}
	public String getAlternative_treatment() {
		return alternative_treatment;
	}
	public void setAlternative_treatment(String alternative_treatment) {
		this.alternative_treatment = alternative_treatment;
	}
	public float getAlternative_treatment_fee() {
		return alternative_treatment_fee;
	}
	public void setAlternative_treatment_fee(float alternative_treatment_fee) {
		this.alternative_treatment_fee = alternative_treatment_fee;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}


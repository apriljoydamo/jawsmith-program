package com.jawsmith.model;

import java.util.Date;

public class DentalHistory {
	private int dental_his_id;
	private Date last_visit_date;
	private Boolean fluoride_treatment;
	private Boolean orthodontic_treatment;
	private Boolean pulp_therapy;
	private Boolean temporo_mandibular;
	private Boolean periodontal_therapy;
	private Boolean dental_surgery;
	private int extraction;
	private int patient_id;
	
	
	
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	public int getExtraction() {
		return extraction;
	}
	public void setExtraction(int extraction) {
		this.extraction = extraction;
	}
	public int getDental_his_id() {
		return dental_his_id;
	}
	public void setDental_his_id(int dental_his_id) {
		this.dental_his_id = dental_his_id;
	}
	public Boolean getFluoride_treatment() {
		return fluoride_treatment;
	}
	public void setFluoride_treatment(Boolean fluoride_treatment) {
		this.fluoride_treatment = fluoride_treatment;
	}
	public Boolean getOrthodontic_treatment() {
		return orthodontic_treatment;
	}
	public void setOrthodontic_treatment(Boolean orthodontic_treatment) {
		this.orthodontic_treatment = orthodontic_treatment;
	}
	public Boolean getPulp_therapy() {
		return pulp_therapy;
	}
	public void setPulp_therapy(Boolean pulp_therapy) {
		this.pulp_therapy = pulp_therapy;
	}
	public Boolean getTemporo_mandibular() {
		return temporo_mandibular;
	}
	public void setTemporo_mandibular(Boolean temporo_mandibular) {
		this.temporo_mandibular = temporo_mandibular;
	}
	public Boolean getPeriodontal_therapy() {
		return periodontal_therapy;
	}
	public void setPeriodontal_therapy(Boolean periodontal_therapy) {
		this.periodontal_therapy = periodontal_therapy;
	}
	public Boolean getDental_surgery() {
		return dental_surgery;
	}
	public void setDental_surgery(Boolean dental_surgery) {
		this.dental_surgery = dental_surgery;
	}

	
}



package com.jawsmith.model;

import java.sql.Date;

public class ClinicalExamination {
	private int clinical_exam_id;
	private Date last_visit_date;
	private String gingival_color;
	private String consistency_of_gingival;
	private String tounge;
	private String oral_hygiene;
	private String lymph_nodes;
	private int patient_id;
	
	
	public String getConsistency_of_gingival() {
		return consistency_of_gingival;
	}
	public void setConsistency_of_gingival(String consistency_of_gingival) {
		this.consistency_of_gingival = consistency_of_gingival;
	}
	public int getClinical_exam_id() {
		return clinical_exam_id;
	}
	public void setClinical_exam_id(int clinical_exam_id) {
		this.clinical_exam_id = clinical_exam_id;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	public String getGingival_color() {
		return gingival_color;
	}
	public void setGingival_color(String gingival_color) {
		this.gingival_color = gingival_color;
	}
	public String getTounge() {
		return tounge;
	}
	public void setTounge(String tounge) {
		this.tounge = tounge;
	}
	public String getOral_hygiene() {
		return oral_hygiene;
	}
	public void setOral_hygiene(String oral_hygiene) {
		this.oral_hygiene = oral_hygiene;
	}
	public String getLymph_nodes() {
		return lymph_nodes;
	}
	public void setLymph_nodes(String lymph_nodes) {
		this.lymph_nodes = lymph_nodes;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}
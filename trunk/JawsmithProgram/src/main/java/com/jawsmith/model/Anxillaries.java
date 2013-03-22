package com.jawsmith.model;

import java.util.Date;

public class Anxillaries {
	private int anxillaries_id;
	private Date last_visit_date;
	private String bleeding_time;
	private String blood_pressure;
	private String radiographic_interpretation;
	private String clotting_time;
	private String blood_sugar;
	private int patient_id;
	
	
	public int getAnxillaries_id() {
		return anxillaries_id;
	}
	public void setAnxillaries_id(int anxillaries_id) {
		this.anxillaries_id = anxillaries_id;
	}
	public String getRadiographic_interpretation() {
		return radiographic_interpretation;
	}
	public void setRadiographic_interpretation(String radiographic_interpretation) {
		this.radiographic_interpretation = radiographic_interpretation;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	public String getBleeding_time() {
		return bleeding_time;
	}
	public void setBleeding_time(String bleeding_time) {
		this.bleeding_time = bleeding_time;
	}
	public String getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public String getClotting_time() {
		return clotting_time;
	}
	public void setClotting_time(String clotting_time) {
		this.clotting_time = clotting_time;
	}
	public String getBlood_sugar() {
		return blood_sugar;
	}
	public void setBlood_sugar(String blood_sugar) {
		this.blood_sugar = blood_sugar;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
}

package com.jawsmith.model;

import java.sql.Date;

public class Occlusion {
	private int occlusion_id;
	private Date last_visit_date;
	private String class_1;
	private String class_2;
	private String class_3;
	private int patient_id;
	
	public int getOcclusion_id() {
		return occlusion_id;
	}
	public void setOcclusion_id(int occlusion_id) {
		this.occlusion_id = occlusion_id;
	}
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	public String getClass_1() {
		return class_1;
	}
	public void setClass_1(String class_1) {
		this.class_1 = class_1;
	}
	public String getClass_2() {
		return class_2;
	}
	public void setClass_2(String class_2) {
		this.class_2 = class_2;
	}
	public String getClass_3() {
		return class_3;
	}
	public void setClass_3(String class_3) {
		this.class_3 = class_3;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}

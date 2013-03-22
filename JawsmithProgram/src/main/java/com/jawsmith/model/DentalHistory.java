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
	private Boolean extraction;
	private int patient_id;
	
	
	/**
	 * @return the dental_his_id
	 */
	public int getDental_his_id() {
		return dental_his_id;
	}
	/**
	 * @param dental_his_id the dental_his_id to set
	 */
	public void setDental_his_id(int dental_his_id) {
		this.dental_his_id = dental_his_id;
	}
	/**
	 * @return the last_visit_date
	 */
	public Date getLast_visit_date() {
		return last_visit_date;
	}
	/**
	 * @param last_visit_date the last_visit_date to set
	 */
	public void setLast_visit_date(Date last_visit_date) {
		this.last_visit_date = last_visit_date;
	}
	/**
	 * @return the fluoride_treatment
	 */
	public Boolean getFluoride_treatment() {
		return fluoride_treatment;
	}
	/**
	 * @param fluoride_treatment the fluoride_treatment to set
	 */
	public void setFluoride_treatment(Boolean fluoride_treatment) {
		this.fluoride_treatment = fluoride_treatment;
	}
	/**
	 * @return the orthodontic_treatment
	 */
	public Boolean getOrthodontic_treatment() {
		return orthodontic_treatment;
	}
	/**
	 * @param orthodontic_treatment the orthodontic_treatment to set
	 */
	public void setOrthodontic_treatment(Boolean orthodontic_treatment) {
		this.orthodontic_treatment = orthodontic_treatment;
	}
	/**
	 * @return the pulp_therapy
	 */
	public Boolean getPulp_therapy() {
		return pulp_therapy;
	}
	/**
	 * @param pulp_therapy the pulp_therapy to set
	 */
	public void setPulp_therapy(Boolean pulp_therapy) {
		this.pulp_therapy = pulp_therapy;
	}
	/**
	 * @return the temporo_mandibular
	 */
	public Boolean getTemporo_mandibular() {
		return temporo_mandibular;
	}
	/**
	 * @param temporo_mandibular the temporo_mandibular to set
	 */
	public void setTemporo_mandibular(Boolean temporo_mandibular) {
		this.temporo_mandibular = temporo_mandibular;
	}
	/**
	 * @return the periodontal_therapy
	 */
	public Boolean getPeriodontal_therapy() {
		return periodontal_therapy;
	}
	/**
	 * @param periodontal_therapy the periodontal_therapy to set
	 */
	public void setPeriodontal_therapy(Boolean periodontal_therapy) {
		this.periodontal_therapy = periodontal_therapy;
	}
	/**
	 * @return the dental_surgery
	 */
	public Boolean getDental_surgery() {
		return dental_surgery;
	}
	/**
	 * @param dental_surgery the dental_surgery to set
	 */
	public void setDental_surgery(Boolean dental_surgery) {
		this.dental_surgery = dental_surgery;
	}
	/**
	 * @return the extraction
	 */
	public Boolean getExtraction() {
		return extraction;
	}
	/**
	 * @param extraction the extraction to set
	 */
	public void setExtraction(Boolean extraction) {
		this.extraction = extraction;
	}
	/**
	 * @return the patient_id
	 */
	public int getPatient_id() {
		return patient_id;
	}
	/**
	 * @param patient_id the patient_id to set
	 */
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}



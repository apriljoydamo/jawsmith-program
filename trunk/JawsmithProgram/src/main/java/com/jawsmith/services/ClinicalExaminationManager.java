package com.jawsmith.services;

import java.util.List;

import com.jawsmith.interfaces.ClinicalExaminationMethods;
import com.jawsmith.interfaces.DataAccesses;



public class ClinicalExaminationManager implements DataAccesses, ClinicalExaminationMethods{

	private DataAccesses dataAccesses;
	private ClinicalExaminationMethods clinicalExaminationMethods;
	/**
	 * @return the dataAccesses
	 */
	public DataAccesses getDataAccesses() {
		return dataAccesses;
	}

	/**
	 * @param dataAccesses the dataAccesses to set
	 */
	public void setDataAccesses(DataAccesses dataAccesses) {
		this.dataAccesses = dataAccesses;
	}


	/**
	 * @return the clinicalExaminationMethods
	 */
	public ClinicalExaminationMethods getClinicalExaminationMethods() {
		return clinicalExaminationMethods;
	}

	/**
	 * @param clinicalExaminationMethods the clinicalExaminationMethods to set
	 */
	public void setClinicalExaminationMethods(
			ClinicalExaminationMethods clinicalExaminationMethods) {
		this.clinicalExaminationMethods = clinicalExaminationMethods;
	}

	public void save(Object obj) {
		dataAccesses.save(obj);
		
	}

	public void update(Object obj) {
		dataAccesses.update(obj);
		
	}

	public void delete(Object obj) {
		dataAccesses.delete(obj);
		
	}

	public Object findById(int i) {
		return dataAccesses.findById(i);
	}

	public List getAll() {
		return dataAccesses.getAll();
	}

	@Override
	public Object findByPatientId(int patientId) {
		return clinicalExaminationMethods.findByPatientId(patientId);
	}

}
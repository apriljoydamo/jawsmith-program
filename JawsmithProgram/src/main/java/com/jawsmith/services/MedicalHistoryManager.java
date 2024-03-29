package com.jawsmith.services;

import java.util.Date;
import java.util.List;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.MedicalHistoryMethods;



public class MedicalHistoryManager implements DataAccesses, MedicalHistoryMethods {

	private DataAccesses dataAccesses;
	private MedicalHistoryMethods medicalHistoryMethods;
	
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
	 * @return the medicalHistoryMethods
	 */
	public MedicalHistoryMethods getMedicalHistoryMethods() {
		return medicalHistoryMethods;
	}

	/**
	 * @param medicalHistoryMethods the medicalHistoryMethods to set
	 */
	public void setMedicalHistoryMethods(MedicalHistoryMethods medicalHistoryMethods) {
		this.medicalHistoryMethods = medicalHistoryMethods;
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
		return medicalHistoryMethods.findByPatientId(patientId);
	}

	@Override
	public List findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		return medicalHistoryMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
	}

}
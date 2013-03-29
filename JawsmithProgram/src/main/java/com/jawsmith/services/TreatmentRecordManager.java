package com.jawsmith.services;
import java.util.List;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TreatmentRecordMethods;



public class TreatmentRecordManager implements DataAccesses, TreatmentRecordMethods{

	private DataAccesses dataAccesses;
	private TreatmentRecordMethods treatmentRecordMethods;
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
	 * @return the treatmentRecordMethods
	 */
	public TreatmentRecordMethods getTreatmentRecordMethods() {
		return treatmentRecordMethods;
	}

	/**
	 * @param treatmentRecordMethods the treatmentRecordMethods to set
	 */
	public void setTreatmentRecordMethods(
			TreatmentRecordMethods treatmentRecordMethods) {
		this.treatmentRecordMethods = treatmentRecordMethods;
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
	public List findByPatientId(int patientId) {
		return treatmentRecordMethods.findByPatientId(patientId);
	}

}
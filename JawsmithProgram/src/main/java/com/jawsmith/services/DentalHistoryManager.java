package com.jawsmith.services;

import java.util.Date;
import java.util.List;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.DentalHistoryMethods;



public class DentalHistoryManager implements DataAccesses,DentalHistoryMethods{

	private DataAccesses dataAccesses;
	private DentalHistoryMethods dentalHistoryMethods;
	
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
	 * @return the dentalHistoryMethods
	 */
	public DentalHistoryMethods getDentalHistoryMethods() {
		return dentalHistoryMethods;
	}

	/**
	 * @param dentalHistoryMethods the dentalHistoryMethods to set
	 */
	public void setDentalHistoryMethods(DentalHistoryMethods dentalHistoryMethods) {
		this.dentalHistoryMethods = dentalHistoryMethods;
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
		return dentalHistoryMethods.findByPatientId(patientId);
	}

	@Override
	public Object findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		return dentalHistoryMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
	}

}
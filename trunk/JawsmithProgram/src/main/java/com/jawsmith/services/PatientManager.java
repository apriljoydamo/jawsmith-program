package com.jawsmith.services;
import java.util.List;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.PatientMethods;



public class PatientManager implements DataAccesses, PatientMethods{

	private DataAccesses dataAccesses;
	private PatientMethods patientMethods;
	
	public PatientMethods getPatientMethods() {
		return patientMethods;
	}

	public void setPatientMethods(PatientMethods patientMethods) {
		this.patientMethods = patientMethods;
	}

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
	public List paginatedView(int offset, int numOfRecords) {
		return (List)patientMethods.paginatedView(offset, numOfRecords);
	}

	@Override
	public int getNumOfRecords() {
		return (int)patientMethods.getNumOfRecords();
	}

}
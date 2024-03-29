package com.jawsmith.services;
import java.util.Date;
import java.util.List;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.OtherInformationMethods;



public class OtherInformationManager implements DataAccesses, OtherInformationMethods{

	private DataAccesses dataAccesses;
	private OtherInformationMethods otherInformationMethods;
	
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
	 * @return the otherInformationMethods
	 */
	public OtherInformationMethods getOtherInformationMethods() {
		return otherInformationMethods;
	}

	/**
	 * @param otherInformationMethods the otherInformationMethods to set
	 */
	public void setOtherInformationMethods(
			OtherInformationMethods otherInformationMethods) {
		this.otherInformationMethods = otherInformationMethods;
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
		return otherInformationMethods.findByPatientId(patientId);
	}

	@Override
	public Object findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		return otherInformationMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
	}

}
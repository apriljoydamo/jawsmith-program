package com.jawsmith.services;

import java.util.Date;
import java.util.List;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.OcclusionMethods;



public class OcclusionManager implements DataAccesses, OcclusionMethods{

	private DataAccesses dataAccesses;
	private OcclusionMethods occlusionMethods;
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
	 * @return the occlusionMethods
	 */
	public OcclusionMethods getOcclusionMethods() {
		return occlusionMethods;
	}

	/**
	 * @param occlusionMethods the occlusionMethods to set
	 */
	public void setOcclusionMethods(OcclusionMethods occlusionMethods) {
		this.occlusionMethods = occlusionMethods;
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
		return occlusionMethods.findByPatientId(patientId);
	}

	@Override
	public Object findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		return occlusionMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
	}

}
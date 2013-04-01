package com.jawsmith.services;

import java.util.Date;
import java.util.List;

import com.jawsmith.interfaces.AnxillariesMethods;
import com.jawsmith.interfaces.DataAccesses;



public class AnxillariesManager implements DataAccesses, AnxillariesMethods{

	private DataAccesses dataAccesses;
	private AnxillariesMethods anxillariesMethods;
	
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
	 * @return the anxillariesMethods
	 */
	public AnxillariesMethods getAnxillariesMethods() {
		return anxillariesMethods;
	}

	/**
	 * @param anxillariesMethods the anxillariesMethods to set
	 */
	public void setAnxillariesMethods(AnxillariesMethods anxillariesMethods) {
		this.anxillariesMethods = anxillariesMethods;
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
		return anxillariesMethods.findByPatientId(patientId);
	}

	@Override
	public Object findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		return anxillariesMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
	}

}
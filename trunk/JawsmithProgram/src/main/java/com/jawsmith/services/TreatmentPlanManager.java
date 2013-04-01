package com.jawsmith.services;
import java.util.Date;
import java.util.List;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TreatmentPlanMethods;



public class TreatmentPlanManager implements DataAccesses, TreatmentPlanMethods{

	private DataAccesses dataAccesses;
	private TreatmentPlanMethods treatmentPlanMethods;
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
	 * @return the treatmentPlanMethods
	 */
	public TreatmentPlanMethods getTreatmentPlanMethods() {
		return treatmentPlanMethods;
	}

	/**
	 * @param treatmentPlanMethods the treatmentPlanMethods to set
	 */
	public void setTreatmentPlanMethods(TreatmentPlanMethods treatmentPlanMethods) {
		this.treatmentPlanMethods = treatmentPlanMethods;
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
		return treatmentPlanMethods.findByPatientId(patientId);
	}

	@Override
	public Object findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		return treatmentPlanMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
	}

}
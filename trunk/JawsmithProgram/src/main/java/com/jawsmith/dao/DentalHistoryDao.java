package com.jawsmith.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.DentalHistoryMethods;


public class DentalHistoryDao extends HibernateDaoSupport implements DataAccesses, DentalHistoryMethods{

	
	public void save(Object obj) {
		getHibernateTemplate().save(obj);
		
	}

	
	public void update(Object obj) {
		getHibernateTemplate().update(obj);
		
	}

	
	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
		
	}

	
	public Object findById(int i) {
		List list = getHibernateTemplate().find("from DentalHistory where DENTAL_HIS_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from DentalHistory");
		return list;
	}


	@Override
	public Object findByPatientId(int patientId) {
		List list = getHibernateTemplate().find("from DentalHistory where patients_PATIENT_ID=?",patientId);
		return list.get(0);
	}
}
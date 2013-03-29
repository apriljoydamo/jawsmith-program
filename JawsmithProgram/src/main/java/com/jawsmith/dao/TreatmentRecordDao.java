package com.jawsmith.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TreatmentRecordMethods;


public class TreatmentRecordDao extends HibernateDaoSupport implements DataAccesses, TreatmentRecordMethods{

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
		List list = getHibernateTemplate().find("from TreatmentRecord where TREATMENT_RECORD_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from TreatmentRecord");
		return list;
	}
	
	public List findByPatientId(int patientId) {
		List list = getHibernateTemplate().find("from TreatmentRecord where patients_PATIENT_ID=?",patientId);
		return list;
	}
}
package com.jawsmith.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.MedicalHistoryMethods;


public class MedicalHistoryDao extends HibernateDaoSupport implements DataAccesses, MedicalHistoryMethods{

	
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
		List list = getHibernateTemplate().find("from MedicalHistory where MED_HIS_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from MedicalHistory");
		return list;
	}


	@Override
	public Object findByPatientId(int patientId) {
		List list = getHibernateTemplate().find("from MedicalHistory where patients_PATIENT_ID=?",patientId);
		return list.get(0);
	}


	@Override
	public List findByPatientIdAndLastVisitDate(int patientId,
			Date lastVisitDate) {
		List list = getHibernateTemplate().find("from MedicalHistory where patients_PATIENT_ID='"+patientId+"' and LAST_VISIT_DATE='"+lastVisitDate+"'");
		return list;
	}
}
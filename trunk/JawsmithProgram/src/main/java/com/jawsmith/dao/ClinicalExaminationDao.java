package com.jawsmith.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.ClinicalExaminationMethods;
import com.jawsmith.interfaces.DataAccesses;


public class ClinicalExaminationDao extends HibernateDaoSupport implements DataAccesses, ClinicalExaminationMethods{

	
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
		List list = getHibernateTemplate().find("from ClinicalExamination where CLINIC_EXAM_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from ClinicalExamination");
		return list;
	}


	@Override
	public Object findByPatientId(int patientId) {
		List list = getHibernateTemplate().find("from ClinicalExamination where patients_PATIENT_ID=?",patientId);
		return list.get(0);
	}
}
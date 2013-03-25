package com.jawsmith.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.OtherInformationMethods;


public class OtherInformationDao extends HibernateDaoSupport implements DataAccesses, OtherInformationMethods{

	
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
		List list = getHibernateTemplate().find("from OtherInformation where OTHER_INFO_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from OtherInformation");
		return list;
	}


	@Override
	public Object findByPatientId(int patientId) {
		List list = getHibernateTemplate().find("from OtherInformation where patients_PATIENT_ID=?",patientId);
		return list.get(0);
	}
}
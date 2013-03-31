package com.jawsmith.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.PatientMethods;


public class PatientDao extends HibernateDaoSupport implements DataAccesses, PatientMethods{

	
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
		List list = getHibernateTemplate().find("from Patient where PATIENT_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from Patient ORDER BY LAST_NAME");
		return list;
	}
	
   public List paginatedView(int offset, int numOfRecord) {
	   List list = getHibernateTemplate().find("from Patient LIMIT "+offset+","+numOfRecord+" ");
		return list;
   }
}
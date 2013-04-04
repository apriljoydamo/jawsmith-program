package com.jawsmith.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TableMaintenanceMethods;


public class TableMaintenanceDao extends HibernateDaoSupport implements DataAccesses, TableMaintenanceMethods{

	
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
		List list = getHibernateTemplate().find("from TableMaintenance where TABLE_MAINTENANCE_ID=?",i);
		return list.get(0);
	}

	
	public List getAll() {
		List list = getHibernateTemplate().find("from TableMaintenance");
		return list;
	}


	@Override
	public List findAllByRefId(int ref_id) {
		List list = getHibernateTemplate().find("from TableMaintenance where REF_ID=?", ref_id);
		return list;
	}


	@Override
	public List findAllByCodeValue(String code_table_value) {
		List list = getHibernateTemplate().find("from TableMaintenance where CODE_TBL_VALUE=?",code_table_value);
		return list;
	}


	@Override
	public Object findByRefIdAndCodeValue(int ref_id, String code_table_value) {
		List list = getHibernateTemplate().find("from TableMaintenance where REF_ID="+ref_id+"and CODE_TBL_VALUE="+code_table_value);
		return list.get(0);
	}
}
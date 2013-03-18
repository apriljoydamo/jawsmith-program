package com.jawsmith.dao;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.SystemUserMethods;
import com.jawsmith.model.SystemUser;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class SystemUserDao extends HibernateDaoSupport implements DataAccesses, SystemUserMethods{

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
		List list = getHibernateTemplate().find("from SystemUser where USER_ID=?",i);
		return list.get(0);
	}

	public List getAll() {
		List list = getHibernateTemplate().find("from SystemUser");
		return list;
	}

	public Object findByName(String name) {
		List list = getHibernateTemplate().find("from SystemUser where USERNAME=?",name);
		return (SystemUser) list.get(0);
	}
}
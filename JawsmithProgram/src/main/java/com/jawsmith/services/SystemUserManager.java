package com.jawsmith.services;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.SystemUserMethods;

import java.util.List;


public class SystemUserManager  implements DataAccesses, SystemUserMethods{

	private DataAccesses dataAccesses;
	private SystemUserMethods systemMethods;
	


	public SystemUserMethods getSystemMethods() {
		return systemMethods;
	}

	public void setSystemMethods(SystemUserMethods systemMethods) {
		this.systemMethods = systemMethods;
	}

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

	public Object findByName(String name) {
		return systemMethods.findByName(name);
	}

}
package com.jawsmith.services;
import java.util.List;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TableMaintenanceMethods;



public class TableMaintenanceManager implements DataAccesses, TableMaintenanceMethods{

	private DataAccesses dataAccesses;
	private TableMaintenanceMethods tblMaintenanceMethods;
	
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
	 * @return the tblMaintenanceMethods
	 */
	public TableMaintenanceMethods getTblMaintenanceMethods() {
		return tblMaintenanceMethods;
	}

	/**
	 * @param tblMaintenanceMethods the tblMaintenanceMethods to set
	 */
	public void setTblMaintenanceMethods(
			TableMaintenanceMethods tblMaintenanceMethods) {
		this.tblMaintenanceMethods = tblMaintenanceMethods;
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
	public List findAllByRefId(int ref_id) {
		return tblMaintenanceMethods.findAllByRefId(ref_id);
	}

	@Override
	public List findAllByCodeValue(String code_table_value) {
		return tblMaintenanceMethods.findAllByCodeValue(code_table_value);
	}

}
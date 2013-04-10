package com.jawsmith.services;

import java.util.List;

import com.jawsmith.interfaces.DataAccesses;

public class ReportTableManager implements DataAccesses{

	private DataAccesses dataAccesses;
	
	
	/**
	 * @param dataAccesses the dataAccesses to set
	 */
	public void setDataAccesses(DataAccesses dataAccesses) {
		this.dataAccesses = dataAccesses;
	}

	/**
	 * @return the dataAccesses
	 */
	public DataAccesses getDataAccesses() {
		return dataAccesses;
	}

	@Override
	public void save(Object obj) {
		dataAccesses.save(obj);
	}

	@Override
	public void update(Object obj) {
		dataAccesses.update(obj);
	}

	@Override
	public void delete(Object obj) {
		dataAccesses.delete(obj);
	}

	@Override
	public Object findById(int i) {
		return dataAccesses.findById(i);
	}

	@Override
	public List getAll() {
		return dataAccesses.getAll();
	}

}

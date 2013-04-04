package com.jawsmith.interfaces;

import java.util.List;

public interface PatientMethods {
	Object paginatedView(int offset, int numOfRecords);
	int getNumOfRecords();
	List searchByLastname(String toSearch);
	List paginatedSearch(int offset, int numOfRecords,String toSearch);

}

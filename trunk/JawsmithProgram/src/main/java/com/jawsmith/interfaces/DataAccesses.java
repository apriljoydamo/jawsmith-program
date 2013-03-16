package com.jawsmith.interfaces;

import java.util.List;

public interface DataAccesses {
	void save(Object obj);
	void update(Object obj);
	void delete(Object obj);
	Object findById(int i);
	List getAll();
	
}

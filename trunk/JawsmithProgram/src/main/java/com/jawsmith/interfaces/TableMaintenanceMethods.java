package com.jawsmith.interfaces;

import java.util.List;

public interface TableMaintenanceMethods {
	List findAllByRefId(int ref_id);
	List findAllByCodeValue(String code_table_value);
	Object findByRefIdAndCodeValue(int ref_id, String code_table_value);
}

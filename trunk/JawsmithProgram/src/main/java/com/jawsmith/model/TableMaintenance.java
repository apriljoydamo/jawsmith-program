package com.jawsmith.model;

public class TableMaintenance {
	private int table_maintenance_id;
	private int reference_id;
	private String code_table_value;
	private String description;
	private Boolean status;
	
	
	public int getTable_maintenance_id() {
		return table_maintenance_id;
	}
	public void setTable_maintenance_id(int table_maintenance_id) {
		this.table_maintenance_id = table_maintenance_id;
	}
	public int getReference_id() {
		return reference_id;
	}
	public void setReference_id(int reference_id) {
		this.reference_id = reference_id;
	}
	public String getCode_table_value() {
		return code_table_value;
	}
	public void setCode_table_value(String code_table_value) {
		this.code_table_value = code_table_value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}

package com.jawsmith.model;

public class TableMaintenance {
	private int table_maintenance_id;
	private int reference_id;
	private String code_table_value;
	private String tbl_maintenance_description;
	private Boolean status;
	
	/**
	 * @return the table_maintenance_id
	 */
	public int getTable_maintenance_id() {
		return table_maintenance_id;
	}
	/**
	 * @param table_maintenance_id the table_maintenance_id to set
	 */
	public void setTable_maintenance_id(int table_maintenance_id) {
		this.table_maintenance_id = table_maintenance_id;
	}
	/**
	 * @return the reference_id
	 */
	public int getReference_id() {
		return reference_id;
	}
	/**
	 * @param reference_id the reference_id to set
	 */
	public void setReference_id(int reference_id) {
		this.reference_id = reference_id;
	}
	/**
	 * @return the code_table_value
	 */
	public String getCode_table_value() {
		return code_table_value;
	}
	/**
	 * @param code_table_value the code_table_value to set
	 */
	public void setCode_table_value(String code_table_value) {
		this.code_table_value = code_table_value;
	}
	/**
	 * @return the tbl_maintenance_description
	 */
	public String getTbl_maintenance_description() {
		return tbl_maintenance_description;
	}
	/**
	 * @param tbl_maintenance_description the tbl_maintenance_description to set
	 */
	public void setTbl_maintenance_description(String tbl_maintenance_description) {
		this.tbl_maintenance_description = tbl_maintenance_description;
	}
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}

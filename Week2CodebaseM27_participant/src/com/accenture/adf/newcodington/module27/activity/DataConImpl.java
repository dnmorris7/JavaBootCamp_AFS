package com.accenture.adf.newcodington.module27.activity;

//Spring Implementation to demonstrate connection with the Mysql 

import javax.sql.DataSource;

public class DataConImpl implements DataConnection{
private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
	public DataSource dbcon() {
		
		return dataSource;
	}

}

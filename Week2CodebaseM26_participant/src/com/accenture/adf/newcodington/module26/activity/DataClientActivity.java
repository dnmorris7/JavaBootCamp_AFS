package com.accenture.adf.newcodington.module26.activity;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
/**
 * Client class that Inserts record into ZOO table and
 * retreives all records from ZOO table to display in console
 */
public class DataClientActivity {

	/**
	 * Main method that starts execution of Program
	 * @param args
	 */
	public static void main(String[] args) {

		// Resource object to read configuration from "connection.xml" file from SRC folder
		Resource res = new ClassPathResource("connection.xml");
		// Instantiation of Beanfactory based on Configuration file
		BeanFactory fact = new XmlBeanFactory(res);
		// Defining bean using Dependency Injection lookups in Configuration file
		DataConnection bean1 = (DataConnection) fact.getBean("datacon");
		// Establishing Datasource for connectivity to MySql database
		DataSource ds = bean1.dbcon();
	

		Connection con;
		try {
			// Connection established using Datasource
			con = ds.getConnection();
		
		// TODO  Use preparedstatement for update records of ZOO table through SQL query
		// TODO  for a particular ZOOID i.e, Z001 and provide ZooName and Animalcount with different values
		
		
			// TODO Please enter your code here	
			
			
		// TODO Call executeupdate method for the inserting the record and capturing how many records affected 
			// TODO Please enter code here		
		
		
		// TODO Display success message when the value in row field is equal to 1
			// TODO Please enter code here
		
		// TODO Use preparedstatement for displaying records into ZOO table through SQL query
		// and store output into an resultset

			// TODO Please enter code here	
			
		// TODO Display data into console using LOOP constructs
		
			// TODO Please enter code here
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}

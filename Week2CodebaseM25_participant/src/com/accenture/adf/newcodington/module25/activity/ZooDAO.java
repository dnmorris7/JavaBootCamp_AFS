package com.accenture.adf.newcodington.module25.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DAO class to demonstrate the usage of mySQL connector and insert records into
 * Zoo table using JDBC
 */
public class ZooDAO {

	// Connection from JDBC API for establishing connection to underlying
	// database
	Connection connection = null;
	// PreparedStatement is used to execute pre-compiled SQL queries for JDBC
	// insertions
	PreparedStatement statement = null;
	// Constant string that captures QUERY to be executed by JDBC statements
	static String INSERTQUERY = "insert into zoo(zooid,zooname,animalcount,placeid) values (?,?,?,?)";

	/**
	 * Method to insert record in the ZOO table and return boolean message
	 * depending on the no. of records effected by the transaction.
	 * 
	 * @param Zooid
	 * @param zooname
	 * @param animalCount
	 * @param placeid
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean insertRecord(String zooid, String zooname, int animalCount,
			String placeid) throws SQLException, ClassNotFoundException {
		//step 2 create connection
		connection=ConnectionToDB.getConnection();
		statement = connection.prepareStatement(INSERTQUERY); // executing
																// insert query
																// to load data
																// in ZOO table
		// TODO set zooid,zooname, animalcount and placeid as parameters for statement object
		// and create variable "insertStatus" of int type for storing status of Transaction 
		// close connection
		// check if value in "insertStatus" is greater than 0 , return true value else false 
		
		//step 3 create statement
		statement.setString(1, zooid);
		statement.setString(2, zooname);
		statement.setInt(3, animalCount);
		statement.setString(4, placeid);
		// TODO Enter code here
		
		//step 4 - execute update
		int insertStatus = statement.executeUpdate();
		System.out.println(insertStatus);
		
		//step 5 - handle results
		boolean result = false;
		if(insertStatus>0)
			result= true;
		return result; // replace "false" with if-else condition
	}


}

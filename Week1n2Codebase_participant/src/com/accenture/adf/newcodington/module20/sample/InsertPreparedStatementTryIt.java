package com.accenture.adf.newcodington.module20.sample;

import java.sql.*;

/**
 * Topic : JDBC
 * 
 * Instructions : 1. Use JDBC API to insert a record in Employee table in
 * Participant database 2. Use PreparedStatment interface for the same. 3. Code
 * as per the TODOs
 * 
 * 
 */

public class InsertPreparedStatementTryIt {

	public static void main(String[] args) {
		try {
			// TODO 1 Obtain a connection
			Connection c = null;
			c = ConnectionToDBTryIt.getConnection();
			if (c == null) {
				System.out.println("No connection availiable.");
				System.exit(0);
			} else
				System.out.println("Successful connection.");
			Thread.sleep(500);

			PreparedStatement ps = c
					.prepareStatement("insert  into faculty.student (" +
							"Student_id, Student_name, Course_id) values (?,?,?)");
			c.setAutoCommit(false);
			// TODO 2 Check if connection object is not null, print a message
			// for successful connection
			/*
			 * ps.setInt(1, 444); ps.setString(2, "Thomas"); ps.setInt(3, 101);
			 */
			
			 ps.setInt(1, 4243); ps.setString(2, "Frank"); ps.setInt(3, 101);
			 

			// TODO 3 Create a PreparedStatement with a query
			// "insert into Employee values(?,?,?)"
			int results = ps.executeUpdate();
			// TODO 4 Change parameters to appropriate values
			//ps.executeUpdate();
			c.commit();
			// TODO 5 Set autoCommit to false
			System.out.println(results + " record(s) were inserted");
			// TODO 6 Execute this query using executeUpdate()

			// TODO 7 commit

			// TODO 8 Print the number of rows deleted

			// TODO 9 Close the connection

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

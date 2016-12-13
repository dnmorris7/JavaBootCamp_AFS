package com.accenture.adf.newcodington.module20.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Topic : JDBC
 * 
 * Instructions : 1. Use JDBC API to insert a record in Student table in Faculty
 * database 2. Use PreparedStatement interface for the same. 3. Code as per the
 * TODOs
 * 
 * 
 */

public class InsertPreparedStatementDemo {

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

			PreparedStatement ps = c.prepareStatement("select * from student");

			// TODO 2 Check if connection object is not null, print a message
			// for successful connection
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String sid = rs.getString(1);
				String sname = rs.getString(2);
				String cid = rs.getString(3);

				System.out.println(sid + ":" + sname + ":" + cid);
			}
			// TODO 3 Create a PreparedStatement with a query
			// "insert into Student values(?,?,?)"

			// TODO 4 Replace ? with appropriate values

			// TODO 5 Set autoCommit to false

			// TODO 6 Execute this query using executeUpdate()

			// TODO 7 commit

			// TODO 8 Print how many rows got updated

			// TODO 9 Close the connection
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

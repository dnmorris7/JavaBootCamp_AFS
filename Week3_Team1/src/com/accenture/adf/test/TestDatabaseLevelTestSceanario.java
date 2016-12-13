
package com.accenture.adf.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.accenture.adf.businesstier.controller.VisitorController;
import com.accenture.adf.businesstier.controller.EventController;
import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;
import com.accenture.adf.helper.FERSDataConnection;
import com.mysql.jdbc.Statement;


public class TestDatabaseLevelTestSceanario {
	private Visitor visitor;
	private VisitorDAO visitorDAO;
	private VisitorController visitorController;
	private EventController eventController;
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;
	private EventDAO dao;	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/festivaldatabase";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "abcd1234";
	
	@Before

	public void begin()throws Exception{
		visitor = new Visitor();
		visitorDAO = new VisitorDAO();
	}
	@After
	public void end() throws Exception{
		visitor = null;
		visitorDAO = null;
		
	}
	
	//USE CASE 2 VISITOR LOGIN STARTS HERE
	
	
	@Test 
	Visitor TestSearchUser_Positive(){
		
		if
		assertEquals( ,visitorDAO.searchUser("bsmith", "password"));
		
		return visitor;
		
	}
	
	//USE CASE 2 VISITOR LOGIN ENDS HERE
}

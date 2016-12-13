package com.accenture.adf.newcodington.module27.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.accenture.adf.newcodington.module27.activity.DataConnection;

public class MuseumDao {
	
	public int insertRecord(String museumid, String museumname, String museumtype, String buildingid) throws SQLException, ClassNotFoundException
	{
		// Resource object to read configuration from "connection.xml" file from SRC folder
		Resource res = new ClassPathResource("connection.xml");
		// Instantiation of Beanfactory based on Configuration file
		BeanFactory fact = new XmlBeanFactory(res);
		// Defining bean using Dependency Injection lookups in Configuration file
		DataConnection bean1 = (DataConnection) fact.getBean("datacon");
		// Establishing Datasource for connectivity to MySql database
		DataSource ds = bean1.dbcon();
		Connection con=ds.getConnection();		
		PreparedStatement statement=con.prepareStatement("insert into museum values(?,?,?,?)");
		statement.setString(1, museumid);
		statement.setString(2, museumname);
		statement.setString(3, museumtype);
		statement.setString(4,buildingid);
		
		int recUpdated=statement.executeUpdate();
		return recUpdated;
	}

}

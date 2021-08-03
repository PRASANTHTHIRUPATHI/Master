package com.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;



public class DataBaseUtilities 
{
	Connection conn=null;
	ResultSet result=null;
public void connectToDB()
{
	Driver driverRef;
	try
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(IConstantAndPath.dbURI,IConstantAndPath.dbUserName,IConstantAndPath.dbpassword);
	}
	catch(Exception e)
	{
		
	}
}
/**
 * This method will close database connection
 * @throws SQLException
 */
public void closeDB() throws SQLException
{
conn.close();
}
/**
 * 
 * @param query
 * @param columnindex
 * @param expdata
 * @return
 * @throws SQLException
 */
public String executequeryandGetData(String query,int columnindex,String expdata) throws SQLException
{
	boolean flag=false;
	 result = conn.createStatement().executeQuery(query);
	while(result.next())
	{
		if(result.getString(columnindex).equalsIgnoreCase(expdata))
		{
			flag=true;
			break;
			
		}
		
		/*else
			
		{
			System.out.println(expdata+"data deleted");
		}*/
	}
	if(flag)
	{
		System.out.println(expdata + "data verified in database");
		return expdata;
	}
	else
	{
		System.out.println(expdata +"data not verified");
		return expdata;
	}
}
}
